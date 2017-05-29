import com.twilio.twiml.Gather;
import com.twilio.twiml.VoiceResponse;
import com.twilio.twiml.Say;
import com.twilio.twiml.TwiMLException;
import com.twilio.twiml.Method;


public class Example {
    public static void main(String[] args) {
        Say say = new Say
            .Builder("Please enter your account number,\nfollowed by the pound sign")
            .build();
        Gather gather = new Gather.Builder().action("/process_gather.php")
            .method(Method.GET).say(say).build();
        Say say2 = new Say.Builder("We didn't receive any input. Goodbye!")
            .build();
        VoiceResponse response = new VoiceResponse.Builder().gather(gather)
            .say(say2).build();

        try {
            System.out.println(response.toXml());
        } catch (TwiMLException e) {
            e.printStackTrace();
        }
    }
}
