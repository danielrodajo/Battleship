package com.daniel.hundirflota.service;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daniel.hundirflota.entity.Invitation;
import com.daniel.hundirflota.entity.AppUser;
import com.daniel.hundirflota.repository.InvitationRepository;

@Service
public class InvitationServiceImpl implements InvitationService {

	@Autowired private InvitationRepository invitationRepository;
	
	@Override
	public Boolean sendInvitation(AppUser transmitter, AppUser receiver) {
		Invitation inv = new Invitation();
		inv.setIssuedAt(Instant.now());
		inv.setTransmitter(transmitter);
		inv.setReceiver(receiver);
		
		inv = invitationRepository.save(inv);
		return Boolean.TRUE;
	}

	@Override
	public Boolean acceptInvitation() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Boolean rejectInvitation() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Invitation> getInvitations(AppUser user) {
		// TODO Auto-generated method stub
		return null;
	}

}
