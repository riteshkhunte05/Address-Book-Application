package com.bridgelabz.addressBookApp.model;

import com.bridgelabz.addressBookApp.dto.AddressbookDTO;
import lombok.Data;

import javax.persistence.*;

/**
 Use Of Lombak In Addressbook Annotations
 */
@Data
@Entity
@Table(name="contact_table")
public class AddressBookData {
    @Id
    @Column(name = "person_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int personId;
    private String firstName;
    private String lastName;
    private String city;
    private String state;
    private String zip;
    private String phone;
    private String email;


    public AddressBookData() {
    }

    public AddressBookData(AddressbookDTO addressbookDTO) {
        this.firstName = addressbookDTO.firstName;
        this.lastName = addressbookDTO.lastName;
        this.city = addressbookDTO.city;
        this.state = addressbookDTO.state;
        this.zip = addressbookDTO.zip;
        this.phone = addressbookDTO.phone;
        this.email = addressbookDTO.email;
    }
}