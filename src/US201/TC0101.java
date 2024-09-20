package US201;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

public class TC0101 extends BaseDriver {
    @Test
    public void Test1(){

        driver.get("https://demowebshop.tricentis.com/");
        Assert.assertEquals("https://demowebshop.tricentis.com/",driver.getCurrentUrl());

        MyFunc.wait(1);

        WebElement registerbutton1= driver.findElement(By.className("ico-register"));
        MyFunc.isDisplayed(registerbutton1,"RegisterButton1");
        MyFunc.isEnabled(registerbutton1,"RegisterButton1");
        registerbutton1.click();

        MyFunc.wait(2);
        WebElement gender= driver.findElement(By.name("Gender"));
        MyFunc.isDisplayed(gender,"Gender");
        MyFunc.isEnabled(gender,"Gender");
        gender.click();

        MyFunc.wait(1);

        WebElement firstname=driver.findElement(By.id("FirstName"));
        MyFunc.isDisplayed(firstname,"FirstName");
        MyFunc.isEnabled(firstname,"FirstName");

        firstname.sendKeys("Team");

        MyFunc.wait(2);

        WebElement lastname=driver.findElement(By.xpath("//input[@id='LastName']"));
        MyFunc.isDisplayed(lastname,"LastName");
        MyFunc.isEnabled(lastname,"LastName");
        lastname.sendKeys("Oniki");
        MyFunc.wait(2);

        WebElement mail= driver.findElement(By.id("Email"));
        MyFunc.isDisplayed(mail,"Mail");
        MyFunc.isEnabled(mail,"Mail");
        mail.sendKeys("techno.team99@gmail.com");
        MyFunc.wait(2);
        WebElement password= driver.findElement(By.id("Password"));
        MyFunc.isDisplayed(password,"Password");
        MyFunc.isEnabled(password,"Password");
        password.sendKeys("Pass1234");
        MyFunc.wait(2);

        WebElement passwordconfirm= driver.findElement(By.id("ConfirmPassword"));
        MyFunc.isDisplayed(passwordconfirm,"PasswordConfirm");
        MyFunc.isEnabled(passwordconfirm,"PasswordConfirm");
        passwordconfirm.sendKeys("Pass1234");
        MyFunc.wait(2);

        WebElement registerbutton2= driver.findElement(By.id("register-button"));
        MyFunc.isDisplayed(registerbutton2,"Registerbutton2");
        MyFunc.isEnabled(registerbutton2,"Registerbutton2");
        registerbutton2.click();

        MyFunc.wait(3);
        driver.quit();

    }
}