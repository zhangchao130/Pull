// IMyAidlInterface.aidl
package com.google.lenono.processservice;
import  com.google.lenono.processservice.Person;
// Declare any non-default types here with import statements

interface IMyAidlInterface {
    int add(int a,int b);
    List<String> getData(in List<String> data);
}
