package lab2.helloworld;

import lab2.person.PersonWebService;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;

public class HelloWorldClient {

    public static void main(String[] args) throws Exception {
        URL url = new URL("http://localhost:9999/ws/hello?wsdl");

        //1-st argument - service URI, refer to WSDL document above
        //2-st argument - service name, refer to WSDL document above
        QName qName = new QName("http://helloworld.lab2/", "HelloWorldImplService");

        Service service = Service.create(url, qName);

        PersonWebService hello = service.getPort(PersonWebService.class);

        //System.out.println(hello.getHelloWorldAsString("test"));
    }

}
