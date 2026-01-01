package com.userapp.resource;

import com.userapp.core.UserResponseFactory;
import com.userapp.functions.UserFunctions;
import com.userapp.model.request.UserCreateRequest;
import com.userapp.model.response.UserCreateResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/users")
@Tag(name = "Users", description = "User management APIs")
public class AppUserResource {

    @PostMapping
    @Operation(summary = "create user")
    public ResponseEntity<UserCreateResponse> create(@RequestBody UserCreateRequest request) {
        return UserResponseFactory.from(
                UserFunctions.create(request)
        );
    }

    @PutMapping("/{id}")
    @Operation(summary = "update user")
    public ResponseEntity<UserCreateResponse> update(@PathVariable Long id,
                                                     @RequestBody UserCreateRequest request) {
        request.setId(id);
        return UserResponseFactory.from(
                UserFunctions.update(request)
        );
    }

    @GetMapping("/{id}")
    @Operation(summary = "get user by id")
    public ResponseEntity<UserCreateResponse> findById(@PathVariable Long id) {
        return UserResponseFactory.from(
                UserFunctions.findById(id)
        );
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return UserResponseFactory.from(
                UserFunctions.findAll(page, size)
        );
    }
}
