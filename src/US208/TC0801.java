package US208;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TC0801 extends BaseDriver {
    @Test
    public void Test1()
    {
        driver.get("https://demowebshop.tricentis.com/");
        Actions aksiyonlar = new Actions(driver);
        MyFunc.wait(1);

        WebElement login = driver.findElement(By.xpath("//a[text()='Log in']"));
        login.click();
        MyFunc.wait(1);

        WebElement eMail = driver.findElement(By.id("Email"));
        eMail.click(); eMail.sendKeys("engndlhsn@gmail.com");
        MyFunc.wait(1);

        WebElement passWord = driver.findElement(By.id("Password"));
        passWord.click(); passWord.sendKeys("123456789");
        MyFunc.wait(2);

        WebElement loginButton = driver.findElement(By.cssSelector("[type='submit'][value='Log in']"));
        loginButton.click();
        MyFunc.wait(2);

        WebElement computers = driver.findElement(By.cssSelector("ul[class='top-menu']> :nth-child(2)"));
        aksiyonlar.moveToElement(computers).build().perform();
        MyFunc.wait(2);

        WebElement nooteBoks = driver.findElement(By.xpath("(//a[contains(@href,'/notebooks')])[1]"));
        nooteBoks.click();
        MyFunc.wait(2);

        WebElement addCart = driver.findElement(By.cssSelector("[type='button'][value='Add to cart']"));
        addCart.click();
        MyFunc.wait(3);

        WebElement shoppingCart = driver.findElement(By.xpath("(//*[text()='Shopping cart'])[1]"));
        shoppingCart.click();
        MyFunc.wait(2);

        WebElement applyCouponBox = driver.findElement(By.xpath("//input[@name='discountcouponcode']"));
        aksiyonlar.moveToElement(applyCouponBox)
                .click()
                .sendKeys("LORD")
                .build()
                .perform();
        MyFunc.wait(2);

        WebElement appCoupButton = driver.findElement(By.xpath("//input[@name='applydiscountcouponcode']"));
        appCoupButton.click();
        MyFunc.wait(2);

        // Olumsuz Kupon Mesajı locater bulma, doğrulama ve yazdırma
        WebElement couponMessage = driver.findElement(By.xpath("//div[@class='message']"));
        Assert.assertTrue(couponMessage.getText().contains("The coupon code you entered couldn't be applied to your order"));
        System.out.println("couponMessage.getText() = " + couponMessage.getText());
        MyFunc.wait(2);

        WebElement addGiftCardBox = driver.findElement(By.xpath("//input[@name='giftcardcouponcode']"));
        aksiyonlar.moveToElement(addGiftCardBox)
                .click()
                .sendKeys("CoffeeShop")
                .build()
                .perform();
        MyFunc.wait(2);

        WebElement adGiCaButton = driver.findElement(By.xpath("//input[@name='applygiftcardcouponcode']"));
        adGiCaButton.click();
        MyFunc.wait(2);

        // Olumsuz Gift Card Mesajı locater bulma, doğrulama ve yazdırma
        WebElement giftCardMessage = driver.findElement(By.cssSelector("[class='message']"));
        Assert.assertTrue(giftCardMessage.getText().contains("The coupon code you entered couldn't be applied to your order"));
        System.out.println("giftCardMessage.getText() = " + giftCardMessage.getText());
        MyFunc.wait(2);

        WebElement selectCountry = driver.findElement(By.xpath("//select[@id='CountryId']"));
        Select choose = new Select(selectCountry);
        choose.selectByVisibleText("Thailand");


        // Kullanıcın daha önceden başka bir posta kodu girme ihtimaline karşılık
        // kutucuğu temizleyip yeni posta kodu ekleme
        // yani ben kodu yazarke bu nokta da böyle bir problemle karşılatım
        // daha önce posta kodu girdiğim için yeni kodu silmeden yanına ekliyordu ben de böyle bir çözüm buldum
        // son kullanıcının yapacağı gibi
        WebElement clear = driver.findElement(By.xpath("//input[@id='ZipPostalCode']"));
        clear.click(); clear.clear();
        MyFunc.wait(2);

        WebElement postalCode = driver.findElement(By.xpath("//input[@id='ZipPostalCode']"));
        postalCode.click(); postalCode.sendKeys("1903");
        MyFunc.wait(2);

        WebElement termAcceptButton = driver.findElement(By.cssSelector("[id='termsofservice']"));
        termAcceptButton.click();
        MyFunc.wait(2);

        WebElement chechOutButton = driver.findElement(By.cssSelector("[id='checkout']"));
        chechOutButton.click();
        MyFunc.wait(2);

        // Kullanıcının daha önce adres oluşturmuş olma seçeneğine karşılık
        // Yeni adres ekleme
        WebElement selectNewAdress = driver.findElement(By.xpath("//*[@id='billing-address-select']"));
        Select newAddress = new Select(selectNewAdress);
        newAddress.selectByIndex(1);
        MyFunc.wait(2);

        WebElement selectCountryy = driver.findElement(By.xpath("//*[@id='BillingNewAddress_CountryId']"));
        Select CountrySelect = new Select(selectCountryy);
        CountrySelect.selectByVisibleText("Thailand");
        MyFunc.wait(2);

        WebElement city = driver.findElement(By.xpath("//*[@id='BillingNewAddress_City']"));
        aksiyonlar.moveToElement(city)
                .click()
                .sendKeys("Pattaya")
                .build()
                .perform();
        MyFunc.wait(2);

        WebElement address1 = driver.findElement(By.xpath("//*[@id='BillingNewAddress_Address1']"));
        aksiyonlar.moveToElement(address1)
                .click()
                .sendKeys("Walking Street")
                .build()
                .perform();
        MyFunc.wait(2);

        WebElement postalCode2 = driver.findElement(By.xpath("//*[@id='BillingNewAddress_ZipPostalCode']"));
        aksiyonlar.moveToElement(postalCode2)
                .click()
                .sendKeys("1903")
                .build()
                .perform();
        MyFunc.wait(2);

        WebElement phoneNumber = driver.findElement(By.xpath("//*[@id='BillingNewAddress_PhoneNumber']"));
        aksiyonlar.moveToElement(phoneNumber)
                .click()
                .sendKeys("+90 553 779 2453")
                .build()
                .perform();
        MyFunc.wait(2);

        // Peş peşe seçim olmadan yapılan Continue adımları
        WebElement continueButton = driver.findElement(By.xpath("//*[@id='billing-buttons-container']/input"));
        continueButton.click();
        MyFunc.wait(2);
        WebElement continueButton2 = driver.findElement(By.xpath("//*[@id='shipping-buttons-container']/input"));
        continueButton2.click();
        MyFunc.wait(2);

        // Tüm Shipping Metodların Kontrolü
        WebElement GroundMethod = driver.findElement(By.xpath("//*[@id='shippingoption_0']"));
        GroundMethod.click();
        MyFunc.wait(2);
        WebElement nextDayAitMetdoh = driver.findElement(By.xpath("//*[@id='shippingoption_1']"));
        nextDayAitMetdoh.click();
        MyFunc.wait(2);
        WebElement ndDayAirMethod = driver.findElement(By.xpath("//*[@id='shippingoption_2']"));
        ndDayAirMethod.click();
        MyFunc.wait(2);

        // Shipping Method seç ve devam et
        WebElement selectShippingMethod = driver.findElement(By.xpath("//*[@id='shippingoption_0']"));
        selectShippingMethod.click();
        MyFunc.wait(2);
        WebElement Continue3 = driver.findElement(By.xpath("//*[@id='shipping-method-buttons-container']/input"));
        Continue3.click();
        MyFunc.wait(2);

        // Tüm Payment Metodların kontrolü
        WebElement cashMethod = driver.findElement(By.xpath("//*[@id='paymentmethod_0']"));
        cashMethod.click();
        MyFunc.wait(2);
        WebElement checkMethod = driver.findElement(By.xpath("//*[@id='paymentmethod_1']"));
        checkMethod.click();
        MyFunc.wait(2);
        WebElement creditMethod = driver.findElement(By.xpath("//*[@id='paymentmethod_2']"));
        creditMethod.click();
        MyFunc.wait(2);
        WebElement purchaseMethod = driver.findElement(By.xpath("//*[@id='paymentmethod_3']"));
        purchaseMethod.click();
        MyFunc.wait(2);

        // Payment Method seç ve devam et
        WebElement selectPaymentMethod = driver.findElement(By.xpath("//*[@id='paymentmethod_0']"));
        selectPaymentMethod.click();
        MyFunc.wait(2);
        WebElement ContinueButton4 = driver.findElement(By.xpath("//*[@id='payment-method-buttons-container']/input"));
        ContinueButton4.click();
        MyFunc.wait(2);

        WebElement payInforContinue = driver.findElement(By.xpath("//*[@id='payment-info-buttons-container']/input"));
        payInforContinue.click();
        MyFunc.wait(2);

        WebElement confirmbutton = driver.findElement(By.xpath("//*[@id='confirm-order-buttons-container']/input"));
        confirmbutton.click();
        MyFunc.wait(2);

        WebElement succesMessage = driver.findElement(By.xpath("//strong[text()='Your order has been successfully processed!']"));
        Assert.assertTrue(succesMessage.getText().contains("Your order has been successfully processed!"));
        System.out.println("succesMessage.getText() = " + succesMessage.getText());

        tearDown();
    }
}
