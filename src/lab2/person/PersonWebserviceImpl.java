package lab2.person;

import javax.jws.WebService;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@WebService(endpointInterface = "lab2.person.PersonWebService")
public class PersonWebserviceImpl implements PersonWebService {

    private static final int CONTAINER_SIZE = 10;
    private static final Random RANDOM = new Random();

    private static Map<Long, Person> container = new HashMap<Long, Person>();

    static {
        for (int i = 0; i < CONTAINER_SIZE; i++) {
            long randomId = generateRandomNumber();
            container.put(randomId, new Person("Vasua #" + i, generateRandomNumber(), randomId));
        }
    }

    private static int generateRandomNumber() {
        return RANDOM.nextInt(CONTAINER_SIZE * CONTAINER_SIZE - CONTAINER_SIZE + 1) + CONTAINER_SIZE;
    }

    @Override
    public Person getPersonById(long id) {
        return container.get(id);
    }

    @Override
    public Person[] getAllPeople() {
        return container.values().toArray(new Person[container.values().size()]);
    }

    @Override
    public boolean removePersonById(long id) {
        boolean personExists = container.containsKey(id);
        container.remove(id);
        return personExists || container.containsKey(id);
    }

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
