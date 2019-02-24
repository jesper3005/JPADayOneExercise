/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import com.mysql.jdbc.StringUtils;
import enums.CustomerType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;

/**
 *
 * @author Jesper
 */
@Entity
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName, lastName;
    @Enumerated(EnumType.STRING)
    private CustomerType customerType;

    @ElementCollection
    @CollectionTable(
            name = "Hobbies",
            joinColumns = @JoinColumn(name = "Customer_ID")
    )
    @Column(name = "Hobby")
    private List<String> hobbies = new ArrayList();

    public String getHobbies() {
        String hobbiesString = "Hobbies: ";
        for (int i = 0; i < this.hobbies.size(); i++) {
            hobbiesString = hobbiesString.concat(this.hobbies.get(i) + ", ");
        }
        hobbiesString = hobbiesString.substring(hobbiesString.length() - 1);
        return hobbiesString;
    }

    @ElementCollection(fetch = FetchType.LAZY)
    @MapKeyColumn(name = "PHONE")
    @Column(name = "Description")
    private Map<String, String> phones = new HashMap();

    public void addPhone(String phoneNo, String description) {
        phones.put(phoneNo, description);
    }

    public String getPhoneDescription(String phoneNo) {
        return phones.get(phoneNo);
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", customerType=" + customerType + ", " + getHobbies() + '}';
    }

    public void addHobbies(String hobby) {
        hobbies.add(hobby);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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

    public Customer() {
    }

}
