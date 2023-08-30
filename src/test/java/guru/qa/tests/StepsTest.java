package guru.qa.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.steps.WebSteps;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StepsTest {
    private static final String REPOSITORY = "ValeriaReshetina/qa_guru_AllureReports";
    private static final String ISSUE = "Issue for Autotest";

    @Test
    @Feature("Issue в репозитории")
    @Story("Создание Issue")
    @Owner("reshetinaValery")
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Поиск Issue")
    public void testAnnotatedStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.clickOnRepositoryLink(REPOSITORY);
        steps.openIssuesTab();
        steps.shouldSeeIssueWithName(ISSUE);
    }
}
