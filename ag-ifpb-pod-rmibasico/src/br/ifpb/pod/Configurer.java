package br.ifpb.pod;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Configurer extends Remote {
  String value1() throws RemoteException;
  String value2() throws RemoteException;
  void result(String value) throws RemoteException;
}
