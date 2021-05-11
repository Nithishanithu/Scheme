package com.Mynew.Scheme.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Mynew.Scheme.Requestdto.LoginRequestdto;
import com.Mynew.Scheme.Requestdto.PasswordRequestdto;
import com.Mynew.Scheme.Requestdto.SchemeRequestdto;
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
	
	@PostMapping("/set-Password")
    public ResponseEntity<?> setPasswordToSignUp(@RequestBody PasswordRequestdto passwordRequestdto) {
        return new ResponseEntity<ApiResponse>(signupInterface.setPassword(passwordRequestdto), HttpStatus.OK);
    }
	
	@PostMapping("Loginuser")
	public ResponseEntity<?> loginUser(@RequestBody LoginRequestdto loginRequestdto) {
        return new ResponseEntity<ApiResponse>(signupInterface.LoginUser(loginRequestdto), HttpStatus.OK);
    }
	
	@PostMapping("/applyScheme")
    public ResponseEntity<?> schemeApply(@RequestBody SchemeRequestdto schemeRequest) {
        return new ResponseEntity(signupInterface.applyScheme(schemeRequest), HttpStatus.OK);

    }

}
