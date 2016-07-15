import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


//servidor
public class Main {

  public static void main(String[] args) 
      throws AccessException, RemoteException, AlreadyBoundException {
    Registry registry = LocateRegistry.createRegistry(10999);
    registry.bind("PersonServiceJNDI", new PersonServiceImpl());
  }
  
}
