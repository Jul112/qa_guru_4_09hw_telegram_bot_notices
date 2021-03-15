package tests;

import com.codeborne.selenide.Configuration;
/*import org.junit.jupiter.api.AfterAll;*/
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
/*import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.remote.DesiredCapabilities;*/

import java.io.IOException;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static helpers.AttachmentsHelper.*;

public class TestBase {
    @BeforeAll
    static void startOptions() {
        Configuration.startMaximized = true;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        //capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
       Configuration.remote = "https://user1:1234@selenoid.autotests.cloud:4444/wd/hub/";
    }

    @AfterEach
    public void afterEach() {
        attachScreenshot("Last screenshot");
        //attachPageSource();
        //attachAsText("Browser console logs", getConsoleLogs());
        //attachVideo();
       // closeWebDriver();
    }
}
