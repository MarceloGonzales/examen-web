package com.nttdata.page;

import org.openqa.selenium.By;

public class IniciarSesionPage {
    public static By btn_inicio_sesion = By.cssSelector("#_desktop_user_info > div > a");
    public static By input_email = By.xpath("//*[@id=\"field-email\"]");
    public static By input_pass = By.xpath("//*[@id=\"field-password\"]");
    public static By btn_ingresar = By.xpath("//*[@id=\"submit-login\"]");
    public static By btn_cerrar_sesion = By.xpath("//*[@id=\"_desktop_user_info\"]/div/a[1]");
}
