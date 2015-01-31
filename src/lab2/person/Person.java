package lab2.person;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Person {

    private String name;
    private int age;

    public Person() {
        this.name = "test";
        this.age = 50;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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

}
