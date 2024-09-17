package com.jsaasta.froj;

import java.util.List;
import java.util.Map;

public class FrojClass implements FrojCallable {
    final String name;
    final FrojClass superclass;
    private final Map<String, FrojFunction> methods;

    public FrojClass(String name, FrojClass superclass, Map<String, FrojFunction> methods) {
        this.name = name;
        this.superclass = superclass;
        this.methods = methods;
    }

    public FrojFunction findMethod(String name) {
        if (methods.containsKey(name)) {
            return methods.get(name);
        }

        if (superclass != null) {
            return superclass.findMethod(name);
        }

        return null;
    }


    @Override
    public String toString() {
        return name;
    }

    @Override
    public int arity() {
        FrojFunction initializer = findMethod("init");
        if (initializer == null) return 0;
        return initializer.arity();
    }

    @Override
    public Object call(Interpreter interpreter, List<Object> arguments) {
        FrojInstance instance = new FrojInstance(this);
        FrojFunction initializer = findMethod("init");

        if (initializer != null) {
            initializer.bind(instance).call(interpreter, arguments);
        }
        return instance;
    }
}
