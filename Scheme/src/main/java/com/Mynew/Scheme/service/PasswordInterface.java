package com.Mynew.Scheme.service;

import com.Mynew.Scheme.Requestdto.PasswordRequestdto;
import com.Mynew.Scheme.dto.ApiResponse;

public interface PasswordInterface {

	public ApiResponse setPassword(PasswordRequestdto passwordRequest);
}
