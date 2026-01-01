package com.userapp.core;

import com.userapp.model.context.UserContext;
import com.userapp.model.context.UserPageContext;
import com.userapp.model.response.UserCreateResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

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

    public static ResponseEntity<Map<String, Object>> from(UserPageContext ctx) {
        if (!ctx.isSuccess()) {
            return ResponseEntity.badRequest().build();
        }
        Map<String, Object> response = new HashMap<>();
        response.put("page", ctx.getPage());
        response.put("size", ctx.getSize());
        response.put("totalElements", ctx.getTotalElements());
        response.put("data", ctx.getUsers());
        return ResponseEntity.ok(response);
    }
}
