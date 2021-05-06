package com.Mynew.Scheme.serviceImp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Mynew.Scheme.Requestdto.SignupRequestdto;
import com.Mynew.Scheme.dao.SignupRepository;
import com.Mynew.Scheme.dto.ApiResponse;
import com.Mynew.Scheme.model.Signup;
import com.Mynew.Scheme.service.SignupInterface;

@Service
public class SignupService implements SignupInterface {
	
	@Autowired
	private SignupRepository signupRepository;
	
    public ApiResponse signUpUser(SignupRequestdto signupRequest) {
        Optional<Signup> optionalUser = signupRepository.findByMobileNumber(signupRequest.getMobileNumber());
        Signup user=new Signup();
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
}
