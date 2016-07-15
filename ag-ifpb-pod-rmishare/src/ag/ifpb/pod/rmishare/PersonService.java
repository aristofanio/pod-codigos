package ag.ifpb.pod.rmishare;

import java.rmi.Remote;
import java.rmi.RemoteException;

//share
public interface PersonService extends Remote {
  
  void save(Person p) throws RemoteException;
  
  String isOK() throws RemoteException;

}
