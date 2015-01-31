package lab2;

import javax.jws.WebService;

@WebService(endpointInterface = "lab2.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

    @Override
    public String getHelloWorldAsString(String name) {
        return "Hello world jax-ws " + name;
    }

}
