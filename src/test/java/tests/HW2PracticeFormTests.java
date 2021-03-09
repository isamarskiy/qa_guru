package tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.AutomationPracticeForm;

public class HW2PracticeFormTests extends TestBase {
    AutomationPracticeForm practiceForm = new AutomationPracticeForm();

    @Test
    @Owner("samarskiy")
    @Tag("positive")
    @DisplayName("Positive Automation practice form test")
    void formPositiveTest() {
        practiceForm.openPage();
        practiceForm.fullFillForm();
        practiceForm.clickSubmitButton();
        practiceForm.verifyData();
    }


    @Test
    @Disabled
    @Owner("samarskiy")
    @DisplayName("Negative automation practice form test")
    void formNegativeTest() {
        practiceForm.openPage();
        practiceForm.partFillForm();
        practiceForm.clickSubmitButton();
        practiceForm.verifyData();
    }
}
