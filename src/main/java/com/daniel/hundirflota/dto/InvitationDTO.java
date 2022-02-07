package com.daniel.hundirflota.dto;

import java.time.Instant;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvitationDTO {

	private Long id;

	private String transmitter;
	private String receiver;
	private Boolean accepted;
	
    private Instant issuedAt;
}
