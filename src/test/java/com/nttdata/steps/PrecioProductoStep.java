package com.nttdata.steps;

import com.nttdata.page.PrecioProductoPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class PrecioProductoStep {
    private WebDriver driver;

    public PrecioProductoStep(WebDriver driver){
        this.driver=driver;
    }

    public void clickBtnIniciarSesion(){
        this.driver.findElement(PrecioProductoPage.btn_inicio_sesion).click();
    }

    public void ingresaEmail(String email){
        this.driver.findElement(PrecioProductoPage.input_email).sendKeys(email);
    }

    public void ingresaContraseña(String pass){
        this.driver.findElement(PrecioProductoPage.input_pass).sendKeys(pass);
    }

    public void clickBtnIngresa(){
        this.driver.findElement(PrecioProductoPage.btn_ingresar).click();
    }

    public void verificarBtnCerrarSesion(){
        String cerrar_sesion_pag = this.driver.findElement(PrecioProductoPage.btn_cerrar_sesion).getText().substring(2);
        System.out.println(cerrar_sesion_pag);
        String cerrar_sesion_esperado = "Cerrar sesión";
        Assert.assertEquals("Etiqueta de Cerrar Sesión Esperada:",cerrar_sesion_esperado,cerrar_sesion_pag);
    }

    public void verificarCategoria(String categoria){
        String categoria_pag = this.driver.findElement(PrecioProductoPage.btn_categoria).getText();
        System.out.println(categoria);
        System.out.println(categoria_pag);
        Assert.assertEquals("Nombre de la Categoría",categoria,categoria_pag);
    }

    public void clickBtnCategoria() {
        this.driver.findElement(PrecioProductoPage.btn_categoria).click();
    }

    public void verificarSubcategoria(String subcategoria){
        String subcategoria_pag = this.driver.findElement(PrecioProductoPage.btn_subcategoria).getText();
        System.out.println(subcategoria);
        System.out.println(subcategoria_pag);
        Assert.assertEquals("Nombre de la Subcategoría",subcategoria,subcategoria_pag);
    }

    public void clickBtnSubcategoria() {
        this.driver.findElement(PrecioProductoPage.btn_subcategoria).click();
    }

    public void clickThumbnail(){
        this.driver.findElement(PrecioProductoPage.producto_thumbnail).click();
    }

    public void clickAgregar1Producto(){
        this.driver.findElement(PrecioProductoPage.touch_spin_agregar).click();
    }

    public void clickAgregarAlCarrito(){
        this.driver.findElement(PrecioProductoPage.btn_agregar_carrito).click();
    }

    public void confirmarPopUp(){
        String titulo_popup_con_imagen_de_check = this.driver.findElement(PrecioProductoPage.confirmacion_popup).getText();
        String titulo_popup = titulo_popup_con_imagen_de_check.substring(1);
        String etiqueta_esperada = "Producto añadido correctamente a su carrito de compra";
        Assert.assertEquals("Etiqueta de Confirmación de Agregar Productos Al Carrito",etiqueta_esperada,titulo_popup);
    }

    public void confirmarMontoPopUp(){
        float precio_unitario = Float.parseFloat(this.driver.findElement(PrecioProductoPage.precio_unitario).getText().substring(3));
        float cantidad_producto = Float.parseFloat(this.driver.findElement(PrecioProductoPage.cantidad_producto).getText());
        float total_monto = Float.parseFloat(this.driver.findElement(PrecioProductoPage.total_monto).getText().substring(3));

        Assert.assertEquals("Monto Esperado Pop Up:",String.valueOf(total_monto),String.valueOf(precio_unitario*cantidad_producto));
    }

    public void clickBtnFinalizarCompraPopUp(){
        this.driver.findElement(PrecioProductoPage.btn_finalizar_compra_popup).click();
    }

    public void verificarTituloCarritoDeCompras(){
        String etiqueta_pag = this.driver.findElement(PrecioProductoPage.etiqueta_carrito).getText();
        String etiqueta_esperada = "CARRITO";
        Assert.assertEquals("Etiqueta de Carrito de Compras Esperada:",etiqueta_esperada,etiqueta_pag);
    }

    public void verificarMontosCarritoDeCompras(){
        float precio_unitario = Float.parseFloat(this.driver.findElement(PrecioProductoPage.etiqueta_precio_unitario).getText().substring(3));
        float cantidad_producto = Float.parseFloat(this.driver.findElement(PrecioProductoPage.etiqueta_cantidad_producto).getText().substring(0,1));
        float total_monto = Float.parseFloat(this.driver.findElement(PrecioProductoPage.etiqueta_monto_total).getText().substring(3));

        Assert.assertEquals("Monto Esperado Carrito de Compras:",String.valueOf(total_monto),String.valueOf(precio_unitario*cantidad_producto));
    }

}
