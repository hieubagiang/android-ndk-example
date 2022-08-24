#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_hieu_myandroidnativeapp_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}
extern "C" JNIEXPORT jstring JNICALL
Java_com_hieu_myandroidnativeapp_MainActivity_helloFromNative(
        JNIEnv* env,
jobject /* this */) {
std::string hello = "Hello from native";
return env->NewStringUTF(hello.c_str());
}
