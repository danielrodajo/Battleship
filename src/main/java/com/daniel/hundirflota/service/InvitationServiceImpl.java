package com.daniel.hundirflota.service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daniel.hundirflota.entity.Invitation;
import com.daniel.hundirflota.entity.AppUser;
import com.daniel.hundirflota.repository.GameRepository;
import com.daniel.hundirflota.repository.InvitationRepository;

@Service
public class InvitationServiceImpl implements InvitationService {

	@Autowired private InvitationRepository invitationRepository;
	@Autowired private GameRepository gameRepository;

	@Override
	public Optional<Invitation> getInvitation(Long id) {
		Optional<Invitation> invitation = invitationRepository.findById(id);
		return invitation;
	}

	@Override
	public List<Invitation> getInvitations(AppUser user) {
		List<Invitation> invitations = invitationRepository.findByReceiver(user);
		return invitations;
	}
	
	@Override
	public Invitation sendInvitation(AppUser transmitter, AppUser receiver) {
		Invitation inv = new Invitation();
		inv.setIssuedAt(Instant.now());
		inv.setTransmitter(transmitter);
		inv.setReceiver(receiver);
		
		inv = invitationRepository.save(inv);
		return inv;
	}

	@Override
	public Invitation acceptInvitation(Invitation inv) {
		inv.setAccepted(true);

		return inv;
	}

	@Override
	public Invitation rejectInvitation(Invitation inv) {
		// TODO Auto-generated method stub
		return null;
	}

}
