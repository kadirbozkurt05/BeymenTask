package com.kadirbozkurt.step_defs;
import static com.kadirbozkurt.utils.Driver.*;

import com.kadirbozkurt.Base;
import com.kadirbozkurt.utils.ConfigReader;
import com.kadirbozkurt.utils.Driver;
import com.kadirbozkurt.utils.ExcelReader;
import com.kadirbozkurt.utils.WriteToTxt;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;


import static org.junit.Assert.*;

public class Task_Step_Defs extends Base {
    String getPriceInfo;
    String getProductInfo;
    @Given("www.beymen.com sitesi açılır.")
    public void beymen_sitesi_acilir(){
        getDriver().get(ConfigReader.getProperty("url"));
        mainPage.allowCookies();
    }
    @When("Ana sayfanın açıldığı kontrol edilir.")
    public void ana_sayfanın_açıldığı_kontrol_edilir() {
        String expectedTitle = "Beymen.com – Türkiye’nin Tek Dijital Lüks Platformu";
        String actualTitle = getDriver().getTitle();
        assertEquals(expectedTitle,actualTitle);

    }
    @When("Arama kutucuğuna “şort” kelimesi girilir.")
    public void arama_kutucuğuna_şort_kelimesi_girilir_not_şort_kelimesi_excel_dosyası_üzerinden_sütun_satırdan_alınarak_yazılmalıdır() {
        mainPage.searchInput.sendKeys(ExcelReader.readCell(0,0));
    }
    @When("Arama kutucuğuna girilen “şort” kelimesi silinir.")
    public void arama_kutucuğuna_girilen_şort_kelimesi_silinir() {
    mainPage.clearInput(mainPage.searchInput);
    }
    @When("Arama kutucuğuna “gömlek” kelimesi girilir.")
    public void arama_kutucuğuna_gömlek_kelimesi_girilir_not_gömlek_kelimesi_excel_dosyası_üzerinden_sütun_satırdan_alınarak_yazılmalıdır() {
        mainPage.searchInput.sendKeys("");
        mainPage.searchInput.sendKeys(ExcelReader.readCell(0,1));
    }
    @When("Klavye üzerinden “enter” tuşuna bastırılır")
    public void klavye_üzerinden_enter_tuşuna_bastırılır() {
        mainPage.searchInput.sendKeys(Keys.ENTER);
    }
    @When("Sonuca göre sergilenen ürünlerden rastgele bir ürün seçilir.")
    public void sonuca_göre_sergilenen_ürünlerden_rastgele_bir_ürün_seçilir() {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(searchPage.randomProduct());

        searchPage.randomProduct().click();
    }
    @When("Seçilen ürünün ürün bilgisi ve tutar bilgisi txt dosyasına yazılır.")
    public void seçilen_ürünün_ürün_bilgisi_ve_tutar_bilgisi_txt_dosyasına_yazılır() {
         getProductInfo = productPage.productInfo.getText();
         getPriceInfo = productPage.productPrice.getText();

        String str = "Product Price : "+ getPriceInfo+"\n"+"Product Info : "+getProductInfo;

        WriteToTxt.writeToTxt(str);
    }
    @When("Seçilen ürün sepete eklenir.")
    public void seçilen_ürün_sepete_eklenir() {
        try{
            productPage.productSizeForStockValid.click();
        }catch (NoSuchElementException e){
            productPage.productSizeForStockLess.click();
        }

        productPage.addToBasket.click();
    }
    @When("Ürün sayfasındaki fiyat ile sepette yer alan ürün fiyatının doğruluğu karşılaştırılır.")
    public void ürün_sayfasındaki_fiyat_ile_sepette_yer_alan_ürün_fiyatının_doğruluğu_karşılaştırılır() {
        productPage.goToBasket.click();
        String actualPrice = basketPage.priceOnBasket.getText();

        assertEquals(getPriceInfo,actualPrice);
    }
    @When("Adet arttırılarak ürün adedinin {int} olduğu doğrulanır.")
    public void adet_arttırılarak_ürün_adedinin_olduğu_doğrulanır(Integer total) {
        try{
            basketPage.quantity().selectByValue("2");
            Integer actualQuantity = Integer.parseInt(basketPage.quantity().getFirstSelectedOption().getAttribute("value")) ;
            assertEquals(total,actualQuantity);
        }catch (NoSuchElementException e){
            System.out.println("Only one product left");
        }

    }
    @When("Ürün sepetten silinerek sepetin boş olduğu kontrol edilir.")
    public void ürün_sepetten_silinerek_sepetin_boş_olduğu_kontrol_edilir() {
        basketPage.deleteProduct.click();
        try{
            assertTrue(basketPage.basketIsempty.isDisplayed());
        }catch (NoSuchElementException e){
            fail();
        }
    }
}
