package pages;

import static com.codeborne.selenide.Selectors.byText;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeForm {

    public AutomationPracticeForm checkHeader(String text){
        $(".main-header").shouldHave(text(text));
        return this;
    }

    public AutomationPracticeForm setFirstName(String firstName){
        $("#firstName").setValue(firstName);
        return this;
    }

    public AutomationPracticeForm setLastName(String surname){
        $("#lastName").setValue(surname);
        return this;
    }

    public AutomationPracticeForm setUserEmail(String email){
        $("#userEmail").setValue(email);
        return this;
    }

    public AutomationPracticeForm setGender(String gender){
        $(byText(gender)).click();
        return this;
    }

    public AutomationPracticeForm setUserNumber(String number){
        $("#userNumber").setValue(number);
        return this;
    }

    public AutomationPracticeForm setDateOfBirth(String year, String month, String day) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__month").$(byText(day)).click();
        return this;
    }

    public AutomationPracticeForm setSubject(String subjectName){
        $("#subjectsInput").setValue(subjectName).pressEnter();
        return this;
    }

    public AutomationPracticeForm setHobbies(String hobbyName){
        $(byText(hobbyName)).click();
        return this;
    }

    public AutomationPracticeForm uploadPicture(String pathFile){
        $("#uploadPicture").uploadFile(new File(pathFile));
        return this;
    }

    public AutomationPracticeForm setCurrentAddress(String address){
        $("#currentAddress").setValue(address);
        return this;
    }

    public AutomationPracticeForm setStateAndCity(String city, String state){
        $("#react-select-3-input").setValue(state).pressEnter();
        $("#react-select-4-input").setValue(city).pressEnter();
        return this;
    }

    public void clickSubmitButton(){
        $("#submit").click();
    }

    public void verifyData(String firstName, String lastName, String email, String gender, String mobileNumber,
                           String day, String month, String year, String subject, String hobby, String pathName,
                           String currentAddress, String state, String city){
        $x("//td[text()='Student Name']").parent().shouldHave(text(firstName + " " + lastName));
        $x("//td[text()='Student Email']").parent().shouldHave(text(email));
        $x("//td[text()='Gender']").parent().shouldHave(text(gender));
        $x("//td[text()='Mobile']").parent().shouldHave(text(mobileNumber));
        $x("//td[text()='Date of Birth']").parent().shouldHave(text(day + " " + month + "," + year));
        $x("//td[text()='Subjects']").parent().shouldHave(text(subject));
        $x("//td[text()='Hobbies']").parent().shouldHave(text(hobby));
        $x("//td[text()='Picture']").parent().shouldHave(text(pathName));
        $x("//td[text()='Address']").parent().shouldHave(text(currentAddress));
        $x("//td[text()='State and City']").parent().shouldHave(text(state + " " + city));
    }
}
