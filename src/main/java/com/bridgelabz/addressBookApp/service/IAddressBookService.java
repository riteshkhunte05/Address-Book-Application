package com.bridgelabz.addressBookApp.service;


import com.bridgelabz.addressBookApp.dto.AddressbookDTO;
import com.bridgelabz.addressBookApp.model.AddressBookData;

import java.util.List;

public interface IAddressBookService {
    List<AddressBookData> getAddressbookData();

    AddressBookData getAddressbookDataById(int personId);

    AddressBookData createAddressbookData(AddressbookDTO addressbookDTO);

    AddressBookData updateAddressbookData(int personId, AddressbookDTO addressbookDTO);

    void deleteAddressbookData(int personId);
}