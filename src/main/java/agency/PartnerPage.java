package agency;

import model.PartnerData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import service.FileServiceImpl;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

public class PartnerPage {
    private WebDriver driver;
    private WebDriverWait  wait; // Pour implementer les attentes explicites
    //Locators
    private By becomePartner = By.cssSelector("header nav > a > button");
    private By nomPartner = By.name("operatorName");
    private By emailPartner = By.name("email");
    private By civilityPartner = By.name("civility");
    private By contactName = By.name("contactName");
    private By contactPhone = By.name("phone");
    private By submitButton = By.cssSelector("form > div > button");

    //Constructeur
    public PartnerPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    // =======================
    // Actions / Methods
    // =======================

    public void becomPartenerClick() {
        this.driver.findElement(becomePartner).click();
    }
//updatz
    public boolean isPresent(){
        return this.driver.findElement(civilityPartner).isDisplayed();
    }

    public PartnerPage setNomPartner(String nom) {
        WebElement field = wait.until(
                ExpectedConditions.visibilityOfElementLocated(nomPartner)
        );
        assert field != null;
        field.clear();
        field.sendKeys(nom);
        return this;
    }

    public PartnerPage setEmailPartner(String email) {
        WebElement field = wait.until(
                ExpectedConditions.visibilityOfElementLocated(emailPartner)
        );
        assert field != null;
        field.clear();
        field.sendKeys(email);
        return this;
    }

    public PartnerPage selectCivility(String civility) {
        WebElement civilitySelect = wait.until(
                ExpectedConditions.visibilityOfElementLocated(civilityPartner)
        );

        assert civilitySelect != null;
        Select select = new Select(civilitySelect);
        select.selectByVisibleText(civility);

        return this;
    }

    public PartnerPage setContactName(String name) {
        WebElement field = wait.until(
                ExpectedConditions.visibilityOfElementLocated(contactName)
        );
        assert field != null;
        field.clear();
        field.sendKeys(name);
        return this;
    }

    public PartnerPage setContactPhone(String phone) {
        WebElement field = wait.until(
                ExpectedConditions.visibilityOfElementLocated(contactPhone)
        );
        assert field != null;
        field.clear();
        field.sendKeys(phone);
        return this;
    }

    public void submitForm() {
        Objects.requireNonNull
                (wait.until(
                ExpectedConditions.elementToBeClickable(submitButton)
        )).click();
    }

    public List<PartnerData> readDataTest(){
        FileServiceImpl fileService = new FileServiceImpl();
        return fileService.readPartnerFromJson("src/test/resources/partner_data.json");
    }

    // =======================
    // Méthode utilitaire
    // =======================
    public void fillPartnerForm(
            String nom,
            String email,
            String civility,
            String contact,
            String phone
    ) {
        setNomPartner(nom)
                .setEmailPartner(email)
                .selectCivility(civility)
                .setContactName(contact)
                .setContactPhone(phone)
                .submitForm();
    }


}
