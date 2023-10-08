package com.s03.oop;

// Error is an exception that is not recommended to catch.
// When this kind of exception rise so the app must be stopped.
// so it is recommended to every to only use this kind of exception for error that cause the application has to be stopped.


public class p095Error {
    public static class TestError extends Error {
        public TestError(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {
        testError();
    }

    public static void testError(){
        throw new TestError("test error");
    }
}
