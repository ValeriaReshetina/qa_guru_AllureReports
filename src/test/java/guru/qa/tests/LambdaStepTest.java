package guru.qa.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class LambdaStepTest {

    private static final String REPOSITORY = "ValeriaReshetina/qa_guru_AllureReports";
    private static final String ISSUE = "Issue for Autotest";

    @Test
    @Feature("Issue в репозитории")
    @Story("Создание Issue")
    @Owner("reshetinaValery")
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Поиск Issue")
    public void searchIssueWithLambdaTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });
        step("Ищем репозиторий " + REPOSITORY, () -> {
            $(".header-search-button").click();
            $x("//input[@id='query-builder-test']").sendKeys(REPOSITORY);
            $x("//input[@id='query-builder-test']").submit();
        });
        step("Кликаем по ссылке репозитория " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });
        step("Открываем таб Issues", () -> {
            $("#issues-tab").click();
        });
        step("Проверяем наличие Issue с номером " + ISSUE, () -> {
            $(withText(ISSUE)).should(Condition.exist);
        });
    }
}