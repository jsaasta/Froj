package com.jsaasta.froj.stdlib;

import com.jsaasta.froj.FrojCallable;
import com.jsaasta.froj.Interpreter;

import java.util.List;

/**
 * @return Returns current time in nanoSeconds / 1000;
 */
public class Clock implements FrojCallable {

    @Override
    public int arity() {
        return 0;
    }

    @Override
    public Object call(Interpreter interpreter, List<Object> arguments) {
        return (double) System.nanoTime() / 1000.0;
    }

    @Override
    public String toString() {
        return "<native fn Clock()>";
    }

}
