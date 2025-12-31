package com.userapp.model.response;

import com.userapp.model.base.BaseModel;
import com.userapp.model.enums.UserStatus;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserCreateResponse extends BaseModel {

    private Long id;

    private String firstName;

    private String lastName;

    private String password;

    private String email;

    private UserStatus status;
}
