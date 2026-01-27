package e2e;

//import io.qameta.allure.Epic;
//import io.qameta.allure.Feature;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import db.DatabaseUtils; // ton utilitaire SQL

import java.util.List;

//@Epic("Test end to End")
//@Feature("create user")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserE2ETest {

    private WebDriver driver;
    private final String email = "ngandjui.ivan@institutsaintjean.org";
    private final String username = "admin";
    private final String password = "admin";

    @BeforeAll
    void setup() {
        driver = new ChromeDriver();
    }

    @AfterAll
    void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @BeforeEach
    void insertUser() throws Exception {
        DatabaseUtils.insertUser(username, email, password);
    }

    @AfterEach
    void cleanup() throws Exception {
        DatabaseUtils.deleteUser(email);
    }

    @Test
    void shouldDisplayUserInUI() throws Exception {
        // Ouvrir la page locale
        driver.get("file://" + "C:\\Users\\INVITE\\Desktop\\ui" + "/index.html");

        // Attente simple pour que JS ait fini le fetch
        Thread.sleep(1000);

        // Récupérer tous les <li> de la liste
        List<WebElement> users = driver.findElements(By.cssSelector("#users-list li"));

        boolean found = users.stream()
                .anyMatch(li -> li.getText().contains(email));

        Assertions.assertTrue(found, "L'utilisateur inséré n'est pas affiché dans l'UI !");
    }
}
