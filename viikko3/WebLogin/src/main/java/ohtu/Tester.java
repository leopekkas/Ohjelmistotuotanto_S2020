package ohtu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;

public class Tester {

    public static void main(String[] args) {
        
        /*
        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:4567");
        
        sleep(2);
        
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));
        
        sleep(2);
        element.submit();

        sleep(3);
        
        
        
        driver.quit();
        */
        
        // Oikea käyttäjätunnus, väärä salasana
        /*
        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:4567");
        
        sleep(2);
        
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("false");
        element = driver.findElement(By.name("login"));
        
        sleep(2);
        element.submit();

        sleep(3);
        
        
        
        driver.quit();
        */
        
        // Uuden käyttäjätunnuksen luominen
        /*
        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:4567");
        
        sleep(2);
        
        WebElement element = driver.findElement(By.xpath("//a[@href='user']"));
        element.click();

        sleep(2);

        Random r = new Random();
    
        element = driver.findElement(By.name("username"));
        element.sendKeys("arto"+r.nextInt(100000));
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("signup"));
        
        sleep(2);
        element.submit();

        sleep(3);
        
        
        
        driver.quit();
        */
        
        
        // Uuden käyttäjätunnuksen luomisen jälkeen tapahtuva uloskirjautuminen
        
        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:4567");
        
        sleep(2);
        
        //WebElement element = driver.findElement(By.linkText("user"));
        WebElement element = driver.findElement(By.xpath("//a[@href='user']"));
        element.click();

        sleep(2);

        Random r = new Random();
    
        element = driver.findElement(By.name("username"));
        element.sendKeys("arto"+r.nextInt(100000));
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkip");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("akkip");
        element = driver.findElement(By.name("signup"));
        
        sleep(2);
        element.submit();

        sleep(3);
        
        element = driver.findElement(By.xpath("//a[@href='ohtu']"));
        element.click();
        
        sleep(2);
        
        element = driver.findElement(By.xpath("//a[@href='/']"));
        element.click();
        
        driver.quit();  
        
        
    }
    
    private static void sleep(int n){
        try{
            Thread.sleep(n*1000);
        } catch(Exception e){}
    }
}
