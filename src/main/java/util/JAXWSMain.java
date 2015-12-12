package util;

import jaxws.endpoint.CompanyServiceImpl;

import javax.xml.ws.Endpoint;

public class JAXWSMain {
    public static void main(String[] args) throws InterruptedException {
        Endpoint.publish("http://localhost:8081/jax-ws", new CompanyServiceImpl());

        Thread.sleep(1000);
//        (new jaxws.client.CompanyServiceWS()).getCompanyServiceImplPort();
    }
}
