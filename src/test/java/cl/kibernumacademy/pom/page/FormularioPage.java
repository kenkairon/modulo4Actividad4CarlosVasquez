package cl.kibernumacademy.pom.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

// Clase que representa la página del formulario y encapsula todas sus interacciones
public class FormularioPage {

    private WebDriver driver; // Navegador controlado por Selenium

    // Constructor que recibe el WebDriver desde el test
    public FormularioPage(WebDriver driver) {
        this.driver = driver;
    }

    // Método para eliminar banners de publicidad que tapan el formulario
    public void eliminarPublicidad() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('fixedban').style.display='none'");
        js.executeScript("document.querySelector('footer').style.display='none'");
    }

    // Ingresa el nombre en el campo "First Name"
    public void setFirstName(String name) {
        driver.findElement(By.id("firstName")).sendKeys(name);
    }

    // Ingresa el apellido en el campo "Last Name"
    public void setLastName(String lastName) {
        driver.findElement(By.id("lastName")).sendKeys(lastName);
    }

    // Ingresa el email en el campo "Email"
    public void setEmail(String email) {
        driver.findElement(By.id("userEmail")).sendKeys(email);
    }

    // Selecciona el género haciendo clic sobre el texto del label
    public void selectGender(String gender) {
        driver.findElement(By.xpath("//label[text()='" + gender + "']")).click();
    }

    // Ingresa un número de teléfono válido
    public void setPhoneNumber(String number) {
        driver.findElement(By.id("userNumber")).sendKeys(number);
    }

    // Marca una opción de hobby (como Reading, Music, Sports)
    public void selectHobby(String hobby) {
        driver.findElement(By.xpath("//label[text()='" + hobby + "']")).click();
    }

    // Ingresa una dirección en el campo "Current Address"
    public void setAddress(String address) {
        driver.findElement(By.id("currentAddress")).sendKeys(address);
    }

    // Selecciona un estado escribiéndolo y presionando ENTER (autocompletado)
    public void selectState(String state) {
        WebElement stateDropdown = driver.findElement(By.id("react-select-3-input"));
        stateDropdown.sendKeys(state);
        stateDropdown.sendKeys(Keys.ENTER);
    }

    // Selecciona una ciudad escribiéndola y presionando ENTER (autocompletado)
    public void selectCity(String city) {
        WebElement cityDropdown = driver.findElement(By.id("react-select-4-input"));
        cityDropdown.sendKeys(city);
        cityDropdown.sendKeys(Keys.ENTER);
    }

    // Retorna el valor ingresado en el campo "First Name" (para validación)
    public String getFirstName() {
        return driver.findElement(By.id("firstName")).getAttribute("value");
    }

    // Retorna el valor ingresado en el campo "Email" (para validación)
    public String getEmail() {
        return driver.findElement(By.id("userEmail")).getAttribute("value");
    }

    // Retorna el valor ingresado en el campo "Phone Number" (para validación)
    public String getPhoneNumber() {
        return driver.findElement(By.id("userNumber")).getAttribute("value");
    }

    // Hace clic en el botón Submit para enviar el formulario
    public void clickSubmit() {
        WebElement submitButton = driver.findElement(By.id("submit"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitButton);
    }

    // Cierra el modal de confirmación
    // Espera a que el modal esté visible y luego lo cierra
    public void cerrarModal() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement closeButton = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("closeLargeModal")));
        closeButton.click();
    }

}
