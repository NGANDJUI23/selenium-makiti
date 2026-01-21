package agency;

import model.PartnerData;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import utils.BaseTest;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(BaseTest.ScreenshotOnFailureExtension.class)
class PartnerPageTest extends BaseTest {
    // Ma petite fonction qui regroupe le code redondant
//    private void utils(WebDriver driver) {
//        // Configuration du timeout pour 10 sec d'attente
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//
//        // Agrandissement au max de l'ecran
//        driver.manage().window().maximize();
//
//        // Chargement de la page de matoa
//        driver.get(ConfigReader.get("app.url"));
////        driver.get("https://agency.matoa.io/");
//
//    }
    @Test
    public void testFieldForm(){
        //Initialisation de mon objet Webdriver compatible firefox
//        WebDriver driver = new EdgeDriver();

//        utils(driver);

        PartnerPage partnerPage = new PartnerPage(driver);
        partnerPage.becomPartenerClick();
        partnerPage.fillPartnerForm(
                "Orange Cameroun",
                "contact@orange.cm",
                "Madame",
                "Jean Dupont",
                "690000000"
        );

    }

    @Test
    public void ispresent(){
        //Initialisation de mon objet Webdriver compatible firefox
//        WebDriver driver = new EdgeDriver();
//
//        utils(driver);

        PartnerPage partnerPage = new PartnerPage(driver);
        partnerPage.becomPartenerClick();
        assertTrue(partnerPage.isPresent());
    }
// Exercice pratique
    @Test
    public void submitDataTest(){
//        WebDriver driver = new EdgeDriver();
//        utils(driver);
        PartnerPage partnerPage = new PartnerPage(driver);
        partnerPage.becomPartenerClick();
        for(PartnerData data : partnerPage.readDataTest()){
            partnerPage.fillPartnerForm(data.getOperatorName(), data.getEmail(), data.getCivility(), data.getContactName(), data.getPhone());
        }
    }
}