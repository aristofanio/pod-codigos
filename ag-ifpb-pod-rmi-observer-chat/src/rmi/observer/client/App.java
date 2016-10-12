package rmi.observer.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import java.util.UUID;

import rmi.observer.share.ChatService;
import rmi.observer.share.Message;
import rmi.observer.share.Subject;

public class App {

  public static void main(String[] args) throws RemoteException, NotBoundException {
    //
    String uuid = UUID.randomUUID().toString();
    //
    Registry registry = LocateRegistry.getRegistry(10999);
    Subject subject = (Subject) registry.lookup("__ChatServer__");
    ChatService service = (ChatService) registry.lookup("__ChatServer__");
    //
    ChatClient client = new ChatClient(service);
    subject.addObserver(uuid, client);
    //
    Scanner scanner = new Scanner(System.in);
    while(true){
      //
      String text = scanner.nextLine();
      //
      Message message = new Message();
      message.setFrom(uuid);
      message.setText(text);
      //
      client.sendMessage(message);
    }
    
  }
  
}
