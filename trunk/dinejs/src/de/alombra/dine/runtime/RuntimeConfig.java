package de.alombra.dine.runtime;

import de.alombra.dine.runtime.callback.DownloadCallback;
import de.alombra.dine.runtime.callback.MemoryCallback;
import de.alombra.dine.runtime.callback.ResolverCallback;
import de.alombra.dine.runtime.callback.SeedInstructionCallback;


public class RuntimeConfig {

  private int       maxConcurrentThreads = 50;  
  private boolean   allowCircularRedirects = false;
  private int       queueCheckInterval = 10;
  
  private ResolverCallback          resolverCallback;
  private SeedInstructionCallback   seedInstructionCallback;
  private MemoryCallback            memoryCallback;
  private DownloadCallback          downloadCallback;
  
  public int getMaxConcurrentThreads() {
    return maxConcurrentThreads;
  }
  public boolean isAllowCircularRedirects() {
    return allowCircularRedirects;
  }
  public ResolverCallback getResolverCallback() {
    return resolverCallback;
  }
  public SeedInstructionCallback getSeedInstructionCallback() {
    return seedInstructionCallback;
  }
  public MemoryCallback getMemoryCallback() {
    return memoryCallback;
  }
  public DownloadCallback getDownloadCallback() {
    return downloadCallback;
  }  
  public int getQueueCheckInterval() {
    return queueCheckInterval;
  }
  
  public RuntimeConfig setQueueCheckInterval( int queueCheckInterval ) {
    this.queueCheckInterval = queueCheckInterval;
    return this;
  }
  public RuntimeConfig setMaxConcurrentThreads( int maxConcurrentThreads ) {
    this.maxConcurrentThreads = maxConcurrentThreads;
    return this;
  }
  public RuntimeConfig setAllowCircularRedirects( boolean allowCircularRedirects ) {
    this.allowCircularRedirects = allowCircularRedirects;
    return this;
  }
  public RuntimeConfig setResolverCallback( ResolverCallback resolverCallback ) {
    this.resolverCallback = resolverCallback;
    return this;
  }
  public RuntimeConfig setSeedInstructionCallback( SeedInstructionCallback seedInstructionCallback ) {
    this.seedInstructionCallback = seedInstructionCallback;
    return this;
  }
  public RuntimeConfig setMemoryCallback( MemoryCallback memoryCallback ) {
    this.memoryCallback = memoryCallback;
    return this;
  }
  public RuntimeConfig setDownloadCallback( DownloadCallback downloadCallback ) {
    this.downloadCallback = downloadCallback;
    return this;
  }
  
  
  
  
}
