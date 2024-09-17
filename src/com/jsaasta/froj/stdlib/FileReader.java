package com.jsaasta.froj.stdlib;

import com.jsaasta.froj.Froj;
import com.jsaasta.froj.FrojCallable;
import com.jsaasta.froj.Interpreter;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileReader implements FrojCallable {
    @Override
    public int arity() {
        return 1;
    }

    @Override
    public Object call(Interpreter interpreter, List<Object> arguments) {

        try {
            byte[] bytes = Files.readAllBytes(Paths.get((String) arguments.get(0)));
            return new String(bytes, Charset.defaultCharset());
        } catch (IOException e) {
           throw new StdlibRuntimeError("Couldn't find file: " + arguments.get(0));
        }
    }
}
