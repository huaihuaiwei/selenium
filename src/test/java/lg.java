import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.*;

public class lg {
    public void test05() throws ClassNotFoundException, SQLException, InterruptedException {
        String driverClassName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://192.168.29.131:3306/store";
        String username = "root";
        String password = "123456";
        Class.forName(driverClassName);
        Connection con = DriverManager.getConnection(url, username, password);
        Statement stmt = con.createStatement();
        String sql = "select * from pwd " ;
        ResultSet rs = stmt.executeQuery(sql);
        System.out.println(rs);
        while (rs.next()) {
            String uname= rs.getString("uname");
            String pd = rs.getString("pd");
            lg lg1=new lg();
            lg1.login1(uname,pd);
            System.out.println(uname + " " + pd);
        }
    }
    public void login1(String uname,String pd) throws InterruptedException {//定义形参功能
        WebDriver webdriver=null;
        try {//扑获异常，防止程序崩溃
            System.setProperty("webdriver.chrome.driver","C:\\Python27\\chromedriver.exe");
            webdriver= new ChromeDriver();//启用谷歌浏览器
            webdriver.get("http://192.168.29.131:8080/DagShop06/");//打开网址
            String title=webdriver.getTitle();//检测
            Assert.assertEquals(title,"WEB01"); //检验
            WebElement webElement = webdriver.findElement(By.xpath("/html/body/div/div[1]/div[3]/ol/li[1]/a"));
            webElement.click();
            Thread.sleep(5000);//休眠
            WebElement a =webdriver.findElement(By.id("username"));
            a.sendKeys(uname);
            Thread.sleep(3000);
            WebElement b =webdriver.findElement(By.id("inputPassword3"));
            b.sendKeys(pd);
            WebElement cl=webdriver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/form/div[5]/div/input"));
            cl.click();
            Thread.sleep(3000);
            WebElement tc =webdriver.findElement(By.xpath("/html/body/div/div[1]/div[3]/ol/li[2]/a"));
            boolean jy =tc.isDisplayed();
            Assert.assertTrue(jy);
            Thread.sleep(2000);
            webdriver.close();

        } catch (Exception E){
             webdriver.close();
             System.out.println("登录失败");
        }
    }
    @Test
    public void login02(){
        lg dl=new lg();
        try {////扑获异常，防止程序崩溃
            dl.test05();
        } catch (Exception B){
            System.out.println("当前登录错误");
        }

    }

}
