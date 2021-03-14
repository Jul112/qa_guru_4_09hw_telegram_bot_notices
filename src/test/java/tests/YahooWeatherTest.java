package tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pagesForPageObjects.YahooWeatherPage;

public class YahooWeatherTest extends TestBase {
    YahooWeatherPage yahooWeatherPage = new YahooWeatherPage();

    @Test
    @DisplayName("Air temperature is less than zero")
    void yahooWeatherTemperatureLessZero() {
        yahooWeatherPage.openBaseUrl();
        yahooWeatherPage.openWeatherPage();
        yahooWeatherPage.selectLocation();
        yahooWeatherPage.setMetricDataUnit();
        yahooWeatherPage.assertThatTemperatureLessZero();
    }

    @Test
    @DisplayName("Air temperature is more than zero")
    void yahooWeatherTemperatureMoreZero() {
        yahooWeatherPage.openBaseUrl();
        yahooWeatherPage.openWeatherPage();
        yahooWeatherPage.selectLocation();
        yahooWeatherPage.setMetricDataUnit();
        yahooWeatherPage.assertThatTemperatureMoreZero();
    }

    @Test
    @DisplayName("Air temperature is zero")
    void yahooWeatherTemperatureEqualsZero() {
        yahooWeatherPage.openBaseUrl();
        yahooWeatherPage.openWeatherPage();
        yahooWeatherPage.selectLocation();
        yahooWeatherPage.setMetricDataUnit();
        yahooWeatherPage.assertThatTemperatureEqualsZero();
    }
}

