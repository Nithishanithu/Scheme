package com.Mynew.Scheme.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Mynew.Scheme.model.Signup;

public interface PasswordRepository extends JpaRepository<Signup, Long> {

	Optional<Signup> findByMobileNumber(String mobileNumber);

}
