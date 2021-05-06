package com.Mynew.Scheme.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.Mynew.Scheme.Requestdto.SignupRequestdto;
import com.Mynew.Scheme.dto.ApiResponse;
import com.Mynew.Scheme.service.SignupInterface;

@RestController
public class SignupController {
	
	@Autowired
	private SignupInterface signupInterface;
	
	@PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignupRequestdto signUpRequest) {
        return new ResponseEntity<ApiResponse>(signupInterface.signUpUser(signUpRequest), HttpStatus.OK);
    }

}
