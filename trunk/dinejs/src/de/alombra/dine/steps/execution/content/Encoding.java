package de.alombra.dine.steps.execution.content;


public enum Encoding {

  UNKNOWN("UTF-8"),
  UTF_8("UTF-8"),
  ISO_8859_1("ISO-8859-1");
  
  private String identifier;
  
  private Encoding( String identifier ) {
    this.identifier = identifier;
  }

  public String getIdentifier() {
    return identifier;
  }
  
  // factory method
  public static Encoding getByIdentifier( String identifier ) {
    
    for ( Encoding encoding : Encoding.values() ) {
    
      if ( !encoding.equals( Encoding.UNKNOWN ) && encoding.getIdentifier().equalsIgnoreCase( identifier ) ) {
        return encoding;
      }
    }
    
    return Encoding.UNKNOWN;
  }
  
}
