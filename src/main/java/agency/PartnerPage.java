package agency;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PartnerPage {
    protected WebDriver driver;
    //Locators
    private By becomePartner = By.cssSelector("header a > button");
    private By nomPartner = By.name("operatorName");
    private By emailPartner = By.name("email");
    private By civilityPartner = By.cssSelector("button[role='combobox'] ");
    private By contactName = By.name("contactName");
    private By contactPhone = By.name("phone");
    private By submitButton = By.cssSelector("button ");

    public PartnerPage(WebDriver driver) {
        this.driver = driver;
    }
}
