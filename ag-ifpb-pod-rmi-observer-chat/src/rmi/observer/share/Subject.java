package rmi.observer.share;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Subject extends Remote{
  void addObserver(String uuid, Observer observer) throws RemoteException;
}
