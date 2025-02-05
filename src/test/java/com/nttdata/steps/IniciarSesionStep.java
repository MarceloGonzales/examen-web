package com.nttdata.steps;

import com.nttdata.page.IniciarSesionPage;
import org.openqa.selenium.WebDriver;

public class IniciarSesionStep {
    private WebDriver driver;

    public IniciarSesionStep(WebDriver driver){
        this.driver=driver;
    }

    public void clickBtnIniciarSesion(){
        this.driver.findElement(IniciarSesionPage.btn_inicio_sesion).click();
    }

    public void ingresaEmail(String email){
        this.driver.findElement(IniciarSesionPage.input_email).sendKeys(email);
    }

    public void ingresaContraseña(String pass){
        this.driver.findElement(IniciarSesionPage.input_pass).sendKeys(pass);
    }

    public void clickBtnIngresa(){
        this.driver.findElement(IniciarSesionPage.btn_ingresar).click();
    }
}
