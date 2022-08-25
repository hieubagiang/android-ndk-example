package com.hieu.myandroidnativeapp;

public class Connect {
    public static long javaRecursive(long n) {

        if(n!=0)

        {

            n+=javaRecursive(n-1)+javaRecursive(n-1);

        }

        return n;

    }

    static {

        System.loadLibrary("recursion");

    }

    public static native int nativeRecursive(int n);


}
