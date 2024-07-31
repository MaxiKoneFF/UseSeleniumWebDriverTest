package example;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ProfilePage {
        public WebDriver driver;
        public ProfilePage(WebDriver driver) {
            PageFactory.initElements(driver, this);
            this.driver = driver; }
        @FindBy(xpath = "//*[contains(@class, 'text text_type_main-default ml-2')]")
        private WebElement userMenu;
        @FindBy(xpath = "//*[contains(@class, 'text text_type_main-medium text_color_inactive pt-4 pb-4 profile-menu_button__10VBY')]")
        private WebElement logoutBtn;
        public String getUserName() {
            String userName = userMenu.getText();
            return userName; }
        public void entryMenu() {
            userMenu.click(); }
        public void userLogout() {
            logoutBtn.click();
        }
}