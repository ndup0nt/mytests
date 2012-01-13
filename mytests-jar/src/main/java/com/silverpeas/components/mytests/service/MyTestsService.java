package com.silverpeas.components.mytests.service;

import com.silverpeas.components.mytests.model.Contact;

import java.util.List;

public interface MyTestsService {

    public abstract List<Contact> getAllContacts(String componentId);

    public abstract void addContact(Contact contact);

	public abstract Contact findContact(int contactId);

}