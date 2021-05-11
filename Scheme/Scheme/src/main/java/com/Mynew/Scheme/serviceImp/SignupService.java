package com.Mynew.Scheme.serviceImp;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.Period;
import java.util.Base64;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Mynew.Scheme.Requestdto.LoginRequestdto;
import com.Mynew.Scheme.Requestdto.PasswordRequestdto;
import com.Mynew.Scheme.Requestdto.SchemeRequestdto;
import com.Mynew.Scheme.Requestdto.SignupRequestdto;
import com.Mynew.Scheme.dao.SignupRepository;
import com.Mynew.Scheme.dto.ApiResponse;
import com.Mynew.Scheme.dto.SchemeResponsedto;
import com.Mynew.Scheme.model.Signup;
import com.Mynew.Scheme.service.SignupInterface;

@Service
public class SignupService implements SignupInterface {

	@Autowired
	private SignupRepository signupRepository;

	public ApiResponse signUpUser(SignupRequestdto signupRequest) {
		Optional<Signup> optionalUser = signupRepository.findByMobileNumber(signupRequest.getMobileNumber());
		Signup user = new Signup();
		String message = "";
		if (optionalUser.isPresent()) {
			message = "user already exist";
			user = optionalUser.get();
		} else {
			user.setFirstName(signupRequest.getFirstName());
			user.setLastName(signupRequest.getLastName());
			user.setEmail(signupRequest.getEmail());
			user.setDob(signupRequest.getDob());
			user.setAadharNumber(signupRequest.getAadharNumber());
			user.setMobileNumber(signupRequest.getMobileNumber());
		}
		return new ApiResponse("success", message, user);
	}

	@Override
	public ApiResponse setPassword(PasswordRequestdto passwordRequest) {
		Optional<Signup> optionalUser = signupRepository.findByMobileNumber(passwordRequest.getMobileNumber());
		if (optionalUser.isPresent()) {
			Signup user = optionalUser.get();
			byte[] caseIdByte = passwordRequest.getPassword().getBytes(StandardCharsets.UTF_8);
			user.setPassword(new String(Base64.getEncoder().encode(caseIdByte)));
			user = signupRepository.save(user);
			return new ApiResponse("success", "User successfully signed in", passwordRequest);//
		} else {
			return new ApiResponse("Error", "User not Found with MobileNumber" + passwordRequest.getMobileNumber());
		}
	}

	@Override
	public ApiResponse LoginUser(LoginRequestdto loginRequest) {
		Optional<Signup> optionalUser = signupRepository.findByMobileNumber(loginRequest.getMobileNumber());
		if (optionalUser.isPresent()) {
			String Str1 = loginRequest.getPassword();
			byte[] caseIdByte = Str1.getBytes(StandardCharsets.UTF_8);
			byte[] byteArr = Base64.getDecoder().decode(caseIdByte);
			String str = new String(byteArr);
			if (loginRequest.getPassword().equals(str)) {
				return new ApiResponse("Success", "Login Successfully", loginRequest);
			} else {
				return new ApiResponse("Fail", "Wrong Credentials", loginRequest);
			}
		} else {

			return new ApiResponse("Fail", "User not Existed", loginRequest);
		}
	}

	@Override
	public ApiResponse applyScheme(SchemeRequestdto schemeRequest) {
		Optional<Signup> optionalUser = signupRepository.findByMobileNumber(schemeRequest.getMobileNumber());
		if (optionalUser.isPresent()) {
			Signup scheme = optionalUser.get();
			scheme.getDob();
			SchemeResponsedto schemeResponsedto = new SchemeResponsedto();
			Period period = Period.between(scheme.getDob(), LocalDate.now());

			if (period.getYears() > 18) {
				schemeResponsedto.setResponse("Successfully Applied for scheme");
			} else {
				schemeResponsedto.setResponse("Your not eligible for this Scheme");
			}
		} else {
			return new ApiResponse("Fail", "User Not Existed with this MobileNumber" + schemeRequest.getMobileNumber());
		}
		return new ApiResponse("Fail", "User not Existed", schemeRequest);
	}
}
