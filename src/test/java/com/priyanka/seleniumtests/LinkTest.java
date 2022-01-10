package com.priyanka.seleniumtests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.util.concurrent.TimeUnit;


public class LinkTest {
    WebDriver driver=null;


    @BeforeTest
    public void beforetest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void link() throws InterruptedException {
        driver.get("https://www.1800flowers.com");

        //driver.findElement(By.className("MuiButton-label")).click();

        Actions action= new Actions(driver);
        action.moveToElement(driver.findElement(By.id("Birthday_1"))).build().perform();
        //Thread.sleep(2000);
        driver.findElement(By.linkText("Birthday Gift guide")).click();
    }
    @AfterTest
    public void aftertest(){
        driver.close();
        //driver.quit();
    }
}

