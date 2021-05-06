package com.Mynew.Scheme.serviceImp;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Optional;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Mynew.Scheme.Requestdto.PasswordRequestdto;
import com.Mynew.Scheme.dao.PasswordRepository;
import com.Mynew.Scheme.dto.ApiResponse;
import com.Mynew.Scheme.model.Signup;
import com.Mynew.Scheme.service.PasswordInterface;

@Service
public class PasswordService implements PasswordInterface {

	@Autowired
	private PasswordRepository passwordRepository;
	
	@Override
	public ApiResponse setPassword(PasswordRequestdto passwordRequest) {
		Optional<Signup> optionalUser = passwordRepository.findByMobileNumber(passwordRequest.getMobileNumber());
		Signup user = optionalUser.get();
        byte[] caseIdByte = passwordRequest.getPassword().getBytes(StandardCharsets.UTF_8);
        passwordRequest.setPassword(new String(Base64.getEncoder().encode(caseIdByte)));
        user = passwordRepository.save(user);
        return new ApiResponse("success", "User successfully signed in", passwordRequest);
	}
}
