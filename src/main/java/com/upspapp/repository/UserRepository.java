package com.upspapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.upspapp.modal.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public boolean existsByEmail(String email);

	public User findByEmail(String username);

	public User findByMobileNumberOrEmail(String currentUsername, String currentUsername2);

	public boolean existsByMobileNumber(String mobileNumber);

	public boolean existsByPassword(String oldPassword);

	public User findByPassword(String oldPassword);


}
