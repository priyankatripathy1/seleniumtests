package com.priyanka.seleniumtests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropdownWithoutSelect {
    static WebDriver driver =  null;

    public static void main(String args[]) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.get("https://www.1800flowers.com");
        driver.findElement(By.id("zipcode-native-label-placeholder")).sendKeys("30066");


        String occasion_xpath ="occasion-native-label-placeholder";
        String arrive_xpath = "arrive-native-label-placeholder";

        selectDropDown(occasion_xpath,"Anniversary");
        selectDropDown(arrive_xpath,"Wedenesday, jan-12");
        Thread.sleep(2000);

    }

    public static void selectDropDown(String xpathvalue, String value){
        List<WebElement> list =driver.findElements(By.xpath(xpathvalue));
        System.out.println(list.size());

        for(int i =0;i<list.size();i++){
            System.out.println(list.get(i).getText());
            if(list.get(i).getText().equalsIgnoreCase(value)){
                break;
            }
        }

    }

}
