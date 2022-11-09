package com.kadirbozkurt.pages;

import com.kadirbozkurt.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class SearchPage {
    public SearchPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBys({
            @FindBy(xpath = "//div[@id='productList']/div")
    })
    public List<WebElement> products;
    public WebElement randomProduct(){
        Random random = new Random();
        return products.get(random.nextInt(products.size()));
    }
}
