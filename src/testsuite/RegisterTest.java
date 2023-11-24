/*1. verifyThatSignInPageDisplay
        * click on the ‘Create an Account’ link
        * Verify the text ‘Create New Customer Account’
        2. userSholdRegisterAccountSuccessfully
        * click on the ‘Create an Account’ link
        * Enter First name
        * Enter Last name
        * Click on checkbox Sign Up for Newsletter
        * Enter Emai
        * Enter Password
        * Enter Confirm Password
        * Click on Create an Account button
        * Verify the text 'Thank you for
        registering with Main Website Store.’
        * Click on down aero neare Welcome
        * Click on Sign Out link
        * Verify the text ‘You are signed out’
        */

package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class RegisterTest extends BaseTest {

static String baseUrl = "https://magento.softwaretestingboard.com/";

        @Before
        public void setUp(){
            openBrowser(baseUrl);
        }
        @Test
        public void verifyThatSignInPageDisplay() throws InterruptedException {
            // click on the create an account link
            driver.findElement(By.linkText("Create an Account")).click();
            Thread.sleep(3000);
            // Verify the text
            String expectedText = "Create New Customer Account";
            String actualText = driver.findElement(By.xpath("//span[@class='base']")).getText();
            Assert.assertEquals(expectedText, actualText);
        }

        @Test
        public void userShouldRegisterAccountSuccessfully() throws InterruptedException {
            // click on the create an account link
            driver.findElement(By.linkText("Create an Account")).click();
            Thread.sleep(3000);

            // Enter first name
            driver.findElement(By.id("firstname")).sendKeys("Yog");
            Thread.sleep(3000);

            //Enter Last name
            driver.findElement(By.id("lastname")).sendKeys("Maya");
            Thread.sleep(3000);

            //Enter Email
            driver.findElement(By.id("email_address")).sendKeys("yogmaya@gmail.com");
            Thread.sleep(3000);

            // Enter password
            driver.findElement(By.xpath("(//input[@name='password'])[1]")).sendKeys("Yogmaya@108");
            Thread.sleep(3000);

            // Enter Confirm password
            driver.findElement(By.xpath("//input[@id='password-confirmation']")).sendKeys("Yogmaya@108");
            Thread.sleep(3000);

            //Click on Create an account button
            driver.findElement(By.xpath("//button[.='Create an Account']")).click();
            Thread.sleep(3000);

            //Verify the text
            String expectedText = "Thank you for registering with Main Website Store.";
            String actualText = driver.findElement(By.xpath("//div[.='Thank you for registering with Main Website Store.']")).getText();
            Assert.assertEquals(expectedText,actualText);

            //click on down arrow near welcome
            driver.findElement(By.xpath("(//button[@class='action switch'])[1]")).click();
            Thread.sleep(3000);

            //Click on sign out link
            driver.findElement(By.partialLinkText("Sign ")).click();
            Thread.sleep(3000);

            //Verify the text
            String expectedText1 = "You are signed out";
            String actualText1 = driver.findElement(By.xpath("//span[@class='base' and @data-ui-id='page-title-wrapper']")).getText();
            Assert.assertEquals(expectedText1, actualText1);
        }
        @After
        public void tearDown(){
            closeBrowser();
    }

}

