package com.priyanka.seleniumtests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.*;

public class DropDown1800 {
    WebDriver driver = null;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void dropdown() throws InterruptedException {
        driver.get("https://www.1800flowers.com");
        driver.findElement(By.id("zipcode-native-label-placeholder")).sendKeys("30066");
        WebElement drpbox=driver.findElement(By.id("occasion-native-label-placeholder"));
        Select drpbox1 = new Select(drpbox);

        //drpbox1.selectByVisibleText("Anniversary");
        //drpbox1.selectByIndex(6);
       // drpbox1.selectByValue("Sympathy");

        //selecting options from dropdown without using methods

        List<WebElement> alloptions=drpbox1.getOptions();

        for(WebElement option:alloptions){

            if(option.getText().equals("Anniversary"))
            {
                option.click();
                break;
            }

          //handlle mutliple dropdown
        }



        sleep(3000);


    }
    @AfterTest
    public void cleanup(){
        driver.close();
        driver.quit();

    }



}
