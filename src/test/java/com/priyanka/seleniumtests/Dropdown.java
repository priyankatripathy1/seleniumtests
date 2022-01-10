package com.priyanka.seleniumtests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class Dropdown {
   static WebDriver driver;

   public static void main(String args[]) throws InterruptedException {
       WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver();
       driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
       By country = By.id("Form_submitForm_Country");

       Select select1 = new Select(driver.findElement(country));
       select1.selectByVisibleText("india");
       select1.selectByIndex(3);
       select1.deselectByValue("china");
       Thread.sleep(2000);

   }

}
