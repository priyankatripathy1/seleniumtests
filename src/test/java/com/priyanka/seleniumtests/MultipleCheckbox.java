package com.priyanka.seleniumtests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MultipleCheckbox {
    static WebDriver driver;


    public static void main(String args[]) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("https://www.1800flowers.com");
        driver.findElement(By.id("zipcode-native-label-placeholder")).sendKeys("30066");



        //Approach 1
        //Select occasion =new Select(driver.findElement(By.id("occasion-native-label-placeholder")));
        //occasion.selectByVisibleText("Anniversary");

        //Select whenArrive = new Select(driver.findElement(By.id("arrive-native-label-placeholder")));
        //whenArrive.selectByValue("Tuesday,jan 11");

        //Approach2
        WebElement occasionele = driver.findElement(By.id("occasion-native-label-placeholder"));
        selectoptionfromDropdown(occasionele, "Anniversary");

        WebElement whenArriveele = driver.findElement(By.id("arrive-native-label-placeholder"));
        selectoptionfromDropdown(whenArriveele, "Sunday, Jan 16");
        Thread.sleep(2000);
        driver.close();
    }

    public static void selectoptionfromDropdown(WebElement ele, String value) {
        Select drp = new Select(ele);
        List<WebElement> alloptions = drp.getOptions();
        for (WebElement option : alloptions) {
            if (option.getText().equalsIgnoreCase(value)) {
                option.click();
                break;
            }
        }
    }


}











