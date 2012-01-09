package com.silverpeas.components.mytests;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: nicolas
 * Date: 06/01/12
 * Time: 10:33
 * To change this template use File | Settings | File Templates.
 */
public class MyTestsService {
    private static class SingletonLoader {
        private static MyTestsService _instance = new MyTestsService();
    }

    public static MyTestsService getInstance() {
        return SingletonLoader._instance;
    }
    
    private final List<Contact> contacts = new ArrayList<Contact>();

    private MyTestsService() {
    	contacts.add(new Contact("Nicolas","Dupont","R&D"));
    	contacts.add(new Contact("Ludovic","Bertin","R&D"));
    	contacts.add(new Contact("Patrick","Schambel","Direction"));
    }
    
    public List<Contact> getMyContacts(){
        return contacts;
    }
    
    public void addContact(Contact contact){
    	contacts.add(contact);
    }
}
