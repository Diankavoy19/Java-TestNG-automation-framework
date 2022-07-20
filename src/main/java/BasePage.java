import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;


public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Open page with url
     **/
    protected void openUrl(String url) {
        driver.get(url);
    }

    /**
     * Navigate back
     **/
    public void comeBack() throws InterruptedException {
        driver.navigate().back();
        Thread.sleep(1000);
    }

    /**
     * Get element using locator
     **/
    protected WebElement find(By locator) {
        return driver.findElement(locator);
    }

    /**
     * Find all elements by locator
     **/
    protected List<WebElement> findAll(By locator) {
        return driver.findElements(locator);
    }

    /**
     * Click on element with given locator when its visible
     **/
    protected void click(By locator) throws InterruptedException {
        waitForVisibilityOf(locator, 5);
        find(locator).click();
        Thread.sleep(1000);
    }

    /**
     * Type given text into element with given locator
     **/
    protected void type(String text, By locator) throws InterruptedException {
        waitForVisibilityOf(locator, 5);
        find(locator).sendKeys(text);
        Thread.sleep(1000);
    }

    public void moveTo(By locator) throws InterruptedException {
        waitForVisibilityOf(locator, 5);
        WebElement element = find(locator);
        // Actions class with moveToElement()
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(true);",element);
        Thread.sleep(1000);
    }
    public void doScreenshots() throws IOException {
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("./image.png"));
    }

    /**
     * Get URL of current page from browser
     **/
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    /**
     * Get inner text element
     **/
    public String getInnerText(By locator) {
        return driver.findElement(locator).getAttribute("innerText");
    }

    /**
     * Get source of current page
     **/
    public String getCurrentPageSource() {
        return driver.getPageSource();
    }

    /**
     * Wait for specific ExpectedCondition for the given amount of time in seconds
     **/
    private void waitFor(ExpectedCondition<WebElement> condition, Integer timeOutInSeconds) {
        timeOutInSeconds = timeOutInSeconds != null ? timeOutInSeconds : 30;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
        wait.until(condition);
    }

    /**
     * Wait for given number of seconds for element with given locator to be visible
     * on the page
     */
    protected void waitForVisibilityOf(By locator, Integer... timeOutInSeconds) {
        int attempts = 0;
        while (attempts < 2) {
            try {
                waitFor(ExpectedConditions.visibilityOfElementLocated(locator),
                        (timeOutInSeconds.length > 0 ? timeOutInSeconds[0] : null));
                break;
            } catch (StaleElementReferenceException e) {
            }
            attempts++;
        }
    }

}