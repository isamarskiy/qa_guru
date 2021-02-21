package tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.AutomationPracticeForm;

public class HW2PracticeFormTests extends TestBase{

    @Test
    @Owner("samarskiy")
    @DisplayName("Automation practice from test")
    void formTest(){
        AutomationPracticeForm practiceForm = new AutomationPracticeForm();
        practiceForm.openPage();
        practiceForm.fillForm();
        practiceForm.clickSubmitButton();
        practiceForm.verifyData();
        }
}