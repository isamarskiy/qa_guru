package tests;

import com.github.javafaker.Faker;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.AutomationPracticeForm;

import static com.codeborne.selenide.Selenide.*;

public class HW2PracticeFormTests {

    Faker faker = new Faker();

    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            mobileNumber = faker.phoneNumber().subscriberNumber(10),
            currentAddress = faker.address().fullAddress(),
            year = Integer.toString(faker.number().numberBetween(1980, 2021)),
            day = Integer.toString(faker.number().numberBetween(7,26)),
            gender = "Male",
            month = "April",
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
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(email)
                .setGender(gender)
                .setUserNumber(mobileNumber)
                .setDateOfBirth(year, month, day)
                .setSubject(subject)
                .setHobbies(hobby)
                .uploadPicture(pathName)
                .setCurrentAddress(currentAddress)
                .setStateAndCity(city, state)
                .clickSubmitButton();
        //comparing data
        practiceForm
                .verifyData(firstName, lastName, email, gender, mobileNumber, day, month, year, subject, hobby,pathName,
                        currentAddress, state, city);
        }
}