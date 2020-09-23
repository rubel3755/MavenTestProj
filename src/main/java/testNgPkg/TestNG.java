package testNgPkg;


import org.testng.annotations.*;

public class TestNG {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("beforeSuite");

    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("beforeTest");

    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("beforeClass");

    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("beforeMethod");

    }



    @Test
    public void testA(){
        System.out.println("testA");

    }

    @Test
    public void testB(){
        System.out.println("testB");

    }

    @Test
    public void testC(){
        System.out.println("testC");

    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("afterMethod");

    }
    @AfterClass
    public void afterClass(){
        System.out.println("afterClass");

    }
    @AfterTest
    public void afterTest(){
        System.out.println("afterTest");

    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("afterSuite");

    }



}
