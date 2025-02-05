package com.nttdata.stepsdefinitions;
import com.nttdata.steps.IniciarSesionStep;
import com.nttdata.steps.PrecioProductoStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static com.nttdata.core.DriverManager.getDriver;
import static com.nttdata.core.DriverManager.screenShot;

public class PrecioProductoStepDef {
    private WebDriver driver;
    PrecioProductoStep precioproducto;

    @Given("estoy en la página de la tienda y hago click en el boton Iniciar Sesión")
    public void estoyEnLaPaginaDeLaTienda(){
        driver=getDriver();
        driver.get("https://qalab.bensg.com/store/pe/");
        precioproducto = new PrecioProductoStep(driver);
        precioproducto.clickBtnIniciarSesion();
        screenShot();
    }

    @And("me logueo con mi usuario {string} y clave {string}")
    public void meLogueoConMiUsuarioYClave(String email, String pass) {
        driver = getDriver();
        precioproducto.ingresaEmail(email);
        precioproducto.ingresaContraseña(pass);
        screenShot();
        precioproducto.clickBtnIngresa();

    }

    @When("navego a la categoria {string} y subcategoria {string}")
    public void navegoALaCategoriaYSubcategoria(String categoria, String subcategoria) throws InterruptedException {
        precioproducto = new PrecioProductoStep(driver);
        driver = getDriver();
        screenShot();
        precioproducto.verificarBtnCerrarSesion();

        precioproducto.verificarCategoria(categoria);
        precioproducto.clickBtnCategoria();

        driver = getDriver();
        screenShot();
        Thread.sleep(3000);
        precioproducto.verificarSubcategoria(subcategoria);
        precioproducto.clickBtnSubcategoria();
    }

    @And("agrego {int} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(int unidades) throws InterruptedException {
        driver = getDriver();
        precioproducto.clickThumbnail();
        Thread.sleep(3000);
        precioproducto.clickAgregar1Producto();
        Thread.sleep(500);
        screenShot();
        precioproducto.clickAgregarAlCarrito();
        Thread.sleep(3000);
    }

    @Then("valido en el popup la confirmación del producto agregado")
    public void validoEnElPopupLaConfirmaciónDelProductoAgregado() {
        driver = getDriver();
        precioproducto.confirmarPopUp();
    }

    @And("valido en el popup que el monto total sea calculado correctamente")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente() {
        driver = getDriver();
        precioproducto.confirmarMontoPopUp();
    }


    @When("finalizo la compra")
    public void finalizoLaCompra() throws InterruptedException {
        driver = getDriver();
        precioproducto.clickBtnFinalizarCompraPopUp();
        Thread.sleep(1000);
    }

    @Then("valido el titulo de la pagina del carrito")
    public void validoElTituloDeLaPaginaDelCarrito() {
        driver = getDriver();
        precioproducto.verificarTituloCarritoDeCompras();
    }

    @And("vuelvo a validar el calculo de precios en el carrito")
    public void vuelvoAValidarElCalculoDePreciosEnElCarrito() {
        driver = getDriver();
        precioproducto.verificarMontosCarritoDeCompras();
    }
}
