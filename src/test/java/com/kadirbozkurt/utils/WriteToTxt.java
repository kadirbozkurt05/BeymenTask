package com.kadirbozkurt.utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class WriteToTxt {


        public static void writeToTxt(String str){
            File file = new File("target/product.txt");
            try {
                FileUtils.writeStringToFile(file, str);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
}
