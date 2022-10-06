package basic.controller;

import basic.model.Info;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import basic.model.CamundaService;

import java.util.logging.Logger;

@RestController
@RequestMapping("api/v1")
public class MessageController {

    private final Info info;
    private final CamundaService camunda;
    private static final Logger log = Logger.getLogger(MessageController.class.getName());

    MessageController(Info info, CamundaService camunda) {
        this.info = info;
        this.camunda = camunda;
    }

    @PostMapping("/send")
    public ResponseEntity<String> enterMessage (@RequestParam String message) {
        info.setMessage(message);

        assert info.getMessage() != null : "Message is null (assert ... )";
        Assert.notNull(info.getMessage(), "Message is null (Assert.notNoll)");

        log.info("Сообщение с контроллера получено и сохранено в поле MessageService");

        camunda.startEvent();
        log.info("процесс стартовал");

        return ResponseEntity.ok("Сообщение отправлено");
    }

    @GetMapping("/get")
    public ResponseEntity<String> showMessage() {
        return info.isMessageEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(info.getMessage());
    }
}
