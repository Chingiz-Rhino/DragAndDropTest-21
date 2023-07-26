package guru.qa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.DragAndDropOptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DragAndDrop {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
    }

    @Test
    void dragAndDropTest() {
        //Открыть страницу DragAndDrop
        open("/drag_and_drop");

        // Проверить присутствие элемента А
        $("#column-a").shouldHave(text("A"));

        //Проверить присутствие элемента В
        $("#column-b").shouldHave(text("B"));

        //Переместить элемент А на место элемента В
        $("#column-a").dragAndDropTo($("#column-b"));

        //Проверить, что элемент В встал на место элемента А
        $("#column-a").shouldHave(text("B"));

        //Проверить, что элемент A встал на место элемента B
        $("#column-b").shouldHave(text("A"));

    }

}
