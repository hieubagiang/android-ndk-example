//
// Created by Admin on 8/25/2022.
//

#include <jni.h>
#include <string.h>
#define TRUE 1
#define FALSE 0

jint
Java_com_hieu_myandroidnativeapp_MainActivity_isPrimeNumber(JNIEnv *env, jobject thiz,
                                                            jint number) {
    jboolean isPrime = TRUE;
    for(int i=2;i<=number/2;i++){
        if(number%i==0){
            return FALSE;
        }else{
            isPrime=TRUE;
        }
    }
    return isPrime;
}