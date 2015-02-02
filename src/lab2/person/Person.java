//пакет не по умолчанию - подойдет любой
package lab2.person;

//наши импорты класса
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Random;

@XmlRootElement //аннотация для JAXB, чтобы он начал преобразовывать объект в XML и обратно
public class Person {

    //здесь хранится имя человека
    private String name;
    //здесь хранится возраст человека
    private int age;
    //уникальный идентификатор - создан для удобства работы со структурой данных
    private long id;

    //конструктор по-умолчанию, инициализирует переменные значениями по-умолчанию
    public Person() {
        this.name = "test";
        this.age = 50;
        this.id = new Random().nextLong(); //генерация id при каждом создании объекта
    }

    //параметризованный конструктор, позволяет задавать значения атрибутов при создании объекта
    public Person(String name, int age, long id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    /*набор getter/setter-ов для доступа к переменным объекта,
    также они в большинстве случаев нужны для корректной работы JAXB и прочих фреймворков*/
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
