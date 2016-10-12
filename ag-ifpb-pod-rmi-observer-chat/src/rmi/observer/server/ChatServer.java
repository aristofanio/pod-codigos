package rmi.observer.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import rmi.observer.share.ChatService;
import rmi.observer.share.Message;
import rmi.observer.share.Observer;
import rmi.observer.share.Subject;

@SuppressWarnings("serial")
public class ChatServer extends UnicastRemoteObject implements ChatService, Subject {
  private Map<String, Observer> observers = new HashMap<>();

  public ChatServer() throws RemoteException {
    super();
  }

  @Override
  public void addObserver(String uuid, Observer observer) throws RemoteException {
    System.out.println("Registrando um observer: " + uuid);
    observers.put(uuid, observer);
  }

  @Override
  public void sendMessage(Message message) throws RemoteException {
    System.out.println("Recebendo uma mensagem de " + message.from());
    Set<String> uuids = observers.keySet();
    System.out.println("Tentar notificar observadores: ");
    for (String u : uuids) {
      if (!message.from().equals(u)){
        System.out.println("- notificando observador " + u);
        Observer o = observers.get(u);
        o.notifyObserver(message);
      }
    }
    System.out.println("Tentativa de notificação encerrada.");
  }

}
