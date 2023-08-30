package guru.qa.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;
import static org.openqa.selenium.By.linkText;

public class CleanSelenideTest extends TestBase {
    @Test
    @Feature("Issue в репозитории")
    @Story("Создание Issue")
    @Owner("reshetinaValery")
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Поиск Issue")
    public void testIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");

        $(".header-search-button").click();
        $x("//input[@id='query-builder-test']")
                .sendKeys("ValeriaReshetina/qa_guru_AllureReports");
        $x("//input[@id='query-builder-test']").submit();

        $(linkText("ValeriaReshetina/qa_guru_AllureReports")).click();
        $("#issues-tab").click();
        $(withText("Issue for Autotest")).should(Condition.exist);
    }
}
