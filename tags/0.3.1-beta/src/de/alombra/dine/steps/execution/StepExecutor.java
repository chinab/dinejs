package de.alombra.dine.steps.execution;

import de.alombra.dine.http.HttpManager;
import de.alombra.dine.runtime.callback.DownloadCallback;
import de.alombra.dine.steps.StepHolder;
import de.alombra.dine.steps.StepMemory;
import de.alombra.dine.steps.execution.instruction.Instruction;

public interface StepExecutor {

	public void start();
	
	public void notifyOfTermination();

	public void addInstruction( Instruction instruction );
	
	public HttpManager getHttpManager();
	public StepHolder getStepHolder();
	public StepMemory getStepMemory();
	
	public DownloadCallback getDownloadCallback();
}