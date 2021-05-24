import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * @author Sargis Sargsyan on 5/20/21
 * @project picsart-internal-training
 */
public class CreateTest extends TestBase {
    @Test
    public void upload(){
        CreatePage createPage = new CreatePage();
        createPage.open();

        createPage.uploadPhoto();

        }
}
