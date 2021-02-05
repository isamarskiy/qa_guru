package pages;

import com.codeborne.selenide.SelenideElement;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeForm {

    final SelenideElement
            headerElem = $(".main-header"),
            firstNameElem = $("#firstName"),
            lastNameElem = $("#lastName"),
            userEmailElem = $("#userEmail"),
            userNumberElem = $("#userNumber"),
            uploadFileElem = $("#uploadPicture"),
            calendarInput = $("#dateOfBirthInput"),
            currentAddressElem = $("#currentAddress"),
            stateElem = $("#react-select-3-input"),
            cityElem = $("#react-select-4-input"),
            submitButtonElem = $("#submit");

    public AutomationPracticeForm openPage (String url){
        open(url);
        return this;
    }

    public AutomationPracticeForm checkHeader(String text){
        headerElem.shouldHave(text(text));
        return this;
    }

    public AutomationPracticeForm setFirstNameElem(String firstName){
        firstNameElem.setValue(firstName);
        return this;
    }

    public AutomationPracticeForm setLastName(String surname){
        lastNameElem.setValue(surname);
        return this;
    }

    public AutomationPracticeForm setUserEmail(String email){
        userEmailElem.setValue(email);
        return this;
    }

    public AutomationPracticeForm setGender(String gender){
        String locator = String.format("//label[text() = '%s']", gender);
        SelenideElement elem = $x(locator);
        elem.click();
        return this;
    }

    public AutomationPracticeForm setUserNumber(String number){
        userNumberElem.setValue(number);
        return this;
    }

    public AutomationPracticeForm setDateOfBirth(String year, String month, String day) {
        calendarInput.click();
        SelenideElement
                yearSelectElem = $x("//select[@class = 'react-datepicker__year-select']//option[text() = '" + year + "']"),
                monthSelectElem = $x("//select[@class = 'react-datepicker__month-select']//" +
                        "option[text() = '" + month + "']"),
                daySelectElem = $x("//div[@class = 'react-datepicker__month']//div[text() = '" + day + "']");
        yearSelectElem.click();
        monthSelectElem.click();
        daySelectElem.click();
        return this;
    }

    public AutomationPracticeForm setSubject(String subjectName){
        SelenideElement
                subjectContainerElem = $("#subjectsContainer"),
                subjectInputElem =  $("#subjectsInput");
        subjectContainerElem.click();
        subjectInputElem.setValue(subjectName).pressEnter();
        return this;
    }

    public AutomationPracticeForm setHobbies(String hobbyName){
        SelenideElement hobbiesSelectElem = $x("//label[text() = '"+hobbyName+"']");
        hobbiesSelectElem.click();
        return this;
    }

    public AutomationPracticeForm uploadPicture(String pathFile){
        uploadFileElem.uploadFile(new File(pathFile));
        return this;
    }

    public AutomationPracticeForm setCurrentAddress(String address){
        currentAddressElem.setValue(address);
        return this;
    }

    public AutomationPracticeForm setStateAndCity(String city, String state){
        stateElem.setValue(state).pressEnter();
        cityElem.setValue(city).pressEnter();
        return this;
    }

    public AutomationPracticeForm clickSubmitButton(){
        submitButtonElem.click();
        return this;
    }

    public Map<String, String> getSubmittingFormData(){
        ArrayList<String> rowArray = new ArrayList<>(executeJavaScript("return document.querySelectorAll(\"table > tbody > tr\")")); // бах
        int rowSize = rowArray.size();
        Map<String, String> submitData = new HashMap<>();
        String key = "", value = "";
        for(int i = 0; i <rowSize; i++){
            for(int j =0;j<2; j++){
                String js = String.format("return document.querySelectorAll(\"table > tbody > tr\")[%s].querySelectorAll(\"td\")[%s].textContent",i, j);
                if (j == 0)
                    key = executeJavaScript(js);
                else
                    value = executeJavaScript(js);
            }
            submitData.put(key,value);
        }

        return submitData;
        }
}