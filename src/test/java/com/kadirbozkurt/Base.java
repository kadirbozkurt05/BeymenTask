package com.kadirbozkurt;

import com.kadirbozkurt.pages.BasketPage;
import com.kadirbozkurt.pages.MainPage;
import com.kadirbozkurt.pages.ProductPage;
import com.kadirbozkurt.pages.SearchPage;
import com.kadirbozkurt.utils.Driver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Base {
    protected MainPage mainPage = new MainPage();
    protected WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
    protected SearchPage searchPage = new SearchPage();
    protected ProductPage productPage = new ProductPage();
    protected BasketPage basketPage = new BasketPage();
}
