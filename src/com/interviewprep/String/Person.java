package com.interviewprep.String;

public class Person {
    Name name;

    public void setName(Name name) {
        this.name = name;
    }
    public Name getName(){
        return this.name;
    }
    public void clean(){
        name=null;
    }
}
