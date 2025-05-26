package pages;
public class AmazonSearchPage extends BasePage {

    // Localizador del cuadro de búsqueda de Amazon
    private String searchBox = "//input[@id='twotabsearchtextbox']";

    // Localizador del botón de búsqueda
    private String searchButton = "//input[@id='nav-search-submit-button']";

    // Localizador del tercer resultado (actualmente frágil, se puede mejorar con un XPath más robusto)
    private String thirdResult = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/span[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/a[1]/h2[1]/span[1]";

    // Localizador del botón para agregar al carrito
    private String addToCartButton = "//input[@id='add-to-cart-button']";

    // Localizador del mensaje de confirmación de que el producto fue agregado al carrito
    private String addedMessageText = "//h4[@class='a-alert-heading']";

    /**
     * Constructor de la clase AmazonSearchPage.
     * Llama al constructor de la clase padre BasePage.
     */
    public AmazonSearchPage() {
        super(driver);
    }

    /**
     * Navega a la página principal de Amazon.
     */
    public void navigateToAmazon() {
        navigateTo("https://www.amazon.com/");
    }

    /**
     * Escribe el criterio de búsqueda en el cuadro de texto.
     * 
     * @param criteria Texto a buscar (producto, palabra clave, etc.)
     */
    public void enterSearchCriteria(String criteria) {
        write(searchBox, criteria);
    }

    /**
     * Hace clic en el botón de búsqueda.
     */
    public void clickSearch() {
        clickElement(searchButton);
    }

    /**
     * Navega a la segunda página de resultados.
     */
    public void goToPage2() {
        goToLinkText("2");
    }

    /**
     * Selecciona el tercer producto de la lista de resultados.
     * Nota: Este método puede requerir actualización si la estructura de la página cambia.
     */
    public void pick3rdItem(){
        clickElement(thirdResult);
    }

    /**
     * Hace clic en el botón "Agregar al carrito".
     */
    public void addToCart(){
        clickElement(addToCartButton);
    }

    /**
     * Retorna el texto del mensaje de confirmación tras agregar el producto al carrito.
     * 
     * @return Texto del mensaje de confirmación.
     */
    public String addToCartMessage(){
        return textFromElement(addedMessageText);
    }

}
