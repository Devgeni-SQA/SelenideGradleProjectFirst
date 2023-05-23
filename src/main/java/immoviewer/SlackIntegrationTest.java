package immoviewer;
import com.github.seratch.jslack.Slack;
import com.github.seratch.jslack.api.webhook.Payload;
import java.io.IOException;

public class SlackIntegrationTest {

    public static void main(String[] args) throws IOException {
        sendMsgToSlack("Test2 message");
    }

    public static void sendMsgToSlack(String msg) throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("conf.properties"));
        try {
            Payload payload = Payload.builder().text(System.getProperty("slackChannel")).text(msg).build();
            Slack.getInstance().send(System.getProperty("webHooksUrl"), payload);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
