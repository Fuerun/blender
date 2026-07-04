name=android/example-app/app/src/main/cpp/native-lib.cpp
#include <jni.h>
#include <android/log.h>

#define LOG_TAG "native-lib"
#define ALOG(...) __android_log_print(ANDROID_LOG_INFO, LOG_TAG, __VA_ARGS__)

extern "C" JNIEXPORT void JNICALL
Java_org_fuerun_example_MainActivity_onTouchEventNative(JNIEnv* env, jobject /* this */, jfloat x, jfloat y, jint action, jint pointerId) {
    ALOG("Touch event: action=%d pointer=%d x=%f y=%f", action, pointerId, x, y);
}
