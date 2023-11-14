import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import util.Driver;

public class Hooks {

    HomePage homePage;


    @BeforeMethod
    public void setup() {
        Driver.initWebDriver();

        homePage = new HomePage(Driver.getWebDriver());

        //Sleep added only for browser to be visible
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Driver.getWebDriver().manage().window().maximize();
        Driver.getWebDriver().get("http://www.hotwire.com/");

    }


    @AfterMethod
    public void cleanUp() {
        System.out.println("Closing ChromeDriver");
        Driver.quit();
    }
}
