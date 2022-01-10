package com.priyanka.seleniumtests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TakeaPicture {
    WebDriver driver = null;

    @Test
    public void javascript() throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://freecrm.com/");
        WebElement e = driver.findElement(By.xpath("//a[@href='https://ui.cogmento.com']"));
        flash(e, driver);
        changecolor("red", e, driver);
        Thread.sleep(3000);
    }

    public static void flash(WebElement element, WebDriver driver) {


        JavascriptExecutor js = (JavascriptExecutor) driver;
        String bgcolor = element.getCssValue("backgroundcolor");
        for (int i = 0; i < 100; i++) {
            changecolor("rbg(0,200.0)", element, driver);
        }
    }

    public static void changecolor(String color, WebElement element, WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("argument[0].style.backgroundcolor= '" + color + "'", element);

        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {

        }
    }

    public static void drawBorder(WebElement element, WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("argument[0].style.border='3px solid red'", element);
    }

    public static void generateAlert(WebDriver driver, String message) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("alert('" + message + "')");
    }

    public static void clickElement(WebElement element, WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("argumnet[0].click();", element);
    }

    public static void scrollPageDown(WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");



        }
    }



