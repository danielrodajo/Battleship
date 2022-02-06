package com.daniel.hundirflota.service;

import com.daniel.hundirflota.entity.User;

public interface UserService {
	User save(User user);
	User edit(User user);
	User findByEmail(String email);
	User findById(Long id);
}
