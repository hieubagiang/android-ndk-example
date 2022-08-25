LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE := isPrimeNumber

LOCAL_SRC_FILES := isPrimeNumber.c

include $(BUILD_SHARED_LIBRARY)