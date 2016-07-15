import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import ag.ifpb.pod.rmishare.Person;
import ag.ifpb.pod.rmishare.PersonService;

//cliente
public class Main {

  public static void main(String[] args) throws 
      RemoteException, NotBoundException{
    //criar um Person
    Person p = new Person();
    p.setId(10);
    p.setName("Ari Garcia");
    //
    Registry registry = LocateRegistry.getRegistry(10999);
    PersonService service = (PersonService) registry.lookup(
        "PersonServiceJNDI"
    );
    service.save(p);
    //
    System.out.println(service.isOK());
    
  }
}
