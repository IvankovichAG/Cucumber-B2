package com.loop.utilities;

public class TestExcel {
    public static void main(String[] args) {


        ExcelUtils excelUtils = new ExcelUtils("/Users/annaivankovich/IdeaProjects/cucumber-project-b2/src/test/resources/Sample.xlsx", "Nadir");
        System.out.println("excelUtils.getCellData(1,1) = " + excelUtils.getCellData(1, 1));
    }



}
