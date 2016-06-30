// IMyAidlInterface.aidl
package com.google.lenono.processservice;

// Declare any non-default types here with import statements

interface IMyAidlInterface {
    int add(int a,int b);
    List<String> getData(in List<String> data);
}
