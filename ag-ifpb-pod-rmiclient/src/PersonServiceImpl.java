import java.rmi.RemoteException;

import ag.ifpb.pod.rmishare.Person;
import ag.ifpb.pod.rmishare.PersonService;


public class PersonServiceImpl implements PersonService {

  @Override
  public void save(Person p) throws RemoteException {
    //recuperar o servico remoto e mandar executar
  }
  
  @Override
  public String isOK() throws RemoteException {
    //recuperar o servico remoto e mandar executar
    return null;
  }

}
