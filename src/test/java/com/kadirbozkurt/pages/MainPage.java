package com.kadirbozkurt.pages;


import com.kadirbozkurt.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class MainPage {
    public MainPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement allowCookies;
    public void allowCookies(){
        allowCookies.click();
    }
    @FindBy(css = ".default-input.o-header__search--input")
    public WebElement searchInput;
    public void clearInput(WebElement element){
        while (!element.getAttribute("value").isEmpty()){
            element.sendKeys(Keys.BACK_SPACE);
        }
    }

    @FindBy(xpath = "//a[@title='Sepetim']")
    public WebElement myBasket;
    @FindBy(xpath = "//a[@title='Beymen']")
    public WebElement goToMainPage;



}
