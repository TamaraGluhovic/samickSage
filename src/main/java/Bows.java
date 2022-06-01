import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Bows {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tamara\\IdeaProjects\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));


        driver.navigate().to("http://www.strela.co.rs/");
        String expectedUrl = driver.getCurrentUrl();

        if (expectedUrl.equals("http://www.strela.co.rs/")) {
            System.out.println("URL is the same");
        } else {
            System.out.println("URL is not the same");
        }

        WebElement chooseOptionBows = driver.findElement(By.xpath("//*[@id=\"ctl00_RadMenu1\"]/ul/li[2]/a/span/strong"));
        chooseOptionBows.click();

        WebElement findSamickSageBow = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_GrupeRadTreeView\"]/ul/li[1]/div/span[3]"));
        findSamickSageBow.click();

        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"ctl00_MainContent_ListView1_ctrl35_Panel1\"]/figure/a/img")));

        WebElement clickSamickSage = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_ListView1_ctrl35_Panel1\"]/figure/a/img"));
        clickSamickSage.click();

        String title = driver.findElement(By.id("ctl00_MainContent_ItemListView_ctrl0_ItemNazivLabel")).getText();

        if (title.contains("Samick")) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
        driver.close();
    }
}
