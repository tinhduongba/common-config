package com.common.config.model.user;

import com.common.config.enumclass.EGender;
import com.common.config.enumclass.EUserStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private UUID id;

    private String firstname;
    private String lastname;

    private String username;

    private String avatarPath;

    private String email;
    private String phone;
    private EGender gender;
    private Instant birthdate;
    private String description;

    private EUserStatus status;

    private String[] roles;

    private String companyName;
    private String companyTitle;
    private String companyAvatarPath;

    private Instant createdAt;
    private Instant updatedAt;
}
