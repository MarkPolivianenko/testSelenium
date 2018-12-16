import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JaSearchPage {

    WebDriver driver;

    By searchField = By.cssSelector(".JA_text.search-keywords");
    By searchButton = By.cssSelector(".search-button");
    By searchResultSummary = By.cssSelector(".search-results-heading");

    public JaSearchPage(WebDriver driver) {
        this.driver = driver;
    }
    public JaSearchPage enterSearchValue(String searchText) {
        driver.findElement(searchField).sendKeys(searchText);
        return this;
    }

    public JaSearchPage clickSearchButton() {
        driver.findElement(searchButton).click();
        //driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        return this;
    }

    public String searchResultSummary() {
        String resultSummaryText = driver.findElement(searchResultSummary).getText();
        //System.out.print(resultSummaryText);
        return resultSummaryText;
    }


}
