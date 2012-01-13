package com.silverpeas.components.mytests.service;


import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.springframework.transaction.annotation.Transactional;

import com.silverpeas.components.mytests.dao.ContactDAO;
import com.silverpeas.components.mytests.model.Contact;

/**
 * Created by IntelliJ IDEA.
 * User: nicolas
 * Date: 06/01/12
 * Time: 10:33
 * To change this template use File | Settings | File Templates.
 */
@Singleton
@Named
class MyTestsServiceImpl implements MyTestsService {
    @Inject
    private ContactDAO dao;

    @Override
    public List<Contact> getAllContacts(String componentId) {
        return dao.getAllContacts(componentId);
    }

    @Override
    @Transactional
    public void addContact(Contact contact) {
    	dao.saveAndFlush(contact);
    	//TODO indexation. Bien le faire à la fin (= fin de la transaction)
    }

	@Override
	public Contact findContact(int contactId) {
		return dao.findOne(contactId);	
	}
}
