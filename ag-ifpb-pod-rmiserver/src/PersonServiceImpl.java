import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import ag.ifpb.pod.rmishare.Person;
import ag.ifpb.pod.rmishare.PersonService;

//Servidor
@SuppressWarnings("serial")
public class PersonServiceImpl extends UnicastRemoteObject implements
    PersonService {
  
  private int i = 0;

  public PersonServiceImpl() throws RemoteException {
    //super();<- implicitamente adicionado
  }

  @Override
  public void save(Person p) throws RemoteException {
    try {
      //criar o stream do arquivo person.dat
      FileOutputStream out = new FileOutputStream("person.dat");
      //criar o stream do objeto Person (p)
      ObjectOutputStream outputStream = new ObjectOutputStream(out);
      //escrever o objeto no stream
      outputStream.writeObject(p);
      //fechar o stream do objeto
      outputStream.close();
      //fechar o stream do arquivo
      out.close();
    } 
    catch (FileNotFoundException e) {
      e.printStackTrace();
    } 
    catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  @Override
  public String isOK() throws RemoteException {
    return "[" + (i++) + "] Está tudo joia!";
  }

}
