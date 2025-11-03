package veterinaria.app.adapters.rest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MainController {

    @GetMapping("/api")
    public String itsAlive() {
        return "i'm alive";
    }

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }
}
