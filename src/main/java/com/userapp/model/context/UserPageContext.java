package com.userapp.model.context;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class UserPageContext extends UserContext {
    private int page;
    private int size;
    private long totalElements;
    private List<UserViewContext> users;
}
