package com.kadirbozkurt.pages;

import com.kadirbozkurt.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    public ProductPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = ".o-productDetail__title")
    public WebElement productInfo;
    @FindBy(id = "priceNew")
    public WebElement productPrice;
    @FindBy(xpath = "//span[@class='m-variation__item']")
    public WebElement productSizeForStockValid;
    @FindBy(xpath = "//span[@class='m-variation__item -criticalStock']")
    public WebElement productSizeForStockLess;
    @FindBy(id = "addBasket")
    public WebElement addToBasket;
    @FindBy(css = ".m-notification__button.btn")
    public WebElement goToBasket;
}
