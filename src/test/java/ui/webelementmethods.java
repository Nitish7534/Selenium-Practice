package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class webelementmethods {

    public static void main(String[] args) throws InterruptedException {

        // Setup driver
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();

        // Open website
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        // -------------------------------
        // 1. sendKeys() + clear() (CSS)
        // -------------------------------
        WebElement username = driver.findElement(By.cssSelector("#user-name"));
        username.sendKeys("standard_user");
        Thread.sleep(2000);

        username.clear();
        Thread.sleep(2000);

        username.sendKeys("standard_user");
        Thread.sleep(2000);

        // -------------------------------
        // 2. getAttribute()
        // -------------------------------
        String placeholder = username.getAttribute("placeholder");
        System.out.println("Placeholder: " + placeholder);
        Thread.sleep(2000);

        // -------------------------------
        // 3. isDisplayed() & isEnabled()
        // -------------------------------
        if(username.isDisplayed()) {
            System.out.println("Username field is visible");
        }

        if(username.isEnabled()) {
            System.out.println("Username field is enabled");
        }
        Thread.sleep(2000);

        // -------------------------------
        // Password field (XPath)
        // -------------------------------
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("secret_sauce");
        Thread.sleep(2000);

        // -------------------------------
        // 4. getTagName()
        // -------------------------------
        String tag = password.getTagName();
        System.out.println("Tag name: " + tag);
        Thread.sleep(2000);

        // -------------------------------
        // 5. click() (CSS)
        // -------------------------------
        WebElement loginBtn = driver.findElement(By.cssSelector("#login-button"));
        loginBtn.click();
        Thread.sleep(3000);

        // -------------------------------
        // After login
        // -------------------------------

        // 6. getText() (XPath)
        WebElement title = driver.findElement(By.xpath("//span[@class='title']"));
        String text = title.getText();
        System.out.println("Page Title: " + text);
        Thread.sleep(2000);

        // -------------------------------
        // 7. getCssValue()
        // -------------------------------
        String color = title.getCssValue("color");
        System.out.println("Title color: " + color);
        Thread.sleep(2000);

        // -------------------------------
        // 8. getLocation()
        // -------------------------------
        Point location = title.getLocation();
        System.out.println("X: " + location.getX());
        System.out.println("Y: " + location.getY());
        Thread.sleep(2000);

        // -------------------------------
        // 9. getSize()
        // -------------------------------
        Dimension size = title.getSize();
        System.out.println("Width: " + size.getWidth());
        System.out.println("Height: " + size.getHeight());
        Thread.sleep(2000);

        // -------------------------------
        // 10. isSelected() + click() (XPath)
        // -------------------------------
        WebElement addToCart = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
        
        if(!addToCart.isSelected()) {
            addToCart.click();
            System.out.println("Clicked Add to Cart button");
        }
        Thread.sleep(3000);

        // -------------------------------
        // Close browser
        // -------------------------------
        driver.quit();
    }
}