package com.daniel.hundirflota.service;

import com.daniel.hundirflota.entity.AppUser;

public interface AppUserService {
	AppUser save(AppUser user);
	AppUser edit(AppUser user);
	AppUser findByEmail(String email);
	AppUser findById(Long id);
}
