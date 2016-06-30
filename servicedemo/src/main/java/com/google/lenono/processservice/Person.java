package com.google.lenono.processservice;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by lenono on 2016-06-23.
 */
public class Person implements Parcelable {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        //把java转成parcel对象
        parcel.writeString(name);
        parcel.writeInt(age);

    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {

        @Override
        public Person createFromParcel(Parcel parcel) {
            //把parcel转成java对象
            String name = parcel.readString();
            int age = parcel.readInt();
            return new Person(name, age);
        }

        @Override
        public Person[] newArray(int i) {
            return new Person[0];
        }
    };
}
