package lab2.person;

import javax.jws.WebService;
import java.util.HashMap;
import java.util.Map;

@WebService(endpointInterface = "lab2.person.PersonWebService")
public class PersonWebserviceImpl implements PersonWebService {

    private static Map<Integer, Person> container = new HashMap<Integer, Person>();
    static {
        container.put(100500, new Person("Vasua", 100500));
        container.put(555, new Person("Petua", 555));
        container.put(333, new Person("Sidorov", 333));
    }

    @Override
    public Person getPersonByAge(int age) {
        return container.get(age);
    }

    @Override
    public Person[] getAllPeople() {
        return container.values().toArray(new Person[container.values().size()]);
    }

    @Override
    public boolean removePersonByAge(int age) {
        boolean personExists = container.containsKey(age);
        container.remove(age);
        return personExists || container.containsKey(age);
    }

    @Override
    public boolean updatePerson(Person person) {
        Person personToUpdate = container.get(person.getAge());
        if (personToUpdate == null) {
            return false;
        } else {
            personToUpdate.setName(person.getName());
            return true;
        }
    }

}
