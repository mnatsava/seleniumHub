import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * @author Sargis Sargsyan on 5/20/21
 * @project picsart-internal-training
 */
public class ChallengeTest extends TestBase {

    @Test
    public void qrTest(){
        ChallengePage challengePage = new ChallengePage("ircbadmintonbirdie");
        challengePage.clickParticipate();
        GetFreeAppDialog getFreeAppDialog = new GetFreeAppDialog();
        assertTrue(getFreeAppDialog.isQrVisible(), "QR was not displayed!");
    }

}
