package example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public WebDriver driver;
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }
    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div/form/div[1]/div/div")
    private WebElement loginField;
    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div/form/div[2]/div/div")
    private WebElement passwordField;
    @FindBy(xpath = "//button[contains(text(), 'Войти')]")
    private WebElement loginBtn;

    public void inputLogin(String login){
        loginField.sendKeys(login);
    }
    public void inputPassword(String password){
        passwordField.sendKeys(password);
    }
    public void clickLoginBtn(){
        loginBtn.click();
    }
}
