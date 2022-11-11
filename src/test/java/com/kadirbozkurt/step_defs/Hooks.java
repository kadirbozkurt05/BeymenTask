package com.kadirbozkurt.step_defs;

import com.kadirbozkurt.base.Base;
import com.kadirbozkurt.utils.Driver;
import io.cucumber.java.After;


public class Hooks extends Base {
    @After
    public void teardown(){
    Driver.close();
}

}
