import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class CheckInputs {
    private WebDriver driver;
    @BeforeMethod
    public void OpenPage() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        RedminePage redminePage = new RedminePage(driver);
        redminePage.openUrl("https://www.redmine.org/account/register");
        Thread.sleep(2000);
    }
    @Test
    public void CheckInput() throws InterruptedException, IOException {
        RedminePage redminePage = new RedminePage(driver);
        //set username
        redminePage.type("Dianavoy",redminePage.UsernameInput);
        redminePage.type("1234",redminePage.PasswordInput);
        redminePage.type("1234",redminePage.PasswordAgainInput);
        redminePage.type("Diana",redminePage.NameInput);
        redminePage.type("Voy",redminePage.SurnameInput);
        redminePage.type("dddddddd",redminePage.EmailInput);
        redminePage.type("dddddddd",redminePage.NickInput);
        redminePage.type("dddddddd",redminePage.SearchInput);
        redminePage.click(redminePage.SubmitButton);
        Assert.assertTrue(redminePage.getInnerText(redminePage.ErrorMessage).contains("Email имеет неверное значение"));
        redminePage.doScreenshots();
    }
    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }
}
