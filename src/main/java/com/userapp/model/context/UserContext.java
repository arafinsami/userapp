package com.userapp.model.context;

import com.userapp.model.enums.UserStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserContext extends AppContext {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private UserStatus status;
}
