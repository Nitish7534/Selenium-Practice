package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");

        Thread.sleep(2000); // wait 2 seconds
        driver.manage().window().maximize();
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        Thread.sleep(2000); // wait

        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        Thread.sleep(2000); // wait

        driver.findElement(By.id("login-button")).click();

        Thread.sleep(3000); // wait before closing

        driver.close();
    }
}