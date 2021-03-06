// Install the Java helper library from twilio.com/docs/java/install
import com.twilio.sdk.TwilioPricingClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.instance.pricing.MessagingCountry;

public class Example {

  // Find your Account Sid and Token at twilio.com/user/account
  public static final String ACCOUNT_SID = "ACXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
  public static final String AUTH_TOKEN = "your_auth_token";

  public static void main(String[] args) throws TwilioRestException {
    TwilioPricingClient client = new TwilioPricingClient(ACCOUNT_SID, AUTH_TOKEN);

    // Get Twilio Messaging pricing information for a specific country
    MessagingCountry mc = client.getMessagingCountry("EE");

    for (MessagingCountry.MessagingPrice p : mc.getInboundSmsPrices()) {
      // For each message pricing category, print number type and
      // current (reflecting any discounts your account has) price.
      System.out.println(p.getNumberType().toString());
      System.out.println(p.getCurrentPrice().toString());
    }
  }
}
