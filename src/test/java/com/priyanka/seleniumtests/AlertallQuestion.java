package com.priyanka.seleniumtests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.collections.SetMultiMap;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class AlertallQuestion {
    WebDriver driver = null;

    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Test
    public void allseleniumquest() throws IOException {

        driver= new ChromeDriver();
        driver.switchTo().alert().accept();
        driver.switchTo().alert().dismiss();

        Alert tesxt =driver.switchTo().alert();
        System.out.println(tesxt.getText());


        driver.switchTo().frame(0);
        driver.switchTo().frame("frame");
        driver.switchTo().frame(driver.findElement(By.xpath("")));

        Set<String> handler= driver.getWindowHandles();
        Iterator<String> it = handler.iterator();
        String paren=it.next();
        String child= it.next();
       driver.switchTo().window(child);
z
       driver.switchTo().defaultContent();//get back to default content
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

//        WebDriverWait wait1 = new WebDriverWait(driver,30);
//        wait1().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));

        Actions act=new Actions(driver);
        act.moveToElement(driver.findElement(By.xpath(""))).build().perform();


        Select sel = new Select(driver.findElement(By.xpath("")));
        sel.selectByValue("");
        sel.selectByIndex(8);
        sel.selectByVisibleText("");
        List<WebElement> op= sel.getOptions();

        Actions act1=new Actions(driver);
        act.dragAndDrop(driver.findElement(By.xpath("")),driver.findElement(By.xpath("")));

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile,new File("c:\\test\\screenshot\\login"+".png"));

        driver.manage().window().getPosition().getX();
        driver.manage().window().getPosition().getY();

        String curl = driver.getCurrentUrl();
        driver.getTitle();


        driver.findElement(By.xpath("")).isSelected();
        driver.findElement(By.xpath("")).isDisplayed();

       JavascriptExecutor js= ((JavascriptExecutor)driver);
       js.executeScript("window.scrolldown(0,3000)");






    }

}