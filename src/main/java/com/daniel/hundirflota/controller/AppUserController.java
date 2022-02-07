package com.daniel.hundirflota.controller;


import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daniel.hundirflota.dto.InvitationDTO;
import com.daniel.hundirflota.entity.AppUser;
import com.daniel.hundirflota.entity.Invitation;
import com.daniel.hundirflota.service.InvitationService;

@RestController
@RequestMapping("/api/user")
public class AppUserController extends GlobalController {
	
	@Autowired private InvitationService invitationService;
    @Autowired private ModelMapper modelMapper;
	

    @GetMapping("/info")
    public AppUser getAppUser(){
        return getAppUserDetails();
    }
    
    @GetMapping("/invitations")
    public List<InvitationDTO> getAppUserInvitations() {
    	List<Invitation> invitations = invitationService.getInvitations(getAppUserDetails());
    	return invitations.stream()
    			.map(this::convertToDto)
    			.collect(Collectors.toList());
    }
    
    private InvitationDTO convertToDto(Invitation invitation) {
    	
    	InvitationDTO invdto = modelMapper.map(invitation, InvitationDTO.class);
    	invdto.setReceiver(invitation.getReceiver().getEmail());
    	invdto.setTransmitter(invitation.getTransmitter().getEmail());
        return invdto;
    }
}
