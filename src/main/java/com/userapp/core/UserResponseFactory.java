package com.userapp.core;

import com.userapp.model.context.UserContext;
import com.userapp.model.response.UserCreateResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class UserResponseFactory {
    public static ResponseEntity<UserCreateResponse> from(UserContext ctx) {
        if (!ctx.isSuccess()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(
                UserCreateResponse.builder()
                        .id(ctx.getId())
                        .firstName(ctx.getFirstName())
                        .lastName(ctx.getLastName())
                        .email(ctx.getEmail())
                        .status(ctx.getStatus())
                        .build()
        );
    }
}
