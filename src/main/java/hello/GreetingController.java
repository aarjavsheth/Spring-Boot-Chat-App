package hello;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

/* Message handling controller */
@Controller
public class GreetingController {

    @MessageMapping("/hello") //ensures if a message is sent to /hello then greeting method is called
    @SendTo("/topic/greetings") //greeting is sent to all users subscribed to /topic/greetings
    public Greeting greeting(HelloMessage message) throws InterruptedException {
        Thread.sleep(500); //simulated delay
        return new Greeting("Hello " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }
}
