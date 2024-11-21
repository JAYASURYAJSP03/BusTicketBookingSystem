package com.project.capstone.dto;

import lombok.Data;

@Data
public class UserRegisteredDTO {


    private String name;

    private String email_id;

    private String password;

    private String role;

    public UserRegisteredDTO(String mail, String user, String password, String user1) {
    }

    public UserRegisteredDTO() {

    }

    public UserRegisteredDTO(String testuser, String mail, String password) {
    }
}
