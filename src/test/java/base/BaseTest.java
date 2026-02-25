package base;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import io.qameta.allure.Attachment;


public class BaseTest {
    // ThreadLocal to ensure each test thread gets its own WebDriver instance
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @BeforeMethod
    @Parameters("browser")
    public void setUp(@Optional("chrome")String browser) {
        // Selenium 4.6+ automatically finds ChromeDriver from system PATH
        WebDriver  webDriver;
        switch (browser.toLowerCase())
        {
            case "firefox":
                webDriver = new FirefoxDriver();
                break;
            case "edge":
                webDriver = new EdgeDriver();
                break;
            case "chrome": default:
                webDriver = new ChromeDriver();
                break; }
        webDriver.manage().window().maximize();
        driver.set(webDriver);
    }

    protected WebDriver getDriver() {
        return driver.get();
    }

    @AfterMethod
    public void tearDown(){
        if (getDriver() != null) {
            getDriver().quit();
            driver.remove();
        }
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] saveScreenshot()
    { return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES); }


}
