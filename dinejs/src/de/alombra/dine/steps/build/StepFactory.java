package de.alombra.dine.steps.build;

import de.alombra.dine.steps.Step;

public interface StepFactory {

	public Step getStep( String name );

}