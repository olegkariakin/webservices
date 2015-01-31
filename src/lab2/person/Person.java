package lab2.person;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Random;

@XmlRootElement
public class Person {

    private String name;
    private int age;
    private long id;

    public Person() {
        this.name = "test";
        this.age = 50;
        this.id = new Random().nextLong();
    }

    public Person(String name, int age, long id) {
        this.name = name;
        this.age = age;
        this.id = id;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
