LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE := nativeFibonacci

LOCAL_SRC_FILES := nativeFibonacci.c

include $(BUILD_SHARED_LIBRARY)