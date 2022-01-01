package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Automation extends DriverSetup{

    public static String base_url = "http://automationpractice.com/index.php";


    @Test
    public static void runBrowser() throws InterruptedException {
        driver.get(base_url);
        driver.manage().window().maximize();
        Thread.sleep(2000);

        //Title Verification

        String siteTitle = "My Store";
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);

        Assert.assertEquals(actualTitle,siteTitle);

        //Login

        driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();

        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("shoronsrs@gmail.com");
        driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("demo1234");

        driver.findElement(By.id("SubmitLogin")).click();
        Thread.sleep(2000);

        //ProductSelect
        WebElement womanDress = driver.findElement(By.xpath("//a[@title='Women']"));

        Actions action = new Actions(driver);
        action.clickAndHold(womanDress).build().perform();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[6]/ul[1]/li[1]/ul[1]/li[1]/ul[1]/li[1]/a[1]")).click();
        Thread.sleep(1000);


        WebElement preview = driver.findElement(By.xpath("//body/div[@id='page']/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(preview).build().perform();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//span[contains(text(),'More')]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//i[@class='icon-plus']")).click();
        Thread.sleep(1000);

        Select dressSize = new Select(driver.findElement(By.name("group_1")));
        dressSize.selectByValue("2");
        Thread.sleep(1000);

//        driver.findElement(By.xpath(" //a[@id='wishlist_button']")).click();
//        Thread.sleep(1000);

        driver.findElement(By.xpath("//span[contains(text(),'Add to cart')]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//a[contains(@title,'Proceed to checkout')]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//a[@class='button btn btn-default standard-checkout button-medium']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//button[@name='processAddress']//span[contains(text(),'Proceed to checkout')]")).click();
        Thread.sleep(1000);

        WebElement checkCondition = driver.findElement(By.id("cgv"));
        checkCondition.click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//button[@name='processCarrier']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[contains(.,'Pay by bank wire (order processing will be longer)')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@class='button btn btn-default button-medium']")).click();
        Thread.sleep(1000);

        String actualOrder = "Order confirmation";
        String confirmOrder = driver.findElement(By.xpath("//h1[contains(text(),'Order confirmation')]")).getText();

        Assert.assertEquals(actualOrder,confirmOrder);
        System.out.println("Oder Confirmed Validate");

        driver.findElement(By.xpath("//a[normalize-space()='Back to orders']")).click();

        Thread.sleep(2000);



//        //Logout and validation

        String userName = driver.findElement(By.xpath("//span[contains(text(),'Apocalyse Bear')]")).getText();
        String userNameShowing = "Apocalyse Bear";
        System.out.println(userName);

        Assert.assertEquals(userName,userNameShowing);

        driver.findElement(By.xpath("//a[@class='logout']")).click();
        Thread.sleep(2000);




//        //Registration

        driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();

        driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys("shoronsrs@gmail.com");

        driver.findElement(By.xpath("//button[@name='SubmitCreate']")).click();
        Thread.sleep(2000);

        WebElement radioBtn = driver.findElement(By.id("id_gender2"));
        radioBtn.click();

        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys("Apocalyse");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='customer_lastname']")).sendKeys("Bear");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("demo1234");
        Thread.sleep(1000);

        Select dateBirth = new Select(driver.findElement(By.name("days")));
        dateBirth.selectByValue("1");
        Thread.sleep(1000);

        Select dateMonth = new Select(driver.findElement(By.name("months")));
        dateMonth.selectByValue("1");
        Thread.sleep(1000);

        Select dateYear = new Select(driver.findElement(By.name("years")));
        dateYear.selectByValue("1996");
        Thread.sleep(1000);

        WebElement chkBox = driver.findElement(By.xpath("//input[@id='newsletter']"));
        chkBox.click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("Apocalyse");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("Bear");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='company']")).sendKeys("ABC Incorporation");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("Dhaka 1213, Bangladesh");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='address2']")).sendKeys("House 12");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Dhaka");
        Thread.sleep(1000);

        Select state = new Select(driver.findElement(By.name("id_state")));
        state.selectByValue("1");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys("00001");
        Thread.sleep(1000);

        Select country = new Select(driver.findElement(By.name("id_country")));
        country.selectByValue("21");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@id='phone_mobile']")).sendKeys("011234567");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='alias']")).sendKeys("Assign an address");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//button[@name='submitAccount']")).click();
        Thread.sleep(5000);

    }
}

