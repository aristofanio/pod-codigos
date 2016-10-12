package rmi.observer.server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class App {

  public static void main(String[] args) throws RemoteException, AlreadyBoundException {
    Registry registry = LocateRegistry.createRegistry(10999);
    registry.bind("__ChatServer__", new ChatServer());
  }
  
}
