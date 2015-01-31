package lab2.person;

import javax.xml.ws.Endpoint;

public class PersonPublisher {

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9999/ws/person", new PersonWebserviceImpl());
    }

}
