package com.jsaasta.froj.stdlib;

import java.util.HashMap;
import java.util.Map;

public class Stdlib {

    private static final Map<String, Object> classes;

    static {
        classes = new HashMap<>();
        classes.put("clock", new Clock());
        classes.put("input", new Input());
    }

    public static Map<String, Object> define(){
        return classes;
    }
}
