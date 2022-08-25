//
// Created by Admin on 8/25/2022.
//

#include"com_hieu_myandroidnativeapp_Connect.h"

jint sum=0;

jint nativeRecursive(jint n) {

    if(n!=0)

    {

        n+=nativeRecursive(n-1)+nativeRecursive(n-1);

    }

    return n;

}

jint Java_com_hieu_myandroidnativeapp_Connect_nativeRecursive

        (JNIEnv *env, jclass obj, jint n) {

    return nativeRecursive(n);

}

