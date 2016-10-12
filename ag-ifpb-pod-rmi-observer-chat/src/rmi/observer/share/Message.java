package rmi.observer.share;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Message implements Serializable {
  private String from;
  private String text;
  
  public String from(){
    return from;
  }
  
  public void setFrom(String uuid){
    from = uuid;
  }
  
  public String getText() {
    return text;
  }
  
  public void setText(String text) {
    this.text = text;
  }
}
