package com.nttdata.stepsdefinitions;

import com.nttdata.steps.IniciarSesionStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static com.nttdata.core.DriverManager.getDriver;
import static com.nttdata.core.DriverManager.screenShot;

public class IniciarSesionStepDef {
    IniciarSesionStep iniciarSesion;
    private WebDriver driver;

    @When("hago click en el boton iniciar sesión")
    public void hagoClickEnElBotonIniciarSesión() {
        driver = getDriver();
        driver.get("https://qalab.bensg.com/store/pe/");
        iniciarSesion = new IniciarSesionStep(driver);
        iniciarSesion.clickBtnIniciarSesion();
        screenShot();
    }

    @Then("inicio sesión con email: {string} y contraseña: {string}")
    public void inicioSesiónConEmailEmailYContraseñaPass(String email, String pass) {
        driver = getDriver();
        screenShot();
        iniciarSesion = new IniciarSesionStep(driver);
        iniciarSesion.ingresaEmail(email);
        iniciarSesion.ingresaContraseña(pass);
    }

    @And("hago click en el boton Ingresar")
    public void hagoClickEnElBotonIngresar() {
        driver = getDriver();
        iniciarSesion = new IniciarSesionStep(driver);
        screenShot();
        iniciarSesion.clickBtnIngresa();
    }
}
