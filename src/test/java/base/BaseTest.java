package base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.HomePage;

public class BaseTest {
    protected WebDriver driver;
    protected HomePage homePage;
    @BeforeClass
    public void setUp(){
        // Selenium 4.6+ automatically finds ChromeDriver from system PATH
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        System.out.println(driver.getTitle());

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
