#include <jni.h>
#include "environ/environ.h"
#include <android/native_window.h>
#include <android/native_window_jni.h>

//
// Created by RaydanOMGr on 16.05.2025.
//

JNIEXPORT jboolean JNICALL
Java_git_artdeell_mojoapi_MojoAPI_isForceVSync(JNIEnv *env, jclass clazz) {
    return pojav_environ->force_vsync;
}

JNIEXPORT jint JNICALL
Java_git_artdeell_mojoapi_MojoAPI_getWidth(JNIEnv *env, jclass clazz) {
    return pojav_environ->savedWidth;
}


JNIEXPORT jint JNICALL
Java_git_artdeell_mojoapi_MojoAPI_getHeight(JNIEnv *env, jclass clazz) {
    return pojav_environ->savedHeight;
}