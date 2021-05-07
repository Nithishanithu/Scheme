package com.Mynew.Scheme.service;

import com.Mynew.Scheme.Requestdto.LoginRequestdto;
import com.Mynew.Scheme.Requestdto.PasswordRequestdto;
import com.Mynew.Scheme.Requestdto.SchemeRequestdto;
import com.Mynew.Scheme.Requestdto.SignupRequestdto;
import com.Mynew.Scheme.dto.ApiResponse;


public interface SignupInterface {

	public ApiResponse signUpUser(SignupRequestdto signupRequest);

	public ApiResponse setPassword(PasswordRequestdto passwordRequest);

	public ApiResponse LoginUser(LoginRequestdto loginRequest);

	public ApiResponse applyScheme(SchemeRequestdto schemeRequest);
}
