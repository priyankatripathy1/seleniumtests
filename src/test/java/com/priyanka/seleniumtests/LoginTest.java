package com.priyanka.seleniumtests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class LoginTest {
    WebDriver driver = null;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterTest
    public void cleanup() {
        driver.close();
        driver.quit();
    }

    @Test
    public void login() throws InterruptedException {
        driver.get("https://www.1800flowers.com");
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.id("hp-sign-in")))
                .build().perform();
        //driver.switchTo().frame("")

        //driver.findElement(By.className("MuiTouchRipple-root")).click();

        //driver.findElement(By.xpath("//button[contains(@class, 'mbp150')]")).click();

        //driver.findElement(By.xpath("//button[contains(@class, 'mbp150')]")).click();
        //driver.findElement(By.xpath("//*[@id='sign-in-dropdown']/div[3]/button[1]/span[1]/span")).click();

        //driver.findElement(By.xpath("//*[@id='hp-signin-dropdown']/span[1]")).click();
        driver.findElement(By.id("click-here-dropdown")).click();
        Set<String> handler = driver.getWindowHandles();
        Iterator<String> it = handler.iterator();
        String parentWindowId = it.next();
        String childWindowId = it.next();

        System.out.println("parent: " + parentWindowId + " child: " + childWindowId);
        driver.switchTo().window(childWindowId);

        driver.findElement(By.id("firstNameField")).sendKeys("Priyanka");
        driver.findElement(By.id("lastNameField")).sendKeys("Tripathy");
        driver.findElement(By.id("emailField")).sendKeys("prianka.tripathy1@gmail.com");
        driver.findElement(By.id("passwordField-ca")).sendKeys("Airw@tch1");
        driver.findElement(By.id("createAccBtn")).click();
        Thread.sleep(3000);
    }

    @Test
    public void testHoverMenu() throws InterruptedException {
        driver.get("https://www.1800flowers.com");
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//*[@id='Birthday_1']/span")))
                .build().perform();

        driver.findElement(By.linkText("Jewelry")).click();

        Thread.sleep(3000);
    }





    @Test
    public void exceptionTest() {
        driver.get("https://www.1800flowers.com");

        Actions action = new Actions(driver);
        Action action1 = null;
        try {
            action1 = action.moveToElement(driver.findElement(By.xpath("//*[@id='Birthday_1']/"))).build();
        } catch (InvalidSelectorException ex) {
            System.out.println(ex.getMessage());
        }

        action1.perform();
    }

}
