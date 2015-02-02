package lab2.person;

import javax.jws.WebService;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/*
определение мапинга веб-сервиса, именно здесь и присутствует пакет, о котором упоминалось раньше.
* lab2.person - имя пакета
* PersonWebService - имя интерфейса, интерфейс должен находится в этом пакете
* */
@WebService(endpointInterface = "lab2.person.PersonWebService")
//реализация интерфейса PersonWebService
public class PersonWebserviceImpl implements PersonWebService {

    //определение размера контейнера
    private static final int CONTAINER_SIZE = 10;
    //генератор случайных чисел
    private static final Random RANDOM = new Random();

    //создание пустой внутренней структуры данных
    private static Map<Long, Person> container = new HashMap<Long, Person>();

    //инициализация структуры данных заполненными объектами
    static {
        for (int i = 0; i < CONTAINER_SIZE; i++) {
            long randomId = generateRandomNumber();
            container.put(randomId, new Person("Vasua #" + i, generateRandomNumber(), randomId));
        }
    }
    // метод для генерации случайных числе по указанному диапазону
    private static int generateRandomNumber() {
        return RANDOM.nextInt(CONTAINER_SIZE * CONTAINER_SIZE - CONTAINER_SIZE + 1) + CONTAINER_SIZE;
    }

    // возвращает объект по его идентификатору
    @Override
    public Person getPersonById(long id) {
        return container.get(id);
    }

    //возвращает список всех объектов
    @Override
    public Person[] getAllPeople() {
        return container.values().toArray(new Person[container.values().size()]);
    }

    //удаляет объект по его идентификатор, возвращает true, если объект был удален и false - если нет
    @Override
    public boolean removePersonById(long id) {
        boolean personExists = container.containsKey(id);
        container.remove(id);
        return personExists || container.containsKey(id);
    }

    //обновление данных объекта в данном случае имя и возраст, id не обновляется, т.к. служит ключом
    @Override
    public boolean updatePerson(Person person) {
        Person personToUpdate = container.get(person.getId());
        if (personToUpdate == null) {
            return false;
        } else {
            personToUpdate.setName(person.getName());
            personToUpdate.setAge(person.getAge());
            return true;
        }
    }

}
