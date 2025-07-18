````java
package cl.kibernumacademy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

public class FormularioTest {

    WebDriver driver;

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/automation-practice-form");
    }

    @Test
    void completarFormulario() {
        // Eliminar publicidad que bloquea elementos
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('fixedban').style.display='none'");
        js.executeScript("document.querySelector('footer').style.display='none'");

        // Campos de texto
        driver.findElement(By.id("firstName")).sendKeys("Laura");
        driver.findElement(By.id("lastName")).sendKeys("Rodríguez");
        driver.findElement(By.id("userEmail")).sendKeys("laura@test.com");

        // Radio Button - Female
        driver.findElement(By.xpath("//label[text()='Female']")).click();

        // Número de teléfono
        driver.findElement(By.id("userNumber")).sendKeys("987654321");

        // Hobbies: Reading y Music
        driver.findElement(By.xpath("//label[text()='Reading']")).click();
        driver.findElement(By.xpath("//label[text()='Music']")).click();

        // Dirección
        driver.findElement(By.id("currentAddress")).sendKeys("Dirección falsa 123");

        // Estado y ciudad

        WebElement stateDropdown = driver.findElement(By.id("react-select-3-input"));
        stateDropdown.sendKeys("NCR");
        stateDropdown.sendKeys(Keys.ENTER);

        WebElement cityDropdown = driver.findElement(By.id("react-select-4-input"));
        cityDropdown.sendKeys("Delhi");
        cityDropdown.sendKeys(Keys.ENTER);

        // Validaciones
        assertEquals("Laura", driver.findElement(By.id("firstName")).getAttribute("value"));
        assertEquals("laura@test.com", driver.findElement(By.id("userEmail")).getAttribute("value"));
        assertEquals("987654321", driver.findElement(By.id("userNumber")).getAttribute("value"));
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}