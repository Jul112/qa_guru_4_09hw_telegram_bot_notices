package pagesForPageObjects;

import io.qameta.allure.Step;
/*import org.openqa.selenium.By;*/

import static com.codeborne.selenide.Condition.*;
/*import static com.codeborne.selenide.Selectors.byText;*/
import static com.codeborne.selenide.Selectors.byTitle;
import static com.codeborne.selenide.Selenide.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
/*import static org.junit.jupiter.api.Assertions.assertEquals;*/

public class YahooWeatherPage {
    String baseUrl = ("https://weather.com/");
    String city = "Athens";
    String dataUnit = "metric";

    @Step("Open page with yahoo.com")
    public void openBaseUrl(){
        open(baseUrl);
        $("#ybar-logo").shouldBe(visible);
        //($("#noVNC_mouse_capture_elem"))
    }

    @Step("Select Location")
    public void selectLocation() {
        //$("div[data-wf-toggle-target=\"#weather-location-picker-form\"] > button").click();
        $(byTitle("View your Locations")).click();
        $("[id=weather-autocomplete]").val(city);
        $$("li").findBy(text("Athens, Attica, Greece")).click();
        $(".weather-card h4").shouldHave(text("Athens"));
       /* $(byText("Change location")).click();
        $(".search-input").val(city).pressEnter();
        $$("ul button").findBy(attribute("data-country", country)).click();*/
    }

    @Step("Open page with weather")
    public void openWeatherPage() {
         $(".weather-card-content a").shouldHave(text("See More")).click();
         $(".location h1").shouldHave(text("Athens"));
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
