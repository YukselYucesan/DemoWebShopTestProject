package US209;

import TestData._01_UserTestData;
import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC0901 extends BaseDriver {
    @Test
    public void Test1(){
        // Chrome tarayıcısından Siteye ulaşma.
        driver.get("https://demowebshop.tricentis.com/");
        MyFunc.wait(1);

        // Login buttonuna tıklama
        WebElement loginButton= driver.findElement(By.xpath("//a[@class='ico-login']"));
        loginButton.click();
        MyFunc.wait(1);

        // Email adresi girme
        WebElement email= driver.findElement(By.xpath("//input[@autofocus='autofocus']"));
        email.sendKeys(_01_UserTestData.eMail);
        MyFunc.wait(1);

        // Şifre adresi girme
        WebElement password= driver.findElement(By.xpath("//input[@name='Password']"));
        password.sendKeys(_01_UserTestData.password);
        MyFunc.wait(1);

        // Giriş Yapma
        WebElement girisButton= driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        girisButton.click();
        MyFunc.wait(1);

        // Hesap ismine tıklama
        WebElement account= driver.findElement(By.xpath("(//a[@class='account'])[1]"));
        account.click();
        MyFunc.wait(1);

        // Siparişlerime tıklama
        WebElement orders= driver.findElement(By.xpath("(//a[@class='inactive'])[2]"));
        orders.click();
        MyFunc.wait(1);

        // detaylara tıklama
        WebElement details= driver.findElement(By.xpath("//input[@class='button-2 order-details-button']"));
        details.click();
        MyFunc.wait(1);

        // PDF olarak indirme
        WebElement pdf=driver.findElement(By.xpath("//a[@class='button-2 pdf-order-button']"));
        pdf.click();

        tearDown();
    }
}
