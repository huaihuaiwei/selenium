import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class login {
    @Test
    public void login1() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Python27\\chromedriver.exe");
        WebDriver webdriver= new ChromeDriver();//启用谷歌浏览器
        webdriver.get("http://192.168.29.131:8080/DagShop06/");//打开网址
        String title=webdriver.getTitle();//检测
        Assert.assertEquals(title,"WEB01"); //检验
        WebElement webElement = webdriver.findElement(By.xpath("/html/body/div/div[1]/div[3]/ol/li[1]/a"));
        webElement.click();
        Thread.sleep(5000);//休眠
        WebElement a =webdriver.findElement(By.id("username"));
        a.sendKeys("aaa");
        Thread.sleep(3000);
        WebElement b =webdriver.findElement(By.id("inputPassword3"));
        b.sendKeys("aaa");
        WebElement cl=webdriver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/form/div[5]/div/input"));
        cl.click();
        Thread.sleep(3000);
        WebElement tc =webdriver.findElement(By.xpath("/html/body/div/div[1]/div[3]/ol/li[2]/a"));
        boolean jy =tc.isDisplayed();
        Assert.assertTrue(jy);
        Thread.sleep(2000);

    }

    @Test
    public void regist()throws InterruptedException{
        System.setProperty("webdriver.chrome.driver","C:\\Python27\\chromedriver.exe");
        WebDriver webdriver= new ChromeDriver();
        webdriver.get("http://192.168.29.131:8080/DagShop06/");
        String title=webdriver.getTitle();//检测
        Assert.assertEquals(title,"WEB01");
        WebElement registclik =webdriver.findElement(By.xpath("/html/body/div/div[1]/div[3]/ol/li[2]/a"));
        registclik.click();
        Thread.sleep(2000);
        WebElement usr=webdriver.findElement(By.id("username"));
        usr.sendKeys("jjj");
        WebElement password=webdriver.findElement(By.id("inputPassword3"));
        password.sendKeys("123456");
        WebElement password1=webdriver.findElement(By.id("confirmpwd"));
        password1.sendKeys("123456");
        WebElement email=webdriver.findElement(By.id("inputEmail3"));
        email.sendKeys("163@qq.com");
        WebElement name=webdriver.findElement(By.id("usercaption"));
        name.sendKeys("笙");
        WebElement sex=webdriver.findElement(By.id("usercaption"));
        sex.click();
        Thread.sleep(2000);
        WebElement date=webdriver.findElement(By.xpath("//*[@id=\"ename\"]"));
        JavascriptExecutor js=(JavascriptExecutor)webdriver;
        js.executeScript("arguments[0].value='2016-11-18';",date);
        WebElement ZH=webdriver.findElement(By.name("submit"));
        ZH.click();
        WebElement QC=webdriver.findElement(By.xpath("/html/body/div[1]/div[3]/h3"));
        boolean Q=QC.isDisplayed();
        Assert.assertTrue(Q);
    }

}
