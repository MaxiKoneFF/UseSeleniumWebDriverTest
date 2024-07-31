package example;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import resourses.ConfProperties;
import java.util.concurrent.TimeUnit;

public class LoginTest {
    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
        //создать экземпляр chrome
        WebDriver driver = new ChromeDriver();
        //определение пути до драйвера и его настройка
        System.setProperty("webdriver.chrome.driver", "C:/Users/konev/OneDrive/Рабочий стол/ForTest/chromedriver-win32/chromedriver.exe");
        //окно браузера разворачивается на полный экран
        driver.manage().window().fullscreen();
        //пауза на загрузку страницы -10 сек
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //получение ссылки на страницу из файла настроек
        driver.get(ConfProperties.getProperty("loginpage"));
    }
    @Test
    public void loginTest() {
        //получение доступа к методам класса LoginPage для взаимодействия с элементами страницы
        //значение login/password берутся из файла настроек по аналогии с chromedriver
        //и loginpage
        //вводим логин
        loginPage.inputLogin(ConfProperties.getProperty("konev.tonystark@gmail.com"));
        //нажимаем кнопку входа
        loginPage.clickLoginBtn();
        //вводим пароль
        loginPage.inputPassword(ConfProperties.getProperty("94949697"));
        //нажимаем кнопку входа
        loginPage.clickLoginBtn();
        //получаем отображаемый логин
        String user = profilePage.getUserName();
        //и сравниваем его с логином из файла настроек
        Assert.assertEquals(ConfProperties.getProperty("konev.tonystark@gmail.com"), user); }

    @AfterClass
    public static void tearDown() {
        profilePage.entryMenu();
        profilePage.userLogout();
        driver.quit();
    }
}