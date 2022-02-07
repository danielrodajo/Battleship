package com.daniel.hundirflota.service;

import java.util.List;

import com.daniel.hundirflota.entity.Invitation;
import com.daniel.hundirflota.entity.AppUser;

public interface InvitationService {

	List<Invitation> getInvitations(AppUser user);
	
	Boolean sendInvitation(AppUser transmitter, AppUser receiver);
	
	Boolean acceptInvitation();
	
	Boolean rejectInvitation();
	
}
