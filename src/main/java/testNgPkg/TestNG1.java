package testNgPkg;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNG1 {

    @Test(enabled= false)
    public void a(){
        System.out.println("testA");
    }

    @Test(alwaysRun= true)
    public void a1(){
        System.out.println("testA1");
    }

    @Test(timeOut = 1000)
    public void c() throws InterruptedException {
        System.out.println("testC");
        Thread.sleep(2000);
    }

    @Test
    public void b(){
        System.out.println("testB");
        Assert.assertTrue(false);
    }

    @Test(dependsOnMethods = "b")
    public void d(){
        System.out.println("testD");
    }

    @Test
    public void e(){
        System.out.println("testE");
    }

    @Test
    public void hardAssert(){
        System.out.println("testE1");
        System.out.println("testE2");

        Assert.assertTrue(false, "Value is not true");
        Assert.assertEquals("a", "a");
        System.out.println("testE3");
    }


    @Test
    public void softAssert(){
        System.out.println("testE1");
        System.out.println("testE2");
        SoftAssert softAssert=  new SoftAssert();
        softAssert.assertTrue(false);
        softAssert.assertEquals("a", "a");
        System.out.println("testE3");
        softAssert.assertAll();
    }

    //@Test
    //@Parameters({"user", "pass"})
    public void login(String username, String password){
        System.out.println("Username is: "+ username);
        System.out.println("Password is: "+ password);
    }


    @Test(dataProvider = "dataProvider")
    public void login1(String username, String password){
        System.out.println("Username is: "+ username);
        System.out.println("Password is: "+ password);
    }

    @DataProvider
    public Object[][] dataProvider(){

        Object[][] data = new Object[3][2];

        // 1st row
        data[0][0] ="abc1";
        data[0][1] = "pass1";

        // 2nd row
        data[1][0] ="abc2";
        data[1][1] = "pass2";

        // 3rd row
        data[2][0] ="abc3";
        data[2][1] = "pass3";

        return  data;

    }





}
