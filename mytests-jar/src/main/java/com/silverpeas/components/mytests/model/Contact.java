package com.silverpeas.components.mytests.model;

import javax.persistence.*;


/**
 * Created by IntelliJ IDEA.
 * User: nicolas
 * Date: 06/01/12
 * Time: 11:13
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "sc_mytests_contact")
public class Contact {
    @Id
    @Column(name = "pubId", nullable = false)
    @SequenceGenerator(name = "sc_mytests_contact_id_seq", sequenceName = "sc_mytests_contact_id_seq")
    @GeneratedValue(generator = "sc_mytests_contact_id_seq", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String department;
    @SuppressWarnings("unused") // utilisé uniquement pour la persistance
    @Column
    private String componentId;

    @SuppressWarnings("unused") // utilisé uniquement pour la persistance
    private Contact() {}

    public Contact(String firstName, String lastName, String department, String componentId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.componentId = componentId;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

	public Integer getId() {
		return id;
	}
}
