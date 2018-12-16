import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestSearchPage {

    WebDriver driver;

    JaSearchPage search;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/DRIVERS/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.justanswer.com/archives/elastic-search.aspx?");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testSearchWord() {
        search = new JaSearchPage(driver);
        String searchValue = "Dr. Mark advised to go to sleep right now";
        search.enterSearchValue(searchValue).clickSearchButton();
        Assert.assertEquals(search.searchResultSummary(), "You searched for \"" + searchValue + "\". 550 results found.");
    }


    @AfterMethod
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

}
