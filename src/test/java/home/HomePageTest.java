package home;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class HomePageTest {

    @BeforeEach
    void setUp() {
        System.out.println("Debut du test de la home page");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Fin du test de la home page");
    }

    // Ma petite fonction qui regroupe le code redondant
    private void utils(WebDriver driver) {
        // Configuration du timeout pour 10 sec d'attente
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Agrandissement au max de l'ecran
        driver.manage().window().maximize();

        // Chargement de la page de matoa
        driver.get("https://matoa.io/");

    }

    @Test
    public void howItWorkLinkTest(){

        //Initialisation de mon objet Webdriver compatible firefox
        WebDriver driver = new EdgeDriver();

        utils(driver);

        // Instantiation de la HomePage
        HomePage homePage = new HomePage(driver);

        // Localiser et cliquer sur le lien "comment ca marche"
//        WebElement howItWorkLink = driver.findElement(
//                By.linkText("Comment ça fonctionne")
//        );
//        howItWorkLink.click();
//
//        // Recuperation de l'URL courante pour verification

        homePage.clickHowItWorkLink();
        String currentUrl = homePage.getCurrentUrl();

        // Test proprement dite avec Junit
        assertEquals("https://matoa.io/", currentUrl);
    }

    @Test
    public void appStoreButtonClickTest(){
        WebDriver driver = new EdgeDriver();
        utils(driver);
        HomePage homePage = new HomePage(driver);
//        WebElement appStoreButton = driver.findElement(
//                By.partialLinkText("App Store")
//        );
//
//        WebElement googlePlayButton = driver.findElement(
//                By.partialLinkText("Google Play")
//        );

//        assertTrue(appStoreButton.isDisplayed());
//        assertTrue(googlePlayButton.isDisplayed());
//
//        assertTrue(appStoreButton.isEnabled());
//        assertTrue(googlePlayButton.isEnabled());

        assertTrue(homePage.isAppStoreButton());
        assertTrue(homePage.isGooglePlayButton());
    }

    @Test
    public void isDownloadButtonTest(){
        WebDriver driver = new EdgeDriver();
        utils(driver);
        HomePage homePage = new HomePage(driver);

        assertTrue(homePage.isDownloadButton());
    }

    //Exervice pratiaue 1
    @Test
    public void aboutUsButtonClickTest(){
        WebDriver driver = new EdgeDriver();
        utils(driver);
        HomePage homePage = new HomePage(driver);
        homePage.clickAboutUsButton();

        // THEN : attendre le changement de page
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
//        wait.until(ExpectedConditions.urlContains("contact"));

        String currentUrl = homePage.getCurrentUrl();

        // Test de redirection vers la page de contact
        assertEquals("https://makiti-group.com/#contact", currentUrl);
    }
}