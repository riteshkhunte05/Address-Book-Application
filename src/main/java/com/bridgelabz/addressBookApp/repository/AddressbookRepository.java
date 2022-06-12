package com.bridgelabz.addressBookApp.repository;

import com.bridgelabz.addressBookApp.model.AddressBookData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/*********************************************************************
 * Purpose: Interface for Addressbook Repository.
 *
 * @author Ritesh
 * @since 08-06-2022
 *
 **********************************************************************/
@Repository
public interface AddressbookRepository extends JpaRepository<AddressBookData,Integer> {

    @Query(value = "select * from contact_table where state = :state ", nativeQuery = true)
    List<AddressBookData> findByState(String state);

    @Query(value = "select * from contact_table where city = :city", nativeQuery = true)
    List<AddressBookData> findByCity(String city);

}