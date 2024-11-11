package com.camunda.demo.BpmnCommunication;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class AskTDogForHelp implements JavaDelegate{

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
		String question = (String) execution.getVariable("question");
		
		execution.getProcessEngineServices().getRuntimeService()
		.createMessageCorrelation("AskTDog")
		.correlate();
		
	}

}
