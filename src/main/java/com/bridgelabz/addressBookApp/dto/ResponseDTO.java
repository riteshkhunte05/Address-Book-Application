/**
 * ResponseDTO.java
 */
package com.bridgelabz.addressBookApp.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ResponseDTO {
    private String message;
    private Object data;

    public ResponseDTO(String message, Object data) {
        this.message = message;
        this.data = data;
    }
}