package rmi.pubsub.share;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Topic extends Remote{
  void register(String uuid, Subscriber subscriber) throws RemoteException;
}
