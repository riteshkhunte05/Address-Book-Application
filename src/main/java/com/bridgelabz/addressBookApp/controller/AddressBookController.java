package com.bridgelabz.addressBookApp.controller;

import com.bridgelabz.addressBookApp.dto.AddressbookDTO;
import com.bridgelabz.addressBookApp.dto.ResponseDTO;
import com.bridgelabz.addressBookApp.model.AddressBookData;
import com.bridgelabz.addressBookApp.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/*********************************************************************
 * Purpose: Class for Rest Controller.
 *
 * @author Ritesh
 * @since 08-06-2022
 **********************************************************************/
@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @Autowired
    IAddressBookService addressbookService;

    /**
     * Method :- Method for Getting All The Address Book Records.
     *
     * @return :- Returning Records.
     */
    @RequestMapping(value = {"", "/", "/get"})
    public ResponseEntity<ResponseDTO> getAddressBookData() {
        List<AddressBookData> addressbookDataList = null;
        addressbookDataList = addressbookService.getAddressbookData();
        ResponseDTO responseDTO = new ResponseDTO("Get call success",addressbookDataList);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    /**
     * Method :- Method to Get the Address Book Records by personId.
     *
     * @param personId :- Passing personId as input
     * @return :- Returning Records.
     */
    @GetMapping("/get/{personId}")
    public ResponseEntity<ResponseDTO> getAddressbookData(@PathVariable(value = "personId") int personId) {
        AddressBookData addressbookData = null;
        addressbookData = addressbookService.getAddressbookDataById(personId);
        ResponseDTO responseDTO = new ResponseDTO("Get Call Success for id is successfully",addressbookData);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    /**
     * Method :- Method to Create the Address Book Record.
     *
     * @param addressbookDTO :- Passing addressbookDTO as input
     * @return :- Returning Response
     */
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addAddressbookData(@Valid @RequestBody AddressbookDTO addressbookDTO) {
        AddressBookData addressbookData = null;
        addressbookData = addressbookService.createAddressbookData(addressbookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Created Address Book Data successfully ",addressbookData);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    /**
     * Method :- Method to Update the Address Book Record.
     *
     * @param personId :- Passing personId as input
     * @return :- Returning Response
     */
    @PutMapping("/update/{personId}")
    public ResponseEntity<ResponseDTO> updateAddressbookData(@PathVariable int personId,@Valid @RequestBody AddressbookDTO addressbookDTO){
        AddressBookData addressbookData = null;
        addressbookData = addressbookService.updateAddressbookData(personId,addressbookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updated Address Book data successfully ",addressbookData);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    /**
     * Method :- Method to Delete the Address Book Record.
     *
     * @param personId :- Passing personId as input.
     * @return :- Returning Response
     */
    @DeleteMapping("/delete/{personId}")
    public ResponseEntity<ResponseDTO> deleteAddressbookData(@PathVariable("personId") int personId) {
        addressbookService.deleteAddressbookData(personId);
        ResponseDTO responseDTO = new ResponseDTO("Deleted data successfully","person id: "+personId);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    /**
     * Method :- Method to Get the Address Book Records by state.
     *
     * @param state :- Passing personId as input
     * @return :- Returning Records.
     */
    @GetMapping("/sortbystate/{state}")
    public ResponseEntity<ResponseDTO> getByState(@PathVariable("state") String state) {
        List<AddressBookData> addressbookDataList = null;
        addressbookDataList = addressbookService.getByState(state);
        ResponseDTO responseDTO = new ResponseDTO("Get Call for Sort By State is Successful : ", addressbookDataList);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    /**
     * Method :- Method to Get the Address Book Records by city.
     *
     * @param city :- Passing personId as input
     * @return :- Returning Records.
     */
    @GetMapping("/sortbycity/{city}")
    public ResponseEntity<ResponseDTO> getByCity(@PathVariable("city") String city) {

        List<AddressBookData> addressbookDataList = null;
        addressbookDataList = addressbookService.getByCity(city);
        ResponseDTO responseDTO = new ResponseDTO("Get Call for Sort By City is Successful : ", addressbookDataList);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

}