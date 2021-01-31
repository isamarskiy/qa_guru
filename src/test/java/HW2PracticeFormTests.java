import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class HW2PracticeFormTests {


    String first_name = "Test", last_name = "First", email = "test@test.ru", mobile_number = "1234567890",
            current_address = "Moscow, Russia", gender = "Male", month = "April", year ="2001", day = "13",
            hobby = "Music", submit_text = "Thanks for submitting the form";
    String gender_element = "//label[text() = '"+gender+"']";
    String month_select = "//select[@class = 'react-datepicker__month-select']//" +
            "option[text() = '"+ month +"']";
    String year_select = "//select[@class = 'react-datepicker__year-select']//option[text() = '"+year+"']";
    String day_select = "//div[@class = 'react-datepicker__month']//div[text() = '"+day+"']";
    String hobbies_select = "//label[text() = '"+hobby+"']";

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;

    }


    @Test
    void formTest(){
        open("https://demoqa.com/automation-practice-form");


        $(".main-header").shouldHave(text("Practice Form"));

        $("#firstName").setValue(first_name);
        $("#lastName").setValue(last_name);
        $("#userEmail").setValue(email);
        $x(gender_element).click();
        $("#userNumber").setValue(mobile_number);

        $("#dateOfBirthInput").click();
        $x(month_select).click();
        $x(year_select).click();
        $x(day_select).click();

        $("#subjectsContainer").click();
        $("#subjectsInput").setValue("eco").pressEnter();

        $x(hobbies_select).click();

        $("#uploadPicture").uploadFile(new File("test_image.png"));

        $("#currentAddress").setValue(current_address);

        $("#react-select-3-input").setValue("Haryana").pressEnter();
        $("#react-select-4-input").setValue("Panipat").pressEnter();

        $("#submit").click();

        $(".modal-header").shouldHave(text(submit_text));

    }
}