package org.kje.member.controllers;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class RequestJoin implements Serializable {
    @NotBlank @Email
    private String email;

    private String gid = UUID.randomUUID().toString();

    @NotBlank @Size(min=8)
    private String password;

    @NotBlank
    private String confirmPassword;

    @NotBlank
    private String userName;

    @NotBlank
    private String mobile;

    @AssertTrue
    private boolean agree;
}