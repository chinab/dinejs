package de.alombra.dine.steps.build;

import de.alombra.dine.steps.Executable;
import de.alombra.dine.steps.Step;

public interface StepFactory {

	public Step getStep( String name );
	public Executable getExecutable( String name );
}