import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleTest {

    @Test
    public void verifyJaSearchPage () {
        // System.out.println("Ya ne fignya");
        //WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver","C:/DRIVERS/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.justanswer.com/archives/elastic-search.aspx");
        driver.manage().window().maximize();


        WebElement searchField = driver.findElement(By.cssSelector(".JA_text.search-keywords"));
        searchField.sendKeys("Dr. Mark advised to go to sleep right now");

        WebElement searchButton = driver.findElement(By.cssSelector(".search-button"));
        searchButton.click();

        WebElement searchResultSummary = driver.findElement(By.cssSelector(".search-results-heading"));
        String resultSummaryText = searchResultSummary.getText();
        //System.out.println (resultSummaryText);
        Assert.assertEquals(resultSummaryText,"You searched for \"Dr. Mark advised to go to sleep right now\". 550 results found.");

        driver.quit();

    }
}
