package com.jsaasta.froj;

import java.util.HashMap;
import java.util.Map;

public class FrojInstance {

    private FrojClass klass;
    private final Map<String, Object> fields = new HashMap<>();

    public FrojInstance(FrojClass klass) {
        this.klass = klass;
    }

    public Object get(Token name) {
        if (fields.containsKey(name.lexeme)) {
            return fields.get(name.lexeme);
        }

        FrojFunction method = klass.findMethod(name.lexeme);
        if (method != null) return method.bind(this);

        throw new RuntimeError(name,
                "Undefined property '" + name.lexeme + "'.");
    }

    public void set(Token name, Object value) {
        fields.put(name.lexeme, value);
    }


    @Override
    public String toString() {
        return klass.name + " instance";
    }
}
