package ru.netology.test;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;



public class CardOrderTest {

    @BeforeEach
    void open() {
        Selenide.open("http://localhost:7777/");
    }

    @Test
    void completedForm() {
        $("[data-test-id=name] input").setValue("Мадс Миккельсен");
        $("[data-test-id=phone] input").setValue("+79810591703");
        $("[data-test-id=agreement]").click();
        $("button[type=button]").click();
        $("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }
}