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

/*********************************************************************
 * Purpose: Class for Addressbook Service Implementation.
 *
 * @author Ritesh
 * @since 08-06-2022
 *
 **********************************************************************/

@Service
@Slf4j
public class AddressBookServiceImpl implements IAddressBookService {
    @Autowired
    private AddressbookRepository addressbookRepository;


    List<AddressBookData> addressbookDataList = new ArrayList<>();

    /**
     * Method :- Method for Getting All The Address Book Records.
     *
     * @return :- Returning Records
     */
    @Override
    public List<AddressBookData> getAddressbookData() {
        return addressbookRepository.findAll();
    }

    /**
     * Method :- Method to Get the Address Book Records by personId.
     *
     * @param personId :- Passing personId as input
     * @return :- Returning Records.
     */
    @Override
    public AddressBookData getAddressbookDataById(int personId) {
        return addressbookRepository
                .findById(personId)
                .orElseThrow(()->new AddressbookException("Person with perssonId "+personId+" doesnot exists"));
    }

    /**
     * Method :- Method to Add the Address Book Record.
     *
     * @param addressbookDTO :- Passing addressbookDTO as input
     * @return :- Returning addressbookData
     */
    @Override
    public AddressBookData createAddressbookData(AddressbookDTO addressbookDTO) {
        AddressBookData addressbookData = null;
        addressbookData = new AddressBookData (addressbookDTO);
        log.debug("AddressbookData: "+addressbookData.toString());
        return addressbookRepository.save(addressbookData);
    }

    /**
     * Method :- Method to Update the Address Book Record.
     *
     * @param id:- personId as input
     * @param addressbookDTO
     * @return :- Returning addressbookData
     */
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

    /**
     * Method :- Method to Delete the Address Book Record.
     *
     * @param personId :- Passing personId as input.
     * @return :- Returning addressbookData
     */
    @Override
    public void deleteAddressbookData(int personId) {
        AddressBookData addressbookData = this.getAddressbookDataById(personId);
        addressbookRepository.delete(addressbookData);
    }

    @Override
    public List<AddressBookData> getByState(String state) {
        return addressbookRepository.findByState(state);
    }

    @Override
    public List<AddressBookData> getByCity(String city) {
        return addressbookRepository.findByCity(city);
    }
}