package description;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepDefinition.TestEnum;
import stepDefinition.TestText;
import stepDefinition.TestValidator;

import java.security.Key;
import java.util.HashMap;

public class HomePage {
    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }
/*-----------------------------------------------------
                     Фильтр поиска
------------------------------------------------------*/

    @TestText(anText = "Выбор действия")
    @FindBy(how = How.XPATH, using = "//button[@data-reactid='15']")
    private WebElement pageAction;

    @TestText(anText = "Вид действия")
    private String pageActionView = "//span[@data-reactid='14']//div";

    @TestText(anText = "Выбор недвижимости")
    @FindBy(how = How.XPATH, using = "//button[@data-reactid='18']")
    private WebElement pageReality;

    @TestText(anText = "Вид недвижимости")
    private String pageRealityView = "//div[@data-reactid='17']//div//li//span";

    @TestText(anText = "Выбор валюты")
    @FindBy(how = How.XPATH, using = "//div[@data-reactid='12']//button[text()='\u20BD']")
    private WebElement pageVal;

    @TestText(anText = "Рубли")
    private String pageValView = "//div[@data-reactid='12']//div";

    private void selectField(WebElement parentElement, String filialElement, String attributeText, WebDriver driver) {
        if (!attributeText.isEmpty()) {
            parentElement.click();
            WebElement element = driver.findElement(By.xpath(element(filialElement, attributeText)));
            element.click();
        }
    }

    private String element(String xpath, String text) {
        System.out.println(xpath.concat("[text()='").concat(text).concat("']"));
        return xpath.concat("[text()='").concat(text).concat("']");
    }

    /*---------------------------------------------------*/
    @TestText(anText = "Цена от")
    @FindBy(how = How.XPATH, using = "(//div[@data-reactid='12']//input[@placeholder='от'])[1]")
    private WebElement pagePriceFirst;

    @TestText(anText = "Цена до")
    @FindBy(how = How.XPATH, using = "(//div[@data-reactid='12']//input[@placeholder='до'])[1]")
    private WebElement pagePriceLast;

    @TestText(anText = "Город")
    @FindBy(how = How.XPATH, using = "//div[@data-reactid='12']/div[last()]//input")
    private WebElement pageCity;

    private void setInput(String text, WebElement element, WebDriver driver) {
        if (!text.isEmpty()) {
            element.clear();
            element.click();
            element.sendKeys(text);
            element.sendKeys(Keys.ENTER);
        }
    }

    /*---------------------------------------------------*/
    @TestText(anText = "Площадь в сот")
    @FindBy(how = How.XPATH, using = "//div[@data-reactid='12']//button[text()='сот.']")
    private WebElement pageAreaS;

    @TestText(anText = "Площадь в м²")
    @FindBy(how = How.XPATH, using = "//div[@data-reactid='12']//button[text()='м²']")
    private WebElement pageAreaM;

    private String ot_do_path = "/parent::div/preceding-sibling::div//input[@placeholder='";

    //@TestText(anText = "Площадь от и Площадь до")
    private WebElement setupAreaPrise(String area, String ot_do, WebDriver driver) {
        String parent = element("//div[@data-reactid='12']//button", area).concat(ot_do_path + ot_do + "']");
        return driver.findElement(By.xpath(parent));
    }

    private void setInputArea(String text, String area, String ot_do, WebDriver driver) {

        if (!text.isEmpty()) {
            WebElement pageArea;
            if (area.equals("сот.")) {
                pageArea = pageAreaS;
            } else {
                pageArea = pageAreaM;
            }
            pageArea.click();
            WebElement area_ot_do = setupAreaPrise(area, ot_do, driver);
            area_ot_do.click();
            area_ot_do.sendKeys(text);
            pageArea.click();
        }
    }

    /*---------------------------------------------------*/
    @TestText(anText = "1,2 комн.")
    @FindBy(how = How.XPATH, using = "//button[@data-reactid='22']")
    private WebElement pageRoom;

    @TestText(anText = "Найти")
    @FindBy(how = How.XPATH, using = "//button[@data-reactid='39']")
    private WebElement pageFindButton;

    public void findButton(WebDriver driver) {
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(pageFindButton));
        pageFindButton.isDisplayed();
        pageFindButton.click();
    }

    public void fillSearch(HashMap<String, String> value, WebDriver driver) {
        Boolean resultFile = new TestValidator(value).validator();
        if (resultFile) {
            selectField(pageAction, pageActionView, value.get(TestEnum.CommonEnum.ACTION.toString()), driver);
            selectField(pageReality, pageRealityView, value.get(TestEnum.CommonEnum.REALITY.toString()), driver);
            setInput(value.get(TestEnum.CommonEnum.PRISEFIRST.toString()), pagePriceFirst, driver);
            setInput(value.get(TestEnum.CommonEnum.PRISELAST.toString()), pagePriceLast, driver);
            //   setInput(value.get(TestEnum.CommonEnum.CITY.toString()), pageCity, driver);
            if (value.get(TestEnum.CommonEnum.SELECTROOM.toString()).equals("true")) {
                System.out.println("не дописано");
            }
            if (value.get(TestEnum.CommonEnum.SELECTBEDROOM.toString()).equals("true")) {
                System.out.println("не дописано");
            }
            if (value.get(TestEnum.CommonEnum.SELECTVALUTA.toString()).equals("true")) {
                selectField(pageVal, pageValView, value.get(TestEnum.CurrencyEnum.CURRENCY.toString()), driver);
            }
            if (value.get(TestEnum.CommonEnum.SELECTAREA.toString()).equals("true")) {

                setInputArea(value.get(TestEnum.AreaEnum.AREAFIRST.toString()), "сот.", "от", driver);
                setInputArea(value.get(TestEnum.AreaEnum.AREALAST.toString()), "сот.", "до", driver);
            }
        }

    }

}
