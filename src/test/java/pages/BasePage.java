package pages;

import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class BasePage {

    // WebDriver usado por todas las páginas
    protected static WebDriver driver;
    private static WebDriverWait wait;
    private static Actions action;

    // Bloque estático: se ejecuta una sola vez al cargar la clase
    static {
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions); // Inicia Chrome
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Espera explícita
    }

    // Constructor: permite usar WebDriver externo si se quiere
    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Abre una URL en el navegador
    public static void navigateTo(String url) {
        driver.get(url);
    }

    // Hace clic en un enlace por texto visible
    public void goToLinkText(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
    }

    // Cierra el navegador y finaliza la sesión
    public static void closeBrowser() {
        driver.quit();
    }

    // Encuentra un elemento esperando a que sea visible
    private WebElement Find(String locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    // Métodos básicos de interacción con elementos
    public void clickElement(String locator) {
        Find(locator).click();
    }

    public void submitElement(String locator) {
        Find(locator).submit();
    }

    public void write(String locator, String textToWrite) {
        Find(locator).clear();
        Find(locator).sendKeys(textToWrite);
    }

    // Métodos para seleccionar opciones de un <select> (dropdown)
    public void selectFromDropdownByValue(String locator, String valueToSelect) {
        Select dropdown = new Select(Find(locator));
        dropdown.selectByValue(valueToSelect);
    }

    public void selectFromDropdownByIndex(String locator, int valueToSelect) {
        Select dropdown = new Select(Find(locator));
        dropdown.selectByIndex(valueToSelect);
    }

    public void selectFromDropdownByText(String locator, String valueToSelect) {
        Select dropdown = new Select(Find(locator));
        dropdown.selectByVisibleText(valueToSelect);
    }

    // Acciones del mouse
    public void hoverOverElement(String locator) {
        action.moveToElement(Find(locator));
    }

    public void doubleClick(String locator) {
        action.doubleClick(Find(locator));
    }

    public void rightClick(String locator) {
        action.contextClick(Find(locator));
    }

    // Interacciones con tablas
    public String getValueFromTable(String locator, int row, int column) {
        String cellINeed = locator + "/table/tbody/tr[" + row + "]/td[" + column + "]";
        return Find(cellINeed).getText();
    }

    public void setValueOnTable(String locator, int row, int column, String stringToSend) {
        String cellToFill = locator + "/table/tbody/tr[" + row + "]/td[" + column + "]";
        Find(cellToFill).sendKeys(stringToSend);
    }

    // Cambios de contexto (frames)
    public void switchToFrame(int frameIndex) {
        driver.switchTo().frame(frameIndex);
    }

    public void switchToParentFrame() {
        driver.switchTo().parentFrame();
    }

    // Manejo de alertas (ventanas emergentes)
    public void dismissAlert() {
        try {
            driver.switchTo().alert().dismiss();
        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }
    }

    // Métodos auxiliares para extraer información o validar estado de elementos
    public String textFromElement(String locator) {
        return Find(locator).getText();
    }

    public boolean elementEnabled(String locator) {
        return Find(locator).isEnabled();
    }

    public boolean elementIsDisplayed(String locator) {
        return Find(locator).isDisplayed();
    }

    public boolean elementIsSelected(String locator) {
        return Find(locator).isSelected();
    }

    // Devuelve una lista de elementos con cierta clase
    public List<WebElement> bringMeAllElements(String locator) {
        return driver.findElements(By.className(locator));
    }

    // Selecciona el N-ésimo elemento de una lista de resultados
    public void selectNthElement(String locator, int index) {
        List<WebElement> results = driver.findElements(By.xpath(locator));
        results.get(index).click();
    }
}
