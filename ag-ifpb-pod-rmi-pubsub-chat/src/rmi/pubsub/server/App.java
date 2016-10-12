package rmi.pubsub.server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Timer;
import java.util.TimerTask;

public class App {

  public static void main(String[] args) throws RemoteException, AlreadyBoundException {
    //
    final TopicManager manager = new TopicManagerImpl();
    //
    Registry registry = LocateRegistry.createRegistry(10999);
    registry.bind("__ChatServer__", manager);
    //
    Timer timer = new Timer();
    timer.schedule(new TimerTask() {
      @Override
      public void run() {
        try {
          manager.notifySubscribers();
        } catch (RemoteException e) {
          e.printStackTrace();
        }
      }
    }, 1000, 10000);//1s, 10s
  }
  
}
