package com.officeMaven;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.sql.DriverManager;
import java.util.concurrent.TimeUnit;

public class JunitTest2 {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }
    @Test
    public void test1(){
        //1. “http://zero.webappsecurity.com/” Adresine gidin
        driver.get("http://zero.webappsecurity.com");
        //2. Sign in butonuna basin
        driver.findElement(By.id("signin_button")).click();
        //3. Login kutusuna “username” yazin
        WebElement usernameKutusu= driver.findElement(By.id("user_login"));
        usernameKutusu.sendKeys("username");
        //4. Password kutusuna “password” yazin
        WebElement passwordKutusu= driver.findElement(By.id("user_password"));
        passwordKutusu.sendKeys("password");
        //5. Sign in tusuna basin
        driver.findElement(By.xpath("//input[@name='submit']")).click();
        //6. Pay Bills sayfasina gidin
        driver.findElement(By.linkText("Pay Bills")).click();
        //7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.linkText("Purchase Foreign Currency")).click();
        //8. “Currency” drop down menusunden Eurozone’u secin
        WebElement currencyDropDown = driver.findElement(By.id("pc_currency"));
        Select select=new Select(currencyDropDown);
        select.selectByValue("EUR");
        //9. “amount” kutusuna bir sayi girin
        WebElement amountKutusu= driver.findElement(By.id("pc_amount"));
        amountKutusu.sendKeys("100");
        //10. “US Dollars” in secilmedigini kontrol edin
        WebElement usDollars =driver.findElement(By.id("pc_inDollars_true"));
        Assert.assertFalse(usDollars.isSelected());
        //11. “Selected currency” butonunu secin
        driver.findElement(By.id("pc_inDollars_false")).click();
        //12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driver.findElement(By.id("pc_calculate_costs")).click();
        driver.findElement(By.id("purchase_cash")).click();
        //13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.

        WebElement alertYazisi=driver.findElement(By.id("alert_content"));
        String actualAlertYazisi=alertYazisi.getText();
        String beklenenAlertYazisi="Foreign currency cash was successfully purchased.";
        Assert.assertEquals(actualAlertYazisi, beklenenAlertYazisi);


    }
    @After
    public void tearDown(){
        driver.close();
    }

}
