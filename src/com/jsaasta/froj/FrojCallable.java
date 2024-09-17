package com.jsaasta.froj;

import java.util.List;

public interface FrojCallable {

    int arity();

    Object call(Interpreter interpreter, List<Object> arguments);
}
