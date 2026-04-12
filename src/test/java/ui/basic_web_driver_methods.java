package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class basic_web_driver_methods {

    public static void main(String[] args) throws InterruptedException {

        // Setup ChromeDriver automatically
        WebDriverManager.chromedriver().setup();

        // Launch browser
        WebDriver driver = new ChromeDriver();

        // 1. get() - Open URL
        driver.get("https://www.google.com");

        // 2. getTitle()
        String title = driver.getTitle();
        System.out.println("Page Title: " + title);

        // 3. getCurrentUrl()
        String url = driver.getCurrentUrl();
        System.out.println("Current URL: " + url);

        // 4. getPageSource()
        String pageSource = driver.getPageSource();
        System.out.println("Page Source Length: " + pageSource.length());

        // 5. manage() - Maximize window
        driver.manage().window().maximize();

        // 6. findElement() - Search box
        driver.findElement(By.name("q")).sendKeys("Selenium WebDriver");

        Thread.sleep(2000);

        // 7. navigate() - Go to another page
        driver.navigate().to("https://www.selenium.dev");

        Thread.sleep(2000);

        // navigate back
        driver.navigate().back();

        Thread.sleep(2000);

        // navigate forward
        driver.navigate().forward();

        Thread.sleep(2000);

        // refresh page
        driver.navigate().refresh();

        // 8. switchTo() example (alert demo site)
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
        
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();

        Thread.sleep(5000);
        // Switch to alert
        driver.switchTo().alert().accept();

        Thread.sleep(2000);

        // 9. close() - Close current tab
        driver.close();

        // 10. quit() - Close entire browser session
        driver.quit();
    }
}