package ag.ifpb.pod.rmishare;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Person implements Serializable {
  private int id;
  private String name;
  
  public Person() {
  }
  
  public int getId() {
    return id;
  }
  
  public void setId(int id) {
    this.id = id;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getName() {
    return name;
  }
  
}
