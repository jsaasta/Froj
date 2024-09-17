package com.jsaasta.froj.stdlib;

import com.jsaasta.froj.FrojCallable;
import com.jsaasta.froj.Interpreter;
import com.jsaasta.froj.RuntimeError;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Input implements FrojCallable {

    @Override
    public int arity() {
        return 0;
    }

    @Override
    public Object call(Interpreter interpreter, List<Object> arguments) {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input);
        System.out.print("> ");
        try {
            String line = reader.readLine();
            return line;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "<native fn Clock()>";
    }

}
