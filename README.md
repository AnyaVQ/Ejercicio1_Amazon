# Ejercicio1_Amazon

Este framework automatizado de pruebas de interfaz de usuario (UI) fue creado siguiendo la metodología BDD (Behavior Driven Development) y aplicando las mejores prácticas de testing.

Se utiliza el patrón de diseño **Page Object Model (POM)** para organizar el código y mantenerlo limpio y reutilizable.

Para verificar que la aplicación web funciona correctamente, se emplea **Selenium WebDriver** como herramienta principal de automatización.

---

## Flujo de pruebas automatizadas en la página de Amazon

Los casos de prueba desarrollados siguen estos pasos:

1. Navegar a la página principal de Amazon.  
2. Buscar un producto específico.  
3. Navegar a la página número 2 de los resultados de búsqueda.  
4. Seleccionar el tercer ítem listado en los resultados.  
5. Validar que el ítem seleccionado fue agregado correctamente al carrito.

---

## Estructura del proyecto

Para automatizar estos casos de prueba, se crearon las siguientes clases y archivos:

1. **build.gradle**: Define la configuración de compilación aplicada a todos los módulos del proyecto.  
2. **Runner.java**: Clase encargada de ejecutar los escenarios de Cucumber y configurar cómo se ejecutan las pruebas.  
3. **Archivo Feature**: Archivo en lenguaje Gherkin donde se declaran los escenarios y se parametrizan criterios como el producto a buscar, número de página y el ítem a seleccionar.  
4. **BasePage.java**: Clase base que crea una única instancia del WebDriver y contiene métodos genéricos para interactuar con elementos web. Las demás páginas heredan estas funcionalidades.  
5. **StepDefinitions.java**: Clase donde se implementan los métodos que corresponden a los pasos definidos en los escenarios Gherkin.  
6. **AmazonPage.java** (o páginas específicas): Clases que heredan de BasePage para interactuar con elementos particulares de cada página web.

---

## Tecnologías utilizadas

- Java
- Selenium WebDriver
- Cucumber

---

## Reportes de Cucumber

Los reportes HTML generados se encuentran en:  
[![Ver Reporte de Pruebas](https://img.shields.io/badge/Ver-Reporte-blue?style=for-the-badge)](https://reports.cucumber.io/report-collections/6faf0c7a-9081-47f3-b81d-4b1388ea4888)

---

Si quieres contribuir o tienes dudas, por favor abre un issue o contacta al autor.

