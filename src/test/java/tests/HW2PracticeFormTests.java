package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.AutomationPracticeForm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.HashMap;
import java.util.Map;


public class HW2PracticeFormTests {

    String firstName = "Test",
            lastName = "First",
            email = "test@test.ru",
            mobileNumber = "1234567890",
            currentAddress = "Moscow, Russia",
            gender = "Male",
            month = "April",
            year ="2001",
            day = "13",
            hobby = "Music",
            subject = "Maths",
            pathName = "test_image.png",
            state = "Haryana",
            city = "Panipat";

    public Map<String,String> mapTestData(){
        Map<String, String> testData = new HashMap<>();
        testData.put("Student Name", firstName + " " + lastName);
        testData.put("Student Email", email);
        testData.put("Gender", gender);
        testData.put("Mobile", mobileNumber);
        testData.put("Date of Birth", day + " " + month + "," + year);
        testData.put("Subjects", subject);
        testData.put("Hobbies", hobby);
        testData.put("Picture", pathName);
        testData.put("Address", currentAddress);
        testData.put("State and City", state + " " + city);
        return testData;
    }

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void formTest(){
        AutomationPracticeForm practiceForm = new AutomationPracticeForm();
        practiceForm
                .openPage("https://demoqa.com/automation-practice-form")
                .checkHeader("Practice Form")
                .setFirstNameElem(firstName)
                .setLastName(lastName)
                .setUserEmail(email)
                .setGender(gender)
                .setUserNumber(mobileNumber)
                .setDateOfBirth(year,month, day)
                .setSubject(subject)
                .setHobbies(hobby)
                .uploadPicture(pathName)
                .setCurrentAddress(currentAddress)
                .setStateAndCity(city, state)
                .clickSubmitButton();
        //comparing data
        Map <String, String> acTestData = practiceForm.getSubmittingFormData();
        Map <String, String> exTestData = mapTestData();
        assertEquals(exTestData, acTestData);
        }
}
