package com.bridgelabz.addressBookApp.model;

import com.bridgelabz.addressBookApp.dto.AddressbookDTO;
import lombok.Data;

    @Data
    public class AddressBookData {
        private int personId;
        private String name;
        private String phNumber;

        public AddressBookData(int personId, AddressbookDTO addressbookDTO) {
            this.personId = personId;
            this.name = addressbookDTO.name;
            this.phNumber = addressbookDTO.phNumber;
        }
    }

