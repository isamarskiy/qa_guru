package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.AutomationPracticeForm;

import static com.codeborne.selenide.Selenide.*;

public class HW2PracticeFormTests {

    String FirstName = "Test",
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

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void formTest(){
        AutomationPracticeForm practiceForm = new AutomationPracticeForm();
        open("https://demoqa.com/automation-practice-form");
        practiceForm
                .checkHeader("Practice Form")
                .setFirstName(FirstName)
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
        practiceForm
                .verifyData(FirstName, lastName, email, gender, mobileNumber, day, month, year, subject, hobby,pathName,
                        currentAddress, state, city);
        }
}