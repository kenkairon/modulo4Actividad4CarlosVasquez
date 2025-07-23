package cl.kibernumacademy.pom.test;

import cl.kibernumacademy.pom.page.FormularioPage; // Importa la clase Page Object
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;// Importa funciones de validación

// Clase que contiene el test automatizado del formulario
public class FormularioTest {

    WebDriver driver; // Navegador
    FormularioPage formularioPage; // Objeto Page que encapsula el formulari

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup(); // Configura automáticamente el WebDriver de Chrome
        driver = new ChromeDriver(); // Abre una nueva ventana de Chrome
        driver.manage().window().maximize(); // Maximiza la ventana
        driver.get("https://demoqa.com/automation-practice-form");// Abre la URL del formulario
        formularioPage = new FormularioPage(driver); // Instancia el Page Object
    }

    // Test que llena el formulario y valida los datos
    @Test
    void completarFormulario() {
        formularioPage.eliminarPublicidad(); // Elimina la publicidad que interfiere
        formularioPage.setFirstName("Laura"); // Ingresa nombre
        formularioPage.setLastName("Rodríguez"); // Ingresa apellido
        formularioPage.setEmail("laura@test.com"); // Ingresa email
        formularioPage.selectGender("Female"); // Selecciona género
        formularioPage.setPhoneNumber("9987654321"); // Ingresa teléfono
        formularioPage.selectHobby("Reading"); // Marca hobby Reading
        formularioPage.selectHobby("Music"); // Marca hobby Music
        formularioPage.setAddress("Dirección falsa 123"); // Ingresa dirección
        formularioPage.selectState("NCR"); // Selecciona Estado
        formularioPage.selectCity("Delhi"); // Selecciona Ciudad

        formularioPage.clickSubmit();
        // Validaciones de que los datos ingresados están correctos
        assertEquals("Laura", formularioPage.getFirstName());
        assertEquals("laura@test.com", formularioPage.getEmail());
        assertEquals("9987654321", formularioPage.getPhoneNumber());

        // Espera a que el modal esté visible y luego lo cierra
        WebElement modalTitle = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("example-modal-sizes-title-lg")));

        assertTrue(modalTitle.isDisplayed());
        assertEquals("Thanks for submitting the form", modalTitle.getText());

        // Cierra el modal
        formularioPage.cerrarModal();
    }

    // Validaciones de que los datos ingresados están correctos
    @AfterEach
    void tearDown() {
        if (driver != null) {
            // driver.quit(); // Cierra el navegador
        }
    }
}
