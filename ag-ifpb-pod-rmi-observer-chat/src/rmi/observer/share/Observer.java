package rmi.observer.share;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Observer extends Remote {
  void notifyObserver(Message message) throws RemoteException;
}
