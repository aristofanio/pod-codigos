package rmi.pubsub.client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import rmi.pubsub.share.Message;
import rmi.pubsub.share.Publisher;
import rmi.pubsub.share.Subscriber;

@SuppressWarnings("serial")
public class ChatClientImpl extends UnicastRemoteObject implements ChatClient, Subscriber{
  private final Publisher stub;
  
  public ChatClientImpl(Publisher publisher) throws RemoteException{
    stub = publisher;
  }

  
  @Override
  public void sendMessage(Message message) throws RemoteException {
    stub.publish(message);
  }
  
  @Override
  public void update(Message message) throws RemoteException {
    System.out.println(message.from() + ": " + message.getText());
  }
  
}
