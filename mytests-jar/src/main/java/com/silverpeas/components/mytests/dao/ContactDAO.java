package com.silverpeas.components.mytests.dao;

import com.silverpeas.components.mytests.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ContactDAO extends JpaRepository<Contact, Integer> {

//	@Query("from Contact c WHERE c.id = :myId")
//	public Contact getContact(@Param("myId") int id);
//
//	@Query("from Contact")
//	public List<Contact> getAllContacts();

}
