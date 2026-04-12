package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CssSelectorDemo {

    public static void main(String[] args) throws InterruptedException {

        // Setup ChromeDriver
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();

        // Open website
        driver.get("https://the-internet.herokuapp.com/login");
        driver.manage().window().maximize();

        // -------------------------------
        // 1. Using ID Selector (#)
        // -------------------------------
        WebElement username = driver.findElement(By.cssSelector("#username"));
        username.sendKeys("tomsmith");

        // -------------------------------
        // 2. Using Attribute Selector
        // -------------------------------
        WebElement password = driver.findElement(By.cssSelector("input[name='password']"));
        password.sendKeys("SuperSecretPassword!");

        // -------------------------------
        // 3. Using Class Selector (.)
        // -------------------------------
        WebElement loginBtn = driver.findElement(By.cssSelector(".radius"));
        loginBtn.click();

        Thread.sleep(2000);

        // -------------------------------
        // 4. Using Descendant Selector
        // -------------------------------
        WebElement successMsg = driver.findElement(By.cssSelector("div.flash.success"));
        System.out.println("Message: " + successMsg.getText());

        // -------------------------------
        // 5. Using Contains (*=)
        // -------------------------------
        WebElement logoutBtn = driver.findElement(By.cssSelector("a[href*='logout']"));
        logoutBtn.click();

        Thread.sleep(2000);

        // Close browser
        driver.quit();
    }
}