import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HW3automation_practice_form {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest(){
        open("/automation-practice-form");

        Selenide.executeJavaScript("$('#fixedban').remove()");
        Selenide.executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Chandra");
        $("#lastName").setValue("Nalaar");
        $("#userEmail").setValue("kaladesh@testmail.test");
        $("#gender-radio-2").sendKeys(" ");
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").$(byText("2000")).click();
        $(".react-datepicker__month-select").$(byText("January")).click();
        $(".react-datepicker__day.react-datepicker__day--001.react-datepicker__day--weekend").click();
        $("#subjectsInput").setValue("Hindi").pressEnter();
        $(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("no-homo-sapiens.png");
        $("#currentAddress").setValue("10 Crestwood DrHudson currentAddress");
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();
        $("#submit").click();

        $(".modal-body")
                .shouldHave(text("Chandra Nalaar"),
                            text("kaladesh@testmail.test"),
                            text("Female"),
                            text("1234567890"),
                            text("01 January,2000"),
                            text("Hindi"),
                            text("Reading"),
                            text("no-homo-sapiens.png"),
                            text("10 Crestwood DrHudson currentAddress"),
                            text("NCR Delhi"));
        sleep(5000);
    }
}
