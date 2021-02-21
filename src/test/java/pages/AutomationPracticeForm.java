package pages;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeForm {

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
            image = "test_image.png",
            state = "Haryana",
            city = "Panipat";

    @Step("Open form page")
    public void openPage() {
        open("https://demoqa.com/automation-practice-form");
        $(".main-header").shouldHave(text("Practice Form"));
    }

    @Step("Full fill the form")
    public void fullFillForm() {
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $(byText(gender)).click();
        $("#userNumber").setValue(mobileNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__month").$(byText(day)).click();
        $("#subjectsInput").setValue(subject).pressEnter();
        $(byText(hobby)).click();
        $("#uploadPicture").uploadFromClasspath("img/" + image);
        $("#currentAddress").setValue(currentAddress);
        $("#react-select-3-input").setValue(state).pressEnter();
        $("#react-select-4-input").setValue(city).pressEnter();
    }

    @Step("Part fill the form")
    public void partFillForm() {
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
    }

    @Step("Click on submit button")
    public void clickSubmitButton() {
        $("#submit").click();
    }

    @Step("Check submitting form")
    public void verifyData() {
        $x("//td[text()='Student Name']").parent().shouldHave(text(firstName + " " + lastName));
        $x("//td[text()='Student Email']").parent().shouldHave(text(email));
        $x("//td[text()='Gender']").parent().shouldHave(text(gender));
        $x("//td[text()='Mobile']").parent().shouldHave(text(mobileNumber));
        $x("//td[text()='Date of Birth']").parent().shouldHave(text(day + " " + month + "," + year));
        $x("//td[text()='Subjects']").parent().shouldHave(text(subject));
        $x("//td[text()='Hobbies']").parent().shouldHave(text(hobby));
        $x("//td[text()='Picture']").parent().shouldHave(text(image));
        $x("//td[text()='Address']").parent().shouldHave(text(currentAddress));
        $x("//td[text()='State and City']").parent().shouldHave(text(state + " " + city));
    }
}
