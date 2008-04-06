package de.alombra.dine.steps.execution.impl;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import de.alombra.dine.steps.execution.ExecutionQueue;
import de.alombra.dine.steps.execution.instruction.Instruction;

public class BlockingExecutionQueue implements ExecutionQueue {

	private BlockingQueue<Instruction> instructionQueue = new LinkedBlockingQueue<Instruction>();
	
	private static final Log logger = LogFactory.getLog( BlockingExecutionQueue.class );
	
	public ExecutionQueue addInstruction( Instruction instruction ) {

	  instructionQueue.offer( instruction );
	  
	  logger.debug( "added instruction ("+instructionQueue.size()+" currently queued)" );
	  
	  return this;
	}

	public Instruction getNextInstruction() { 

	  Instruction nextInstruction = instructionQueue.poll();
	  
	  if ( null != nextInstruction )
	    logger.debug( "removed instruction ("+instructionQueue.size()+" currently queued)" );
	  
	  return nextInstruction;
	}

}
