package com.userapp.model.context;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public abstract class AppContext implements BaseContext {

    @Builder.Default
    private boolean success = true;

    private String errorMessage;

    public void fail(String msg) {
        this.success = false;
        this.errorMessage = msg;
    }
}
