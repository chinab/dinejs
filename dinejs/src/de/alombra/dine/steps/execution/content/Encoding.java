package de.alombra.dine.steps.execution.content;

/**
 * used to model different common encodings
 * 
 * identifier must be a valid string used in 
 * a java.lang.String constructor
 * 
 * @author ssc
 */
public enum Encoding {

  UNKNOWN("UTF-8"),           // default: utf8
  UTF_8("UTF-8"),             // utf8
  ISO_8859_1("ISO-8859-1");   // iso-8859-1
  
  
  /**
   * identifier, this must be a valid
   * parameter for a java.lang.String 
   * constructor
   */
  private String identifier;
  
  private Encoding( String identifier ) {
    this.identifier = identifier;
  }

  public String getIdentifier() {
    return identifier;
  }
  

  /**
   * factory method for getting the appropriate value
   * for an encoding string
   */
  public static Encoding getByIdentifier( String identifier ) {
    
    for ( Encoding encoding : Encoding.values() ) {
    
      if ( !encoding.equals( Encoding.UNKNOWN ) && encoding.getIdentifier().equalsIgnoreCase( identifier ) ) {
        return encoding;
      }
      
    }
    
    // return default encoding, if we cannot find an appropriate
    return Encoding.UNKNOWN;
  }
  
}
