package rmi.observer.client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import rmi.observer.share.ChatService;
import rmi.observer.share.Message;
import rmi.observer.share.Observer;

@SuppressWarnings("serial")
public class ChatClient extends UnicastRemoteObject implements ChatService, Observer{
  private final ChatService stub;
  
  public ChatClient(ChatService service) throws RemoteException{
    stub = service;
  }

  @Override
  public void sendMessage(Message message) throws RemoteException {
    stub.sendMessage(message);
  }
  
  @Override
  public void notifyObserver(Message message) throws RemoteException {
    System.out.println(message.from() + ": " + message.getText());
  }
  
}
