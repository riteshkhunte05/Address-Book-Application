package com.bridgelabz.addressBookApp.service;


import com.bridgelabz.addressBookApp.dto.AddressbookDTO;
import com.bridgelabz.addressBookApp.model.AddressBookData;

import java.util.List;

/*********************************************************************
 * Purpose: Interface for Addressbook Service.
 *
 * @author Ritesh
 * @since 08-06-2022
 *
 **********************************************************************/

public interface IAddressBookService {
    List<AddressBookData> getAddressbookData();

    AddressBookData getAddressbookDataById(int personId);

    List<AddressBookData> getByState(String state);

    List<AddressBookData> getByCity(String city);

    AddressBookData createAddressbookData(AddressbookDTO addressbookDTO);

    AddressBookData updateAddressbookData(int personId, AddressbookDTO addressbookDTO);

    void deleteAddressbookData(int personId);


}
