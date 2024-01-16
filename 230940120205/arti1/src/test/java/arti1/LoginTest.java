package arti1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    public static void main(String[] args) {       
        WebDriver driver = new ChromeDriver();

        // Navigate to the login page
        driver.get("https://mail.rediff.com/cgi-bin/login.cgi");

        // Enter username and password
        WebElement username = driver.findElement(By.id("login1"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.name("proceed"));

        username.sendKeys("your_username");
        password.sendKeys("your_password");
        loginButton.click();

        // Verify the error message
        WebElement errorMessage = driver.findElement(By.id("div_login_error"));
        String actualErrorMessage = errorMessage.getText();
        String expectedErrorMessage = "Please enter a valid username";

        if (actualErrorMessage.equals(expectedErrorMessage)) {
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed! Actual error message: " + actualErrorMessage);
        }

        // Close the browser
        driver.quit();
    }
}
