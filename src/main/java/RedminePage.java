import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RedminePage extends BasePage {

    public By ProjectPageLink = By.cssSelector("[href='/projects']");
    public By homePageLink = By.xpath("//div[@id='top-menu']//a[@href='/']");
    public By HelpPageLink = By.cssSelector("[href$='/guide']");
    public By SignInPageLink = By.cssSelector("[href='/login']");
    public By RegistrationPageLink = By.cssSelector("[href$='/register']");
    public By SearchPageLink = By.cssSelector("a[href='/search']");
    public By RedminePageLink = By.cssSelector("[href$='redmine.org/']");
    public By UsernameInput = By.cssSelector("[id='user_login']");
    public By PasswordInput = By.cssSelector("[id='user_password']");
    public By PasswordAgainInput = By.cssSelector("[id='user_password_confirmation']");
    public By NameInput = By.cssSelector("[id='user_firstname']");
    public By SurnameInput = By.cssSelector("[id='user_lastname']");
    public By EmailInput = By.cssSelector("[id='user_mail']");
    public By NickInput = By.cssSelector("[id='user_custom_field_values_3']");
    public By SearchInput = By.cssSelector("[id='q']");
    public By SubmitButton = By.cssSelector("[type='submit']");
    public By ErrorMessage = By.id("errorExplanation");

    public RedminePage(WebDriver driver) {
        super(driver);
    }


}
