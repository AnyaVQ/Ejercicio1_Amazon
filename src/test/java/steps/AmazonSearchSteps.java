package steps;

import org.junit.Assert;
import io.cucumber.java.en.*;
import pages.AmazonSearchPage;

public class AmazonSearchSteps {

    // Instancia de la clase que modela la página de búsqueda de Amazon
    AmazonSearchPage amazon = new AmazonSearchPage();

    // Paso 1: El usuario navega al sitio web de Amazon
    @Given("^el usuario navega a www.amazon.com$")
    public void navegarAAmazon() {
        amazon.navigateToAmazon();  // Abre el navegador y va al sitio
    }

    // Paso 2: El usuario busca un producto específico
    @And("^busca (.*)$")
    public void ingresarCriterioBusqueda(String producto) {
        amazon.enterSearchCriteria(producto);  // Escribe el término en el buscador
        amazon.clickSearch();                  // Ejecuta la búsqueda
    }

    // Paso 3: El usuario navega a la segunda página de resultados
    @And("^navega a la segunda página$")
    public void navegarASegundaPagina() {
        amazon.goToPage2();  // Hace clic en la paginación para ir a la página 2
    }

    // Paso 4: El usuario selecciona el tercer artículo
    @And("^selecciona el tercer artículo$")
    public void seleccionarTercerArticulo() {
        amazon.pick3rdItem();  // Elige el tercer producto listado
    }

    // Paso 5: El usuario puede agregar el artículo al carrito
    @Then("^el usuario puede agregarlo al carrito$")
    public void agregarAlCarrito() {
        amazon.addToCart();  // Hace clic en "Agregar al carrito"
    }
}
