package com.go2it.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {


    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\oleksandr.ryzhkov\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.w3schools.com/bootstrap/bootstrap_modal.asp");

        // .//div - search in a current elem the div with class -
//        final WebElement element = driver.findElement(By.xpath(".//button[@data-toggle='modal']"));
        final WebElement element = driver.findElement(By.xpath(".//input[contains(., \"Desired text\")]"));
        //div[contains(., "Desired text")]

        element.click();
//        element.findElement(By.xpath(".//button[@class='accordion']")).click();
//        System.out.println("showing the text from expandable: " + element.findElement(By.xpath("//*[@id=\"main\"]/div[3]/p")).getText());
//*[@id="main"]/div[3]/p
        //*[@id="main"]/button

    }
}
