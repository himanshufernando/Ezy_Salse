#include <jni.h>


JNIEXPORT jstring
Java_tkhub_project_ezysales_services_network_api_NetworkModule_getBaseURL(JNIEnv *env,jobject thiz) {
    return (*env)->NewStringUTF(env, "http://192.168.1.6:5000/");
}