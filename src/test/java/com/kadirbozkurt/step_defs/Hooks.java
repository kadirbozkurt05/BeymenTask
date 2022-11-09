package com.kadirbozkurt.step_defs;

import com.kadirbozkurt.Base;
import com.kadirbozkurt.utils.Driver;
import io.cucumber.java.After;
import io.cucumber.java.BeforeStep;
import org.openqa.selenium.NoAlertPresentException;


public class Hooks extends Base {
    @After
    public void teardown(){
    Driver.close();
}

}
