package US205;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC0501 extends BaseDriver {
    @Test
    public void test() {
        driver.get("https://demowebshop.tricentis.com");
        MyFunc.wait(2);

        WebElement login = driver.findElement(By.xpath("//*[text()='Log in']"));
        login.click();

        // 1.Adım
        WebElement email = driver.findElement(By.name("Email"));
        email.sendKeys(" ");
        MyFunc.wait(1);

        WebElement password = driver.findElement(By.id("Password"));
        password.sendKeys(" ");
        MyFunc.wait(1);

        WebElement btnLogin = driver.findElement(By.cssSelector("[type=\"submit\"][value=\"Log in\"]"));
        btnLogin.click();
        MyFunc.wait(1);

        WebElement text = driver.findElement(By.xpath("//*[contains( text(), 'Login was')]"));
        Assert.assertTrue("giriş yapıldı", text.getText().contains("Login was unsuccessful"));
        System.out.println("text.getText() = " + text.getText());

        tearDown();
    }

    @Test
    public void test2() {

        //2.Adım
        driver.get("https://demowebshop.tricentis.com");
        MyFunc.wait(2);

        WebElement login2 = driver.findElement(By.xpath("//*[text()='Log in']"));
        login2.click();

        WebElement email2 = driver.findElement(By.cssSelector("[id*=\"Email\"]"));
        email2.sendKeys("team9grup@abc.com");
        MyFunc.wait(1);

        WebElement password2 = driver.findElement(By.id("Password"));
        password2.sendKeys(" ");
        MyFunc.wait(1);

        WebElement btnLogin2 = driver.findElement(By.cssSelector("[type=\"submit\"][value=\"Log in\"]"));
        btnLogin2.click();
        MyFunc.wait(1);

        WebElement text2 = driver.findElement(By.xpath("//*[contains( text(), 'The credentials provided')]"));
        Assert.assertTrue("giriş yapıldı", text2.getText().contains("The credentials provided are incorrect"));
        System.out.println("text.getText() = " + text2.getText());

        tearDown();
    }

    @Test
    public void test3() {
        driver.get("https://demowebshop.tricentis.com");
        MyFunc.wait(2);

        WebElement login3 = driver.findElement(By.xpath("//*[text()='Log in']"));
        login3.click();

        WebElement email3= driver.findElement(By.name("Email"));
        email3.sendKeys(" ");
        MyFunc.wait(1);

        WebElement password3 = driver.findElement(By.id("Password"));
        password3.sendKeys("team9grup");
        MyFunc.wait(1);

        WebElement btnLogin3 = driver.findElement(By.cssSelector("[type=\"submit\"][value=\"Log in\"]"));
        btnLogin3.click();
        MyFunc.wait(1);

        WebElement text3 = driver.findElement(By.xpath("//*[contains( text(), 'No customer')]"));
        Assert.assertTrue("giriş yapıldı", text3.getText().contains("No customer account found"));
        System.out.println("text.getText() = " + text3.getText());

        tearDown();

    }
@Test
    public void test4()
{
    driver.get("https://demowebshop.tricentis.com");
    MyFunc.wait(2);

    WebElement login4 = driver.findElement(By.xpath("//*[text()='Log in']"));
    login4.click();

    WebElement email4 = driver.findElement(By.id("Email"));
    email4.sendKeys("invalidemail@gmail.com");
    MyFunc.wait(1);

    WebElement password4 = driver.findElement(By.name("Password"));
    password4.sendKeys("invalidPassword");
    MyFunc.wait(1);

    WebElement btnLogin4 = driver.findElement(By.cssSelector("[type=\"submit\"][value=\"Log in\"]"));
    btnLogin4.click();
    MyFunc.wait(1);

    WebElement text4 = driver.findElement(By.xpath("//*[contains( text(), 'Login was')]"));
    Assert.assertTrue("giriş yapıldı", text4.getText().contains("Login was unsuccessful. " +
            "Please correct the errors and try again"));
    System.out.println("text.getText() = " + text4.getText());

    tearDown();
}

}

