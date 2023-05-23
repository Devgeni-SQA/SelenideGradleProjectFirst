package immoviewer;
import com.github.seratch.jslack.Slack;
import com.github.seratch.jslack.api.webhook.Payload;

public class SlackIntegrationTest {

    private static String webHooksUrl = "https://hooks.slack.com/services/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";
    private static String oAuthToken = "xoxb-5293775136326-5303003187780-fUY8zInmsNGbSuvPBVmMpp8z";
    private static String slackChannel = "tests_results";

    public static void main(String[] args) {
        sendMsgToSlack("Test2 message");
    }

    public static void sendMsgToSlack(String msg) {
        try {
            Payload payload = Payload.builder().text(slackChannel).text(msg).build();
            Slack.getInstance().send(webHooksUrl, payload);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
