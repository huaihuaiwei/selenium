import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.*;

public class regist {

    public void regist1(String uname,String pd,String pd_,String email,String cname,String sex,String date_ )throws
            InterruptedException{
        WebDriver webdriver=null;
         try {
           webdriver= new ChromeDriver();
             webdriver.get("http://192.168.29.131:8080/DagShop06/");
             String title=webdriver.getTitle();//检测
             Assert.assertEquals(title,"WEB01");
             WebElement registclik =webdriver.findElement(By.xpath("/html/body/div/div[1]/div[3]/ol/li[2]/a"));
             registclik.click();
             Thread.sleep(2000);
             WebElement usr=webdriver.findElement(By.id("username"));
             usr.sendKeys(uname);
             WebElement password=webdriver.findElement(By.id("inputPassword3"));
             password.sendKeys(pd);
             WebElement password1=webdriver.findElement(By.id("confirmpwd"));
             password1.sendKeys(pd_);
             WebElement email1=webdriver.findElement(By.id("inputEmail3"));
             email1.sendKeys(email);
             WebElement name=webdriver.findElement(By.id("usercaption"));
             name.sendKeys(cname);
             //equals:比较是否相等,==用于比较数字是否相等,也能用于字符串等其他类是否相等,但要求地址一致
             //sex=
             if (sex.equals("1")){
                 WebElement sex1=webdriver.findElement(By.id("inlineRadio1"));
                 sex1.click();
             }else {
                 WebElement sex2=webdriver.findElement(By.id("inlineRadio2"));
                 sex2.click();
             }
             Thread.sleep(2000);
             WebElement date=webdriver.findElement(By.xpath("//*[@id=\"ename\"]"));
             JavascriptExecutor js=(JavascriptExecutor)webdriver;
             String JSS="arguments[0].value="+"'"+date_+"';";
             js.executeScript(JSS,date);//date:被赋值的标签对象
             System.out.println(JSS);
             Thread.sleep(2000);
             WebElement ZH=webdriver.findElement(By.name("submit"));
             ZH.click();
             WebElement QC=webdriver.findElement(By.xpath("/html/body/div[1]/div[3]/h3"));
             boolean Q=QC.isDisplayed();
             Assert.assertTrue(Q);
             webdriver.close();

         }catch (Exception E){
             System.out.println("注册失败");
         }

    }
    public void test05() throws ClassNotFoundException, SQLException, InterruptedException {
        String driverClassName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://192.168.29.131:3306/store";
        String username = "root";
        String password = "123456";
        Class.forName(driverClassName);
        Connection con = DriverManager.getConnection(url, username, password);
        Statement stmt = con.createStatement();
        String sql = "select * from rg " ;
        ResultSet rs = stmt.executeQuery(sql);
        System.out.println(rs);
        while (rs.next()) {
            String uname= rs.getString("uname");
            String pd = rs.getString("pd");
            String pd_ = rs.getString("pd_");
            String email= rs.getString("email");
            String cname= rs.getString("cname");
            String sex= rs.getString("sex");
            String date_= rs.getString("date_");
            regist lg1=new regist ();
            lg1.regist1(uname,pd,pd_,email,cname,sex,date_);
            System.out.println(uname + " " + pd+""+pd_+""+email+""+cname+""+sex+""+date_);
        }
    }
@Test
    public void regist02(){
        regist lg1=new regist();
        try {
            lg1.test05();

        }catch (Exception E){
            System.out.println("注册失败");
        }
    }
}
