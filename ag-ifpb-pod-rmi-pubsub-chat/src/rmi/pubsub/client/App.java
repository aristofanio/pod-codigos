package rmi.pubsub.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import java.util.UUID;

import rmi.pubsub.share.Message;
import rmi.pubsub.share.Publisher;
import rmi.pubsub.share.Topic;

public class App {

  public static void main(String[] args) throws RemoteException, NotBoundException {
    //
    String uuid = UUID.randomUUID().toString();
    //
    Registry registry = LocateRegistry.getRegistry(10999);
    Topic topic = (Topic) registry.lookup("__ChatServer__");
    Publisher publisher = (Publisher) registry.lookup("__ChatServer__");
    //
    ChatClientImpl client = new ChatClientImpl(publisher);
    topic.register(uuid, client);
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
