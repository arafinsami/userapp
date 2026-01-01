package com.userapp.model.context;

import com.userapp.model.enums.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserViewContext {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private UserStatus status;
}
