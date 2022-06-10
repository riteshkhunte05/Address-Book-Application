package com.bridgelabz.addressBookApp.service;

import com.bridgelabz.addressBookApp.dto.AddressbookDTO;
import com.bridgelabz.addressBookApp.exceptions.AddressbookException;
import com.bridgelabz.addressBookApp.model.AddressBookData;
import com.bridgelabz.addressBookApp.repository.AddressbookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class AddressBookServiceImpl implements IAddressBookService {
    @Autowired
    private AddressbookRepository addressbookRepository;


    List<AddressBookData> addressbookDataList = new ArrayList<>();

    @Override
    public List<AddressBookData> getAddressbookData() {
        return addressbookDataList;
    }

    @Override
    public AddressBookData getAddressbookDataById(int personId) {
        return addressbookDataList.stream()
                .filter(addressbookData -> addressbookData.getPersonId() == personId)
                .findFirst()
                .orElseThrow(() -> new AddressbookException("Person Not found"));
    }

    @Override
    public AddressBookData createAddressbookData(AddressbookDTO addressbookDTO) {
        AddressBookData addressbookData = null;
        addressbookData = new AddressBookData(addressbookDataList.size() + 1, addressbookDTO);
        log.debug("AddressbookData: "+addressbookData.toString());
        addressbookDataList.add(addressbookData);
        return addressbookRepository.save(addressbookData);
    }

    @Override
    public AddressBookData updateAddressbookData(int personId, AddressbookDTO addressbookDTO) {
        AddressBookData addressbookData = this.getAddressbookDataById(personId);
        addressbookData.updateAddressBookdata(addressbookDTO);
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