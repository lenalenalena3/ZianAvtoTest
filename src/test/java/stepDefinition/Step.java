package stepDefinition;

import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import java.util.HashMap;
import static stepDefinition.InitialStep.driver;
import static stepDefinition.InitialStep.homePage;

public class Step {
    @Тогда("^открывается страница поиска$")
    public void openPageSearch() {
        //  openPage(driver);
    }

    @Когда("^пользователь заполняет фильтр поиска из файла$")
    public void selectFiltr(){
        //открыть файл прочитать значения
        TestFile ddd = new TestFile();
        HashMap<String, String> ggg = ddd.fileReadXLSX();
        System.out.println(ggg.toString());
        homePage.fillSearch(ggg, driver);

    }

    @Когда("^пользователь нажимает кнопку Найти$")
    public void clickFind()  {
        homePage.findButton(driver);
    }
}
