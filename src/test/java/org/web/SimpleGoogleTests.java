package org.web;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class SimpleGoogleTests {

    public WebDriver driver;


    @BeforeTest()
    public void init(){

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");

        driver = new ChromeDriver(options);
        driver.get("https://www.google.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test()
    public void searchtest() throws InterruptedException {
        driver.findElement(By.name("q")).click();
        driver.findElement(By.name("q")).sendKeys("github java actions\n");
        Thread.sleep(3000);
        String resultTXT = driver.findElement(By.id("result-stats")).getText();
        System.out.println(resultTXT);

    }

    @AfterTest()
    public void finishTests(){
          driver.quit();
    }





}