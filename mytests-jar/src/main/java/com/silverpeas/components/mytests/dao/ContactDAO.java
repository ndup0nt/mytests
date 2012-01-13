package com.silverpeas.components.mytests.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.silverpeas.components.mytests.model.Contact;


public interface ContactDAO extends JpaRepository<Contact, Integer> {

	@Query("from Contact c WHERE c.componentId = :myId")
	public List<Contact> getAllContacts(@Param("myId") String componentId);

}
