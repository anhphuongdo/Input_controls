package com.example.myapplication;

public class user {
    private String name;
    private String phone_number;
    private Boolean gender;
    private String academic_standard;
    private Short age;
    private Boolean sport;
    private String music;

    public user(String name, String phone_number, Boolean gender, String academic_standard, Short age, Boolean sport, String music) {
        this.name = name;
        this.phone_number = phone_number;
        this.gender = gender;
        this.academic_standard = academic_standard;
        this.age = age;
        this.sport = sport;
        this.music = music;
    }

    @Override
    public String toString() {
        return "user{" +
                "name='" + name + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", gender=" + gender +
                ", academic_standard='" + academic_standard + '\'' +
                ", age=" + age +
                ", sport=" + sport +
                ", music='" + music + '\'' +
                '}';
    }
}
