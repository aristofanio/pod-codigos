package rmi.observer.share;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ChatService extends Remote{
  void sendMessage(Message message) throws RemoteException;
}
