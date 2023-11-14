import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidateSearchFunctionality extends Hooks {


    @Test
    public void validateSearchFunctionality() throws InterruptedException {

        //Actions
        homePage.clickBundlesMenuOption();
        homePage.clickEveryUnclickedBundleOptionIfNotClickedAlready();
        homePage.sendKeysToFromAndToFields("SFO", "LAX");
        homePage.clickInputDate();
        //Date selection
        homePage.selectSpecificDates();

        homePage.selectDepartureTime("Evening");
        homePage.clickFindADealButton();

        Assert.assertTrue(homePage.isDisplayed()>0, "No results are displayed");
    }
}
