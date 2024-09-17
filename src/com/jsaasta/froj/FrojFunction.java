package com.jsaasta.froj;

import java.util.List;

public class FrojFunction implements FrojCallable {

    private final Stmt.Function declaration;
    private final Environment closure;
    private final boolean isInitializer;

    public FrojFunction(Stmt.Function declaration, Environment closure, boolean isInitializer) {
        this.declaration = declaration;
        this.closure = closure;
        this.isInitializer = isInitializer;
    }

    public FrojFunction bind(FrojInstance instance) {
        Environment environment = new Environment(closure);
        environment.define("this", instance);
        return new FrojFunction(declaration, environment, false);
    }


    @Override
    public int arity() {
        return declaration.params.size();
    }

    @Override
    public Object call(Interpreter interpreter, List<Object> arguments) {
        // Create a new environment for every call to handle recursive
        // function calls.
        Environment environment = new Environment(closure);
        for (int i = 0; i < declaration.params.size(); i++) {
            environment.define(declaration.params.get(i).lexeme,
                    arguments.get(i));
        }
        try {
            interpreter.executeBlock(declaration.body, environment);
        } catch (Return returnValue) {
            if (isInitializer) return closure.getAt(0, "this");
            return returnValue.value;
        }
        //If we’re in an initializer and execute a return statement, instead of returning
        //the value (will always be nul), we return 'this' instead.
        if (isInitializer) return closure.getAt(0, "this");
        return null;
    }

    /**
     * For printing function names, e.g "print add;" prints "<fn add>"
     *
     * @return name of function
     */
    @Override
    public String toString() {
        return "<fn " + declaration.name.lexeme + ">";
    }
}
