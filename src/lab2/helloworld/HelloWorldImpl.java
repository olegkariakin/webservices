package lab2.helloworld;

import javax.jws.WebService;

@WebService(endpointInterface = "lab2.helloworld.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

    @Override
    public String getHelloWorldAsString(String name) {
        return "Hello world jax-ws " + name;
    }

}
