package com.hieu.myandroidnativeapp;

public class Connect {
    public static long javaFibonacci(long n) {
        if (n <= 0)
            return 0;
        if (n == 1)
            return 1;
        return javaFibonacci(n - 1) + javaFibonacci(n - 2);
    }

    static {
        System.loadLibrary("nativeFibonacci");
    }

    public static native int nativeFibonacci(int n);


}
