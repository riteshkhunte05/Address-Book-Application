/**
 * ResponseDTO.java
 */
package com.bridgelabz.addressBookApp.dto;

import lombok.Data;
import lombok.ToString;

/*********************************************************************
 * Purpose: Class for Response DTO.
 *
 * @author Ritesh
 * @since 08-06-2022
 *
 **********************************************************************/

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