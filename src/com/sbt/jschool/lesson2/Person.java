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
        if ((person.man != this.man)&&(this.spouse != person)) {
            person.divorce();
            this.divorce();
            person.spouse = this;
            this.spouse = person;
            return true;
        } else return false;
    }

    public boolean divorce() {
        if (this.spouse != null) {
            this.spouse.spouse = null;
            this.spouse = null;
            return true;
        } else return false;
    }

}
