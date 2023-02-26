import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

//1. Заполнить поле "First name" // Chandra firstName
//2. Заполнить поле "Last name" // Nalaar
//3. Заполнить поле "email" // kaladesh@testmail.test userEmail
//4. Выбрать пол // Female
//5. Ввести телефонный номер // 1234567890 userNumber
//6. Ввести дату рождения // 01 January,2000
//7. Заполнить текстовое поле Subject // Hindi
//8. Отметить все чекбоксы // Reading
//9. Выбрать изображение // 58287bd0f0c02.jpg
//10. Заполнить поле Current address // 10 Crestwood DrHudson currentAddress
//11. Выбрать State // NCR Delhi
//12. Выбрать City // NCR Delhi
//13. Нажать на кнопку Submit.
//14. Проверить данные.
// https://demoqa.com/automation-practice-form
public class HW3automation_practice_form {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest(){
        open("/automation-practice-form");

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
