package com.bridgelabz.addressBookApp.repository;

import com.bridgelabz.addressBookApp.model.AddressBookData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressbookRepository extends JpaRepository<AddressBookData,Integer> {
}