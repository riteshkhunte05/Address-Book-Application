package com.bridgelabz.addressBookApp.service;

import com.bridgelabz.addressBookApp.dto.AddressbookDTO;
import com.bridgelabz.addressBookApp.model.AddressBookData;
import com.bridgelabz.addressBookApp.service.IAddressBookService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookServiceImpl implements IAddressBookService {
    @Override
    public List<AddressBookData> getAddressbookData() {
        List<AddressBookData> addressbookDataList = new ArrayList<>();
        addressbookDataList.add(new AddressBookData(1, new AddressbookDTO("Rahul", "7057082582")));
        return addressbookDataList;
    }

    @Override
    public AddressBookData getAddressbookDataById(int personId) {
        AddressBookData addressbookData = null;
        addressbookData = new AddressBookData(personId, new AddressbookDTO("Rohan", "1234567890"));
        return addressbookData;
    }

    @Override
    public AddressBookData createAddressbookData(AddressbookDTO addressbookDTO) {
        AddressBookData addressbookData = null;
        addressbookData = new AddressBookData(1, addressbookDTO);
        return addressbookData;
    }

    @Override
    public AddressBookData updateAddressbookData(int personId, AddressbookDTO addressbookDTO) {
        AddressBookData addressbookData = null;
        addressbookData = new AddressBookData(personId, addressbookDTO);
        return addressbookData;
    }

    @Override
    public void deleteAddressbookData(int personId) {

    }
}