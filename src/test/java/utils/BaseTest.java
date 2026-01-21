package utils;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

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
                driver = new FirefoxDriver();
                break;

            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            default:
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
        }

        driver.manage().window().maximize();

    }

    @BeforeEach
    void openApplication() {
        String url = ConfigReader.get("app.url");
        System.out.println("URL chargée = " + url);
        driver.get(url);
    }

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
