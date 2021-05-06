package com.Mynew.Scheme.service;

import com.Mynew.Scheme.Requestdto.SignupRequestdto;
import com.Mynew.Scheme.dto.ApiResponse;


public interface SignupInterface {

	public ApiResponse signUpUser(SignupRequestdto signupRequest);
}
