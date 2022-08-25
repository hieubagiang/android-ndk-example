LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE := recursion

LOCAL_SRC_FILES := connect.c

include $(BUILD_SHARED_LIBRARY)