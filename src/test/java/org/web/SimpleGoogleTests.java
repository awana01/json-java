package org.web;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class SimpleGoogleTests {

    public WebDriver driver;
    public Faker fake;

    @BeforeTest()
    public void init(){
        fake = new Faker();
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");

        driver = new ChromeDriver(options);
        driver.get("https://www.google.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test()
    public void searchtest() throws InterruptedException {

        String searchterm = fake.food().dish();

        driver.findElement(By.name("q")).click();
        driver.findElement(By.name("q")).sendKeys(searchterm+"\n");
        Thread.sleep(3000);
        String resultTXT = driver.findElement(By.id("result-stats")).getText();
        System.out.println(resultTXT);
        saveTextLog(resultTXT);
        Allure.addAttachment(searchterm, new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));
        System.out.println("Attaching screenshot in report");
//        takeScreenshot();

    }

    @Test()
    public void Test2(){
        String testTXT = "simple non gui test 2";
        System.out.println(testTXT);
        saveTextLog(testTXT);
        Allure.addAttachment("Step Msg:",testTXT);
    }

    @Test()
    public void Test3(){
        String testTXT = "simple non gui test 3";
        System.out.println(testTXT);
        saveTextLog(testTXT);
        Allure.addAttachment("Step Msg:",testTXT);
    }

    @Test()
    public void Test4(){
        String testTXT = "simple non gui test 4";
        System.out.println(testTXT);
        saveTextLog(testTXT);
        Allure.addAttachment("Step Msg:",testTXT);
    }

    @AfterTest()
    public void finishTests(){
          driver.quit();
    }


    public static void elementScreenShot(WebDriver driver, WebElement ele) throws IOException {

        //WebElement ele = driver.findElement(By.id("hplogo"));

        // Get entire page screenshot
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        BufferedImage fullImg = ImageIO.read(screenshot);

        // Get the location of element on the page
        Point point = ele.getLocation();

        // Get width and height of the element
        int eleWidth = ele.getSize().getWidth();
        int eleHeight = ele.getSize().getHeight();

        // Crop the entire page screenshot to get only element screenshot
        BufferedImage eleScreenshot= fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
        ImageIO.write(eleScreenshot, "png", screenshot);

        // Copy the element screenshot to disk
        File screenshotLocation = new File("eleImg.png");
        FileUtils.copyFile(screenshot, screenshotLocation);
    }

    @Attachment(value = "{0}", type = "text/plain")
    private static String saveTextLog(String message) {
        return message;
    }

    @Attachment(value = "Web Page Screenshot", type = "image/png")
    public byte[] takeScreenshot() {
        // Take a screenshot as byte array and return
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }

}
