package rmi.pubsub.client;

import java.rmi.RemoteException;

import rmi.pubsub.share.Message;

public interface ChatClient {
  void sendMessage(Message message) throws RemoteException ;
}
