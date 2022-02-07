package com.daniel.hundirflota.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.daniel.hundirflota.entity.Invitation;
import com.daniel.hundirflota.entity.User;

@Service
public class InvitationServiceImpl implements InvitationService {

	@Override
	public boolean sendInvitation(User transmitter, User receiver) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean acceptInvitation() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean rejectInvitation() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Invitation> getInvitations(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
