package com.daniel.hundirflota.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daniel.hundirflota.entity.Invitation;

public interface InvitationRepository extends JpaRepository<Invitation, Long>  {

}
