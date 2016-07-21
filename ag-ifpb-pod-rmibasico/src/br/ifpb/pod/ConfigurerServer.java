package br.ifpb.pod;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ConfigurerServer extends UnicastRemoteObject implements Configurer {

  protected ConfigurerServer() throws RemoteException {
    super();
  }

  @Override
  public String value1() throws RemoteException {
    return "Ari";
  }

  @Override
  public String value2() throws RemoteException {
    return "192.168.1.108";
  }

  @Override
  public void result(String value) throws RemoteException {
    System.out.println(value);
  }
  
  public static void main(String[] args) throws RemoteException, AlreadyBoundException {
    //
    System.setProperty("java.rmi.server.hostname", "192.168.1.108");
    //
    Registry registry = LocateRegistry.createRegistry(10999);
    registry.bind("Configurer", new ConfigurerServer());
  }
  
}
