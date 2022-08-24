//
// Created by Admin on 8/25/2022.
//

#include <jni.h>
#include <string.h>

jstring Java_com_hieu_myandroidnativeapp_MainActivity_ndkBuildTestFromJNI(JNIEnv *env, jobject thiz) {
    return (*env)->NewStringUTF(env, "ndkBuildTestFromJNI !");
}