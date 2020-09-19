package com.officeMaven;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class JUnitTest1 {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
         driver=new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void test1() throws InterruptedException {
        driver.get("https://www.facebook.com/");
        WebElement createButton = driver.findElement(By.id("u_0_2"));
        createButton.click();
        WebElement firstName = driver.findElement(By.xpath("//input[@id=\"u_2_b\"]"));
        Faker faker = new Faker();
        firstName.sendKeys(faker.name().firstName());
        WebElement lastName = driver.findElement(By.xpath("//input[@id='u_2_d']"));
        lastName.sendKeys(faker.name().lastName());
        WebElement emailKutusu = driver.findElement(By.xpath("//input[@name='reg_email__']"));
        String fakeEmail =faker.internet().emailAddress();
        emailKutusu.sendKeys(fakeEmail);
        WebElement reEnterMail = driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']"));
        reEnterMail.sendKeys(fakeEmail);
        WebElement passWord = driver.findElement(By.xpath("//input[@name='reg_passwd__']"));
        passWord.sendKeys(faker.internet().password());
        WebElement month = driver.findElement(By.xpath("//select[@name='birthday_month']"));
        Select select = new Select(month);
        select.selectByIndex(7);
        WebElement day = driver.findElement(By.xpath("//select[@name='birthday_day']"));
        Select select1 = new Select(day);
        select1.selectByIndex(1);
        WebElement year = driver.findElement(By.xpath("//select[@name='birthday_year']"));
        Select select2 =new Select(year);
        select2.selectByIndex(7);


        WebElement maleButton = driver.findElement(By.xpath("//*[@id=\"u_2_o\"]/span[2]/label"));
        maleButton.click();
        Thread.sleep(3000);
        WebElement femaleButton = driver.findElement(By.xpath("//label[@class='_58mt']"));

        Assert.assertTrue(maleButton.isSelected());
      //  Assert.assertFalse(femaleButton.isSelected());

    }
    @After
    public void tearDown(){
        driver.quit();
    }


}
