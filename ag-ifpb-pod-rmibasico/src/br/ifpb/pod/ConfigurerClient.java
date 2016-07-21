package br.ifpb.pod;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ConfigurerClient {

  public static void main(String[] args) throws RemoteException, NotBoundException {
    //
    Registry registry = LocateRegistry.getRegistry("192.168.1.108", 10999);
    Configurer configurer = (Configurer) registry.lookup("Configurer");
    //
    String text = new StringBuffer()
        .append("O estudante ")
        .append(configurer.value1())
        .append(" está servindo em ")
        .append(configurer.value2())
        .toString();
    configurer.result(text);
  }
}
