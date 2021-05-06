package com.Mynew.Scheme.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.Mynew.Scheme.Requestdto.PasswordRequestdto;
import com.Mynew.Scheme.dto.ApiResponse;
import com.Mynew.Scheme.service.PasswordInterface;

@RestController
public class SetPasswordController {

	@Autowired
	private PasswordInterface passwordInterface;
	
	
	@PostMapping("/set-Password")
    public ResponseEntity<?> setPasswordToSignUp(@RequestBody PasswordRequestdto passwordRequestdto) {
        return new ResponseEntity<ApiResponse>(passwordInterface.setPassword(passwordRequestdto), HttpStatus.OK);
    }
}
