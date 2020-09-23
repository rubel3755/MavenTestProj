package testNgPkg;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class RetryTest {

    int i;

    @BeforeClass
    public void beforeClass(){
        System.out.println("beforeClass");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("beforeMethod");
    }


   /* @Test(retryAnalyzer = retryTestNG.RetryAnalyzer.class)
    public void testA(){
        System.out.println("testA");
        Assert.assertTrue(false);
    }*/

    @Test
    public void testA(){
        System.out.println("testA");
        Assert.assertTrue(false);
    }

    @Test
    public void testB(){
        System.out.println("testB");
    }

    @Test
    public void testC(){
        System.out.println("testC");
        System.out.println(i);
        Assert.assertEquals(i,1);
        i++;
    }

    @AfterMethod
    public void afterMethod(ITestResult result){
        System.out.println("afterMethod");

        System.out.println(result.getMethod());
        System.out.println(result.getName());
        System.out.println(result.isSuccess());
        if (!result.isSuccess()){
            System.out.println("takeScreenshot");
        }


    }
    @AfterClass
    public void afterClass(){
        System.out.println("afterClass");
    }






}
