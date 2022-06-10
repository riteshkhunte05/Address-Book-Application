package com.bridgelabz.addressBookApp.repository;

import com.bridgelabz.addressBookApp.model.AddressBookData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressbookRepository extends JpaRepository<AddressBookData,Integer> {
}