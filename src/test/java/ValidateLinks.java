import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ValidateLinks {
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
    public void ValidateLinks() throws InterruptedException {
        RedminePage redminePage = new RedminePage(driver);
        //click Main Link
        redminePage.click(redminePage.homePageLink);
        Assert.assertEquals(redminePage.getCurrentUrl(), "https://www.redmine.org/");
        Assert.assertTrue(redminePage.getCurrentPageSource().contains("Redmine is a flexible project management web application"), "Text not found in page");
        redminePage.comeBack();
        System.out.print("Text on the main page is displayed" + "\n");
        //click Project Link
        redminePage.click(redminePage.ProjectPageLink);
        Assert.assertEquals(redminePage.getCurrentUrl(), "https://www.redmine.org/projects");
        Assert.assertTrue(redminePage.getCurrentPageSource().contains("Redmine is a flexible project management web application written using Ruby on Rails framework."), "Text not found in page");
        redminePage.comeBack();
        System.out.print("Text on the project page is displayed" + "\n");
        //click Help Link
        redminePage.click(redminePage.HelpPageLink);
        Assert.assertEquals(redminePage.getCurrentUrl(), "https://www.redmine.org/guide");
        Assert.assertTrue(redminePage.getCurrentPageSource().contains("All following configuration settings can only be accessed and controlled by administrators"), "Text not found in page");
        redminePage.comeBack();
        System.out.print("Text on the help page is displayed" + "\n");
        //click SignIn Link
        redminePage.click(redminePage.SignInPageLink);
        Assert.assertEquals(redminePage.getCurrentUrl(), "https://www.redmine.org/login");
        Assert.assertTrue(redminePage.getCurrentPageSource().contains("Восстановление пароля"), "Text not found in page");
        redminePage.comeBack();
        System.out.print("Text on the login page is displayed" + "\n");
        //click Registration Link
        redminePage.click(redminePage.RegistrationPageLink);
        Assert.assertEquals(redminePage.getCurrentUrl(), "https://www.redmine.org/account/register");
        Assert.assertTrue(redminePage.getCurrentPageSource().contains("Регистрация"), "Text not found in page");
        System.out.print("Text on the registration page is displayed" + "\n");
        //click Search Link
        redminePage.click(redminePage.SearchPageLink);
        Assert.assertEquals(redminePage.getCurrentUrl(), "https://www.redmine.org/search");
        Assert.assertTrue(redminePage.getCurrentPageSource().contains("Искать только в названиях"), "Text not found in page");
        redminePage.comeBack();
        System.out.print("Text on the search page is displayed" + "\n");
        //click Redmine Link
        redminePage.moveTo(redminePage.RedminePageLink);
        redminePage.click(redminePage.RedminePageLink);
        Assert.assertEquals(redminePage.getCurrentUrl(), "https://www.redmine.org/");
        Assert.assertTrue(redminePage.getCurrentPageSource().contains("Redmine is open source and released under the terms of the"), "Text not found in page");
        redminePage.comeBack();
        System.out.print("Text on the redmine page is displayed" + "\n");
    }
    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }
}
