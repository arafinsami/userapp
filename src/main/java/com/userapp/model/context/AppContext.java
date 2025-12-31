package com.userapp.model.context;

import lombok.Data;

@Data
public abstract class AppContext implements BaseContext {
    private boolean success = true;
    private String errorMessage;

    public void fail(String msg) {
        this.success = false;
        this.errorMessage = msg;
    }
}
