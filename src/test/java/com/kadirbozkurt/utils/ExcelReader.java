package com.kadirbozkurt.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

public class ExcelReader {
    private static FileInputStream file;
    private static XSSFWorkbook workbook;
    private static XSSFSheet sheet;

    static {
        try
        {
            file = new FileInputStream("beymen.xlsx");

            workbook = new XSSFWorkbook(file);

            sheet = workbook.getSheet("beymen");

            file.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static String readCell(int rowNum, int columnNum) {
       return sheet.getRow(rowNum).getCell(columnNum).toString();
    }
}
