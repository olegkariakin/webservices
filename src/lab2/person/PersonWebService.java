package lab2.person;

//нужные импорты для работы с SOAP-веб-сервисом
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC) //определение типа SOAP-связывания
public interface PersonWebService { //интерфейс определяет методы, которые будет представлять SOAP-вебсервис


    @WebMethod //аннотация для того, чтобы Publisher понимал этот метод как SOAP
    //метод возвращает объект Person по его Id
    Person getPersonById(long id);

    @WebMethod
    //метод удаляет объект Person по его Id
    boolean removePersonById(long id);

    @WebMethod
    //метод обновляет объект Person, заменяя его данные
    boolean updatePerson(Person person);

    @WebMethod
    //возвращает массив всех объектов класса Person
    Person[] getAllPeople();
}
