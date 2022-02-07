package com.daniel.hundirflota.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daniel.hundirflota.entity.AppUser;
import com.daniel.hundirflota.entity.Invitation;

public interface InvitationRepository extends JpaRepository<Invitation, Long> {
	
	List<Invitation> findByReceiver(AppUser user);
	
}
