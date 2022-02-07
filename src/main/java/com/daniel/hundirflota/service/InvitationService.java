package com.daniel.hundirflota.service;

import java.util.List;

import com.daniel.hundirflota.entity.Invitation;
import com.daniel.hundirflota.entity.User;

public interface InvitationService {

	List<Invitation> getInvitations(User user);
	
	boolean sendInvitation(User transmitter, User receiver);
	
	boolean acceptInvitation();
	
	boolean rejectInvitation();
	
}
