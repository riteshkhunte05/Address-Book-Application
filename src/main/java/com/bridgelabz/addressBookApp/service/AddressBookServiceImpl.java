package com.bridgelabz.addressBookApp.service;

import com.bridgelabz.addressBookApp.dto.AddressbookDTO;
import com.bridgelabz.addressBookApp.model.AddressBookData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookServiceImpl implements IAddressBookService {

    List<AddressBookData> addressbookDataList = new ArrayList<>();

    @Override
    public List<AddressBookData> getAddressbookData() {
        return addressbookDataList;
    }

    @Override
    public AddressBookData getAddressbookDataById(int personId) {
        AddressBookData addressbookData = null;
        addressbookData = addressbookDataList.get(personId - 1);
        return addressbookData;
    }

    @Override
    public AddressBookData createAddressbookData(AddressbookDTO addressbookDTO) {
        AddressBookData addressbookData = null;
        addressbookData = new AddressBookData(addressbookDataList.size() + 1, addressbookDTO);
        addressbookDataList.add(addressbookData);
        return addressbookData;
    }

    @Override
    public AddressBookData updateAddressbookData(int personId, AddressbookDTO addressbookDTO) {
        AddressBookData addressbookData = this.getAddressbookDataById(personId);
        addressbookData.setName(addressbookDTO.name);
        addressbookData.setPhNumber(addressbookDTO.phNumber);
        addressbookDataList.set(personId - 1, addressbookData);
        return addressbookData;
    }

    @Override
    public void deleteAddressbookData(int personId) {
        int i = 1;
        addressbookDataList.remove(personId - 1);
        for (AddressBookData addressbookData : addressbookDataList) {
            addressbookData.setPersonId(i++);
        }
    }
}