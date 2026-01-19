package home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class HomePage {
    protected WebDriver driver;

    // Locators de la page Home
    private By appStoreButton = By.partialLinkText("App Store");
    private By googlePlayButton = By.partialLinkText("Google Play");
    private By howItWorkLink = By.cssSelector("a[href='#how-it-works']");
    private By aboutUsButton = By.cssSelector("a[href='https://makiti-group.com/#contact']");
    private By downloadButton = By.cssSelector("header a > button");

    // Constructeur de la HomePage
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // ACTION (J2)
    public void clickHowItWorkLink() {
        this.driver.findElement(howItWorkLink).click();
    }

    // VERIFICATIONS (J3)
    public boolean isGooglePlayButton() {
        return this.driver.findElement(googlePlayButton).isDisplayed() && this.driver.findElement(googlePlayButton).isEnabled();
    }

    public boolean isAppStoreButton() {
        return this.driver.findElement(appStoreButton).isDisplayed() && this.driver.findElement(appStoreButton).isEnabled();
    }

    // Exercices pratique 1
    public void clickAboutUsButton() {
        this.driver.findElement(aboutUsButton).click();
    }
    // Fin

    // Exercice 2
    public boolean isDownloadButton() {
        return this.driver.findElement(downloadButton).isDisplayed() && this.driver.findElement(downloadButton).isEnabled();
    }
    //

    public String getCurrentUrl(){
        return this.driver.getCurrentUrl();
    }
}
