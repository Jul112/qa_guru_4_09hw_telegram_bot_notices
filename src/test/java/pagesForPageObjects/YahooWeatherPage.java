package pagesForPageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class YahooWeatherPage {
    String baseUrl = ("https://yahoo.com/");
    String country = "Greece";
    String city = "Athens";
    String dataUnit = "metric";

    @Step("Open page with yahoo.com")
    public void openBaseUrl(){
        open(baseUrl);
    }

    @Step("Open page with weather")
    public void openWeatherPage() {
        $(By.linkText("More...")).click();
        $(By.linkText("Weather")).click();
    }
    @Step("Select Location")
    public void selectLocation() {
        $(byText("Change location")).click();
        $(".search-input").val(city).pressEnter();
        $$("ul button").findBy(attribute("data-country", country)).click();
    }

    @Step("Set data-unit for temperature")
    public void setMetricDataUnit() {
        $(".unit-control button",1).shouldHave(attribute("data-unit", dataUnit)).click();
    }

    @Step("Check that the temperature less than zero")
    public void assertThatTemperatureLessZero() {
        int temperatureNow = Integer.parseInt($(".now span").getOwnText());
        assertThat(temperatureNow<0, is(true));
    }

    @Step("Check that the temperature more than zero")
    public void assertThatTemperatureMoreZero() {
        int temperatureNow = Integer.parseInt($(".now span").getOwnText());
        assertThat(temperatureNow>0, is(true));
    }

    @Step("Check that the temperature equals zero")
    public void assertThatTemperatureEqualsZero() {
        int temperatureNow = Integer.parseInt($(".now span").getOwnText());
         assertThat(temperatureNow==0, is(true));
    }
}
