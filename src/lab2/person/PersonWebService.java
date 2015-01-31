package lab2.person;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface PersonWebService {

    @WebMethod
    Person getPersonById(long id);

    @WebMethod
    boolean removePersonById(long id);

    @WebMethod
    boolean updatePerson(Person person);

    @WebMethod
    //JAXB cannot handle interfaces, so we have to use ArrayList as a List implementation
    Person[] getAllPeople();
}
