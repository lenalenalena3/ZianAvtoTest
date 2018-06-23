package stepDefinition;

import cucumber.api.java.ru.*;
import description.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InitialStep {
    static WebDriver driver;
    public static HomePage homePage;

    private static WebDriver getDriver() {
        String dr = "chrome";//ie, chrome
        String fileDriver = "";
        if (dr.equals("ie")) {
            fileDriver = "IEDriverServer.exe";
        } else if (dr.equals("chrome")) {
            fileDriver = "chromedriver.exe";
        }
        if (driver == null) {
            System.setProperty("webdriver." + dr + ".driver", "C:\\ADocMilena\\program\\selenium\\" + fileDriver);
            driver = new ChromeDriver();
            homePage = new HomePage(driver);
        }
        return driver;
    }

    @Дано("^открыт браузер и осуществлен переход на сайт$")
    public void openBrouser() {
        driver = getDriver();
        driver.get("https://www.cian.ru");
    }
}
