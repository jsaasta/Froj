package com.jsaasta.froj;

/**
 * Used as a control flow class for "return" keyword.
 * Throw "silent" exceptions to traverse and unwind the callstack all back to Function.call();.
 */
public class Return extends RuntimeException {
    final Object value;

    public Return(Object value) {
        super(null, null, false, false);
        this.value = value;
    }
}
