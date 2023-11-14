package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import util.Helpers;

import java.util.List;

public class HomePage {

    Helpers helpers = new Helpers();

    //Locators
    @FindBy(xpath="//div[@data-bdd='farefinder-option-bundles']")
    private WebElement elementsMenuOption;
    @FindBy(xpath="//div[contains(@class, 'hw-btn-check-group')]/button")
    private List<WebElement> bundleOptionsButtons;
    @FindBy(xpath="//input[@data-bdd='farefinder-package-origin-location-input']")
    private WebElement fromInputField;
    @FindBy(xpath="//input[@data-bdd='farefinder-package-destination-location-input']")
    private WebElement toInputField;
    @FindBy(xpath="//div[@data-bdd='farefinder-package-startdate-input']")
    private WebElement inputDate;
    @FindBy(xpath="//div[@class='day-availability__content']")
    private WebElement calendar;
    @FindBy(xpath = "//select[@data-bdd='farefinder-package-pickuptime-input']")
    private WebElement departingDropDown;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement findADealButton;
    @FindBy(xpath = "//div[@data-stid='lodging-card-responsive']")
    private List<WebElement> results;
    @FindBy(xpath = "//select[@id='sort-filter-dropdown-sort']")
    private WebElement resultsSortingDropDown;

    //constructor
    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    //Actions
    public int isDisplayed(){
        helpers.waitForElement(resultsSortingDropDown,60);
        return results.size();
    }

    public void clickFindADealButton(){
        findADealButton.click();
    }

    public void selectDepartureTime(String departureTime){
        Select dropDown = new Select(departingDropDown);
        dropDown.selectByValue(departureTime);
    }

    public void selectSpecificDates(){
        for(int i =0; i<=1; i++){
            int numberOfFutureDays;
            if(i == 0){
            numberOfFutureDays = 1;
            }
            else{ numberOfFutureDays = 20;}
        String nextDay = helpers.getCurrentDayNumber(numberOfFutureDays);
        List<WebElement> nextDayOnCalendar = calendar.findElements(By.xpath("//div[text()='"+nextDay+"']"));
        nextDayOnCalendar.get(i).click();
        }
    }
    public void clickInputDate(){
        inputDate.click();
    }

    public void clickBundlesMenuOption(){
        elementsMenuOption.click();
    }

    public void clickEveryUnclickedBundleOptionIfNotClickedAlready(){
        bundleOptionsButtons.get(2).click();
    }

    public void sendKeysToFromAndToFields(String from, String to){
        fromInputField.sendKeys(from);
        toInputField.sendKeys(to);
    }
    //Sync

    public boolean isBundleOptionClicked(){
        return true;
    }
}
