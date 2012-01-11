package com.silverpeas.components.mytests.service;


import com.silverpeas.components.mytests.dao.ContactDAO;
import com.silverpeas.components.mytests.model.Contact;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

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

    private final List<Contact> contacts = new ArrayList<Contact>();

    private MyTestsServiceImpl() {
        contacts.add(new Contact("Nicolas", "Dupont", "R&D", "1"));
        contacts.add(new Contact("Ludovic", "Bertin", "R&D", "1"));
        contacts.add(new Contact("Patrick", "Schambel", "Direction", "1"));
    }

    /* (non-Javadoc)
      * @see com.silverpeas.components.mytests.MyTestsService#getMyContacts()
      */
    @Override
    public List<Contact> getMyContacts() {
        //FIXME implémenter
        dao.findOne(1);
        return contacts;
    }

    /* (non-Javadoc)
      * @see com.silverpeas.components.mytests.MyTestsService#addContact(com.silverpeas.components.mytests.Contact)
      */
    @Override
    public void addContact(Contact contact) {
        contacts.add(contact);
    }
}
