package US202;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class TC0201 extends BaseDriver {
    @Test
    public void Test1(){

        driver.get("https://demowebshop.tricentis.com");
        MyFunc.wait(2);

        driver.findElement(By.xpath("//*[text()='Register']")).click();
        driver.findElement(By.id("gender-female")).click();
        driver.findElement(By.id("FirstName")).sendKeys(" Mary");
        driver.findElement(By.id("LastName")).sendKeys("Johnson");
        driver.findElement(By.name("Email")).sendKeys(" techno.team12@gmail.com");
        driver.findElement(By.xpath("//*[@class='text-box single-line password'][1]")).sendKeys("Pass1234");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("Pass1234");
        driver.findElement(By.xpath("//input[@class='button-1 register-next-step-button']")).click();

        
        Assert.assertFalse("Kullanici hesabi basarili acildi","https://demowebshop.tricentis.com/register".equals(driver.getCurrentUrl()));

    }

}
