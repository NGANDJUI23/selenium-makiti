package utils;

//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.*;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {
    protected WebDriver driver;


    @BeforeAll
    void setUp() {
        String browser = ConfigReader.get("app.browser");
        System.out.println("Navigateur utilisé : " + browser);

        switch (browser.toLowerCase()) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions optionFirefox = new FirefoxOptions();
                optionFirefox.addArguments("--headless");
                optionFirefox.addArguments("--no-sandbox");
                optionFirefox.addArguments("--disable-dev-shm-usage");
//                driver = new FirefoxDriver(optionFirefox);
                try {
                    driver = new RemoteWebDriver(new URL("http://localhost:4444"), optionFirefox);
//                    driver.manage().window().maximize();

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;

            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions optionChrome = new ChromeOptions();
//                optionChrome.addArguments("--headless");
//                optionChrome.addArguments("--no-sandbox");
//                optionChrome.addArguments("--disable-dev-shm-usage");
                driver = new ChromeDriver(optionChrome);
                try {
//                    driver = new RemoteWebDriver(new URL("http://localhost:4444"), optionChrome);
                    driver.manage().window().maximize();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                break;
            default:
                WebDriverManager.edgedriver().setup();
                EdgeOptions optionEdge = new EdgeOptions();
                optionEdge.addArguments("--headless");
                optionEdge.addArguments("--no-sandbox");
                optionEdge.addArguments("--disable-dev-shm-usage");
//                driver = new EdgeDriver(optionEdge);
                try {
                    driver = new RemoteWebDriver(new URL("http://localhost:4444"), optionEdge);
                    driver.manage().window().maximize();

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
        }

        driver.manage().window().maximize();

    }

//    @BeforeEach
//    void openApplication() {
//        String url = ConfigReader.get("agency.matoa.url");
//        System.out.println("URL chargée = " + url);
//        driver.get(url);
//    }

    @AfterAll
    void tearDown() {
        if (driver != null) driver.quit();
    }

    public static class ScreenshotOnFailureExtension implements TestWatcher {

        @Override
        public void testFailed(ExtensionContext context, Throwable cause) {

            Object testInstance = context.getRequiredTestInstance();
            if (!(testInstance instanceof BaseTest)) return;

            WebDriver driver = ((BaseTest) testInstance).driver;
            if (driver == null) return;

            File src = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);

            String testName = context.getDisplayName()
                    .replaceAll("[^a-zA-Z0-9]", "_");

            File dest = new File("screenshots/" + testName + ".png");
            dest.getParentFile().mkdirs();

            try {
                Files.copy(src.toPath(), dest.toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
