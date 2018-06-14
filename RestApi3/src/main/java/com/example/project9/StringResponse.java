package com.example.project9;


import java.io.Serializable;

public class StringResponse implements Serializable{
    private boolean result;

    StringResponse(boolean bool)
    {
        result = bool;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}
