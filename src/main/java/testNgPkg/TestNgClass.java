package testNgPkg;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.sql.*;

import static java.sql.DriverManager.getConnection;

public class TestNgClass {

    @Test
    public  void TestNgMethod() throws InterruptedException {

        System.out.println("TestNgMethod");

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\rubel\\OneDrive\\Desktop\\JavaProjects\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        Thread.sleep(5000);
        driver.quit();

    }

        @Test
        public void TestDB() throws SQLException {
            Connection conn= null;
            Statement stmt = null;
            String query="select * from [TestDB].[dbo].[Activities]";

            try {

                String dbURL = "jdbc:sqlserver://DESKTOP-EL3Q25S\\SQLEXPRESS"; //dbc:sqlserver://servername\\InstanceName
                String user = "abc";
                String pass = "abc1234";
                conn = getConnection(dbURL, user, pass);
                if (conn != null) {

                    // do all DB actions like select, insert,update
                    DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
                    System.out.println("Driver name: " + dm.getDriverName());
                    System.out.println("Driver version: " + dm.getDriverVersion());
                    System.out.println("Product name: " + dm.getDatabaseProductName());
                    System.out.println("Product version: " + dm.getDatabaseProductVersion());


                    stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(query);

                    while (rs.next()) {
                        System.out.println(rs.getString("activity_name"));
                        System.out.println(rs.getString("activity_date"));
                    }

                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    if (conn != null && !conn.isClosed()) {
                        conn.close();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }


        }

    }


