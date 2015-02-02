package lab2.person;

//импорт класса Endpoint из пакета javax.xml.ws
import javax.xml.ws.Endpoint;

public class PersonPublisher {

    //точка входа в JVM, выполнение любой Java программы начинается с main-метода
    public static void main(String[] args) {
        /*запуск "вещания", Endpoint принимает 2 параметра - адрес сервиса и его реализацию.
        * localhost - адрес машины, localhost - будет доступен только на локальном компьютере
        * 9999 - номер порта, надо чтобы порт не был занят, занятые порты можно проверить с помощью программы TCP View
        * /ws/person - мапинг на SOAP сервис
        *
        * PersonWebserviceImpl - класс, реализующий интерфейс PersonWebService
        * */
        Endpoint.publish("http://localhost:9999/ws/person", new PersonWebserviceImpl());
    }

}
