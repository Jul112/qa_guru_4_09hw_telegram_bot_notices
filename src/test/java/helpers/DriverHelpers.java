package helpers;

import com.codeborne.selenide.Configuration;

public class DriverHelpers {
    public static void configureDriver() {
        Configuration.baseUrl = "https://www.yahoo.com";
    }
}
