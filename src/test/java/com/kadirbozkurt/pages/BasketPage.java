package com.kadirbozkurt.pages;

import com.kadirbozkurt.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BasketPage {
    public BasketPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(className = "m-productPrice__salePrice")
    public WebElement priceOnBasket;
    public Select quantity(){
        return new Select(Driver.getDriver().findElement(By.id("quantitySelect0-key-0")));
    }
    @FindBy(id = "removeCartItemBtn0-key-0")
    public WebElement deleteProduct;
    @FindBy(xpath = "//strong[.='Sepetinizde Ürün Bulunmamaktadır']")
    public WebElement basketIsempty;
}
