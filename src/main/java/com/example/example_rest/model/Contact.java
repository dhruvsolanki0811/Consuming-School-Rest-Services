package com.example.example_rest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contact{

    private int contactId;
    private String name;
//    private String mobileNum;
//    private String email;
    private String subject;
    private String message;
    private String status;

}
