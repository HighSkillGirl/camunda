package model;

import controller.MessageController;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class ShowMessage implements JavaDelegate {
    MessageController controller;

    ShowMessage(MessageController controller) {
        this.controller = controller;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        controller.showMessage();
    }
}
