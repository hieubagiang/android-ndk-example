//
// Created by Admin on 8/25/2022.
//

#include"com_hieu_myandroidnativeapp_Connect.h"

jint nativeFibonacci(jint n) {

    if (n <= 0)
        return 0;
    if (n == 1)
        return 1;
    return nativeFibonacci(n - 1) + nativeFibonacci(n - 2);
}

jint Java_com_hieu_myandroidnativeapp_Connect_nativeFibonacci

        (JNIEnv *env, jclass obj, jint n) {

    return nativeFibonacci(n);

}

