package util;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;

public class Helpers {

    public String getCurrentDayNumber(int numberOfDaysInTheFuture){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, numberOfDaysInTheFuture);
        return new SimpleDateFormat("d").format(cal.getTime());
    }

    public void waitForElement(WebElement element, int seconds){
        WebDriverWait wait = new WebDriverWait(Driver.getWebDriver(), Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

}
