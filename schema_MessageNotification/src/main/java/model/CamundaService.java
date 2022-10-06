package model;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.stereotype.Service;

@Service
public class CamundaService {
    private RuntimeService runtime;

    public void startEvent() {
        ProcessInstance result = runtime.createMessageCorrelation("startMessage")
                .processInstanceBusinessKey(null)
                .correlateStartMessage();
    }
}
