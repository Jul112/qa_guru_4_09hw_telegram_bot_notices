package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import pagesForPageObjects.YahooWeatherPage;

import static helpers.DriverHelpers.configureDriver;

public class TestBase {
    @BeforeAll
    static void startOptions() {
        Configuration.startMaximized = true;
        /*DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud";*/
    }
    
}
