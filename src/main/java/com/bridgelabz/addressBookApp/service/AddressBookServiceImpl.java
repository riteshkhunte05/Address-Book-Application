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
        return addressbookRepository.findAll();
    }

    @Override
    public AddressBookData getAddressbookDataById(int personId) {
        return addressbookRepository
                .findById(personId)
                .orElseThrow(()->new AddressbookException("Person with perssonId "+personId+" doesnot exists"));
    }

    @Override
    public AddressBookData createAddressbookData(AddressbookDTO addressbookDTO) {
        AddressBookData addressbookData = null;
        addressbookData = new AddressBookData (addressbookDTO);
        log.debug("AddressbookData: "+addressbookData.toString());
        return addressbookRepository.save(addressbookData);
    }

    @Override
    public AddressBookData updateAddressbookData(int id, AddressbookDTO addressbookDTO) {
        AddressBookData addressbookData = this.getAddressbookDataById(id);
        addressbookData.setFirstName(addressbookDTO.firstName);
        addressbookData.setLastName(addressbookDTO.lastName);
        addressbookData.setState(addressbookDTO.state);
        addressbookData.setCity(addressbookDTO.city);
        addressbookData.setZip(addressbookDTO.zip);
        addressbookData.setPhone(addressbookDTO.phone);
        addressbookRepository.save(addressbookData);
        return addressbookData;
    }

    @Override
    public void deleteAddressbookData(int personId) {
        AddressBookData addressbookData = this.getAddressbookDataById(personId);
        addressbookRepository.delete(addressbookData);
    }
}