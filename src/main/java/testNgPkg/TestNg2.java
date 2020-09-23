package testNgPkg;

import org.testng.annotations.Test;

public class TestNg2 {

    @Test(description = "This is TestA")
    public void a(){
        System.out.println("testA");
    }

    @Test(priority = 2)
    public void c(){
        System.out.println("testC");
    }

    @Test
    public void b(){
        System.out.println("testB");
    }
    @Test(priority = -12)
    public void d(){
        System.out.println("testD");
    }



}
