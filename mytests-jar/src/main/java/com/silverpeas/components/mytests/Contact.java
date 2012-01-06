package com.silverpeas.components.mytests;

/**
 * Created by IntelliJ IDEA.
 * User: nicolas
 * Date: 06/01/12
 * Time: 11:13
 * To change this template use File | Settings | File Templates.
 */
public class Contact {
    private String firstName;
    private String lastName;
    private String service;
    
    private String toto;

    public Contact() {
    }

    public Contact(String firstName, String lastName, String service) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.service = service;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }
}
