package com.interviewprep.String;

public class ReferenceConcept {

    public void checkRefConcept(Name name){
        System.out.println("Inside checkRefConcept");
        name.setName("XXXX");

        name =null;
    }

    public static void main(String[] args) {
        Person p = new Person();
        p.setName(new Name("Mohit"));


        ReferenceConcept ref = new ReferenceConcept();
        ref.checkRefConcept(p.getName());

        System.out.println(">> "+p.getName().getName());

        System.out.println("Exit !!!");
    }
}
