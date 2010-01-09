package de.alombra.dine.steps.execution.content;



public class Content {

  private Encoding encoding;
  private String text;
 
  
  public Content( String text, Encoding encoding ) {
    super();
    
    this.encoding = encoding;
    this.text = text;
  }
  
  public Encoding getEncoding() {
    return encoding;
  }
  public String getText() {
    return text;
  }
  
}
