package com.sbt.jschool.lesson2;

public class Person {
    private final boolean man;
    private final String name;
    private Person spouse;

    public Person(boolean man, String name) {
        this.man = man;
        this.name = name;
    }

    public boolean marry(Person person) {
        if ((person.man != man)&&(spouse != person)) {
            person.divorce();
            divorce();
            person.spouse = this;
            spouse = person;
            return true;
        }
        return false;
    }

    public boolean divorce() {
        if (spouse != null) {
            spouse.spouse = null;
            spouse = null;
            return true;
        }
        return false;
    }

}
