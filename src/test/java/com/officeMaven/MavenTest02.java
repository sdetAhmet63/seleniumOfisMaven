package com.officeMaven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MavenTest02 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.saucedemo.com");
        WebElement userName= driver.findElement(By.xpath("//*[@id=\"user-name\"]"));
        userName.sendKeys("standard_user");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
        //Sauce Labs Backpack
        WebElement ilkUrun = driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div"));
        String ilkUrunAdi = ilkUrun.getText();
        System.out.println(ilkUrun.getText());
        driver.findElement(By.xpath("//*[.='ADD TO CART']")).click();
        ////*[@id="inventory_item_container"]/div/div/div/button
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span")).click();
        WebElement urunAdiDogruMu= driver.findElement(By.partialLinkText("Sauce Labs Backpack"));
        if (urunAdiDogruMu.getText().equals(ilkUrunAdi)){
            System.out.println("Sectigim urun ile sepetteki urun ayni Test PASS");
        }else{
            System.out.println("Urun farkli Test FAILED");
        }

        driver.close();

    }
}
