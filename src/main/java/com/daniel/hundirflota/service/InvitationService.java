package com.daniel.hundirflota.service;

import java.util.List;
import java.util.Optional;

import com.daniel.hundirflota.entity.Invitation;
import com.daniel.hundirflota.entity.AppUser;

public interface InvitationService {
	public Optional<Invitation> getInvitation(Long id);

	List<Invitation> getInvitations(AppUser user);
	
	Invitation sendInvitation(AppUser transmitter, AppUser receiver);
	
	Invitation acceptInvitation(Invitation inv);
	
	Invitation rejectInvitation(Invitation inv);
	
}
