package com.priyanka.seleniumtests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Checkboxes {

    public static void main(String args[]){
    WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
    driver.get("https://itera-qa.azurewebsites.net/home/automation");

    List<WebElement> checkboxes= driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'day')]"));


    //for selecting all checkboxes
//        for(WebElement chk:checkboxes){
//            chk.click();
//        }
    for(int i=0;i<=checkboxes.size();i++){
       checkboxes.get(i).click();
   }

    //select multiple checkbox of ur choice

        for(WebElement chbox:checkboxes){
            String checkboxname = chbox.getAttribute("id");
            if(checkboxname.equals("monday") || checkboxname.equals("sunday")){
                chbox.click();
            }
        }

        //select last 2 checkbox
        int totalcheckboxes = checkboxes.size();
        for(int i=totalcheckboxes-2;i<totalcheckboxes;i++){
            checkboxes.get(i).click();
        }

    }

}
