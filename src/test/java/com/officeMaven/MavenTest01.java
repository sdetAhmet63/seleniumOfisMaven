package com.officeMaven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MavenTest01 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.thetrainline.com");
        WebElement returnButton=driver.findElement(By.xpath("//input[@id='return']"));
        returnButton.click();

        if (returnButton.isSelected()){

            System.out.println("Return butonu secildi Test PASS");
        }else{
            System.out.println("Return butonu secilmedi Test FAILED");
        }

        WebElement returnDate = driver.findElement(By.xpath("//*[@id=\"page.journeySearchForm.inbound.title\"]"));
        if (returnButton.isEnabled()){
           System.out.println("Return Date kutusu erisilebilir durumda Test PASS ");
       }else{
            System.out.println("Return Date kutusu erisilebilir durumda  degil Test FAILED ");
        }

        WebElement tekYonRadioButonu= driver.findElement(By.xpath("//*[@id=\"single\"]"));
        if (!tekYonRadioButonu.isSelected()){
            System.out.println("Tek Yon Radio Butonu secili degil Test PASS");
        }else{
            System.out.println("Tek Yon Radio Butonu secili Test Failed");
        }

        driver.close();

    }
}
