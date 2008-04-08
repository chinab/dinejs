package de.alombra.dine.run;


public class RuntimeConfig {

  private Integer maxConcurrentThreads;
  private String stepsBaseDir;
  private String downloadBaseDir;
  private String seedStep;
  
  private static RuntimeConfig instance;

  private RuntimeConfig( Integer maxConcurrentThreads, String stepsBaseDir, String downloadBaseDir, String seedStep ) {
    super();
    this.maxConcurrentThreads = maxConcurrentThreads;
    this.stepsBaseDir = stepsBaseDir;
    this.downloadBaseDir = downloadBaseDir;
    this.seedStep = seedStep;
  }
  
  public static void init( Integer maxConcurrentThreads, String stepsBaseDir, String downloadBaseDir, String seedStep ) {
    instance = new RuntimeConfig( maxConcurrentThreads, stepsBaseDir, downloadBaseDir, seedStep );
  }
  
  public static RuntimeConfig getInstance() {
    return instance;
  }
  public Integer getMaxConcurrentThreads() {
    return maxConcurrentThreads;
  }
  public String getStepsBaseDir() {
    return stepsBaseDir;
  }
  public String getDownloadBaseDir() {
    return downloadBaseDir;
  } 
  public String getSeedStep() {
    return seedStep;
  }
  
 
  
}
