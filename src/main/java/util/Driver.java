package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class Driver {

    public static Map<Long, WebDriver> webDriverMap = new HashMap<>();
    private final static String webDriverLocation = "src/main/resources/chromedriver/chromedriver.exe";

    public static void initWebDriver(){
        WebDriver webDriver;



        webDriver = getChromeDriver();
        webDriverMap.put(Thread.currentThread().getId(), webDriver);
        webDriver.manage().window().maximize();
    }

    public static WebDriver getWebDriver(){
        return webDriverMap.get(Thread.currentThread().getId());
    }

    public static void quit(){
        webDriverMap.get(Thread.currentThread().getId()).quit();
        webDriverMap.remove(Thread.currentThread().getId());
    }

    public static WebDriver getChromeDriver(){
        System.setProperty("webdriver.chrome.driver", webDriverLocation);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        return new ChromeDriver(options);
    }
}
