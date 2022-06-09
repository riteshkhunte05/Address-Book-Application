package com.bridgelabz.addressBookApp.controller;

import com.bridgelabz.addressBookApp.dto.AddressbookDTO;
import com.bridgelabz.addressBookApp.dto.ResponseDTO;
import com.bridgelabz.addressBookApp.model.AddressBookData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {
    @RequestMapping(value = {"", "/", "/get"})
    public ResponseEntity<ResponseDTO> getAddressbookData() {
        AddressBookData addressbookData = null;
        addressbookData = new AddressBookData(1,new AddressbookDTO("Rahul","7775599333"));
        ResponseDTO responseDTO = new ResponseDTO("Get call success",addressbookData);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @GetMapping("/get/{personId}")
    public ResponseEntity<ResponseDTO> getAddressbookData(@PathVariable(value = "personId") int personId) {
        AddressBookData addressbookData = null;
        addressbookData = new AddressBookData(personId,new AddressbookDTO("Rahul","7775599333"));
        ResponseDTO responseDTO = new ResponseDTO("Get Call Success for id: ",addressbookData);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addAddressbookData(@RequestBody AddressbookDTO addressbookDTO) {
        AddressBookData addressbookData = null;
        addressbookData = new AddressBookData(1,addressbookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Created Employee Payroll Data for: ",addressbookData);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @PutMapping("/update/{personId}")
    public ResponseEntity<ResponseDTO> updateAddressbookData(@PathVariable int personId,@RequestBody AddressbookDTO addressbookDTO){
        AddressBookData addressbookData = null;
        addressbookData = new AddressBookData(personId,addressbookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updated Employee Payroll Data for: ",addressbookData);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{personId}")
    public ResponseEntity<ResponseDTO> deleteAddressbookData(@PathVariable("personId") int personId) {
        ResponseDTO responseDTO = new ResponseDTO("Deleted data successfully","person id: "+personId);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }
}