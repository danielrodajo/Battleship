package com.daniel.hundirflota.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daniel.hundirflota.entity.AppUser;
import com.daniel.hundirflota.entity.Invitation;
import com.daniel.hundirflota.models.CreateInvitation;
import com.daniel.hundirflota.service.InvitationService;
import com.daniel.hundirflota.service.AppUserService;

@RestController
@RequestMapping("/api/invitation")
public class InvitationController extends GlobalController {

	@Autowired private AppUserService userService;
	@Autowired private InvitationService invitationService;
	
	@PostMapping("/send")
    public Boolean senderHandler(@RequestBody CreateInvitation createInvitation) {
    	AppUser transmitter = userService.findById(getAppUserDetails().getId());
    	AppUser receiver = userService.findById(createInvitation.getReceiver());
    	
    	Invitation isSended = invitationService.sendInvitation(transmitter, receiver);
    	
    	return isSended != null;
    }
	
	@GetMapping("/accept/{id}")
	public void acceptInvitation(@PathVariable long id) {
		invitationService.acceptInvitation(invitationService.getInvitation(id).orElse(null));
	}
}
