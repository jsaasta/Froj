package com.jsaasta.froj.stdlib;

import com.jsaasta.froj.Token;

public class StdlibRuntimeError extends RuntimeException{


    public StdlibRuntimeError(String message) {
        super(message, null, false, false);
    }
}
