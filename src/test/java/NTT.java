import com.google.common.io.Files;
import com.opencsv.CSVReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.ui.Select;

import javax.swing.table.TableRowSorter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystem;

public class NTT {
    public static <File> void main(String[] args) throws InterruptedException, IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/"); // Demoqa.com adresine girer
        driver.manage().window().maximize();  // Sayfayı tam ekran yapar

        JavascriptExecutor jsx = (JavascriptExecutor) driver; //Sayfayı aşağı doğru kaydırır
        jsx.executeScript("window.scrollBy(0,500)","");

        WebElement FormButton= driver.findElement(By.xpath("//div[@class='home-body']//div[2]//div[1]//div[3]"));
        FormButton.click();   // Forms yerini bulur ve tıklar. Xpath göre çekildi.

        WebElement praticeform = driver.findElement(By.xpath("//span[normalize-space()='Practice Form']"));
        praticeform.click(); // PraticeForm'u bulur ve tıklar. Xpath'e göre çekildi.

       //CSVReader readcsv = new CSVReader(new FileReader(“Data/nttcsv.xlsx”));
        //firstname.sendKeys(readcsv.readNext([0]));


        WebElement firstname = driver.findElement(By.xpath("//input[@id='firstName']"));
        firstname.click(); // firstname'i bulur , tıklar ve Ahmet yazısını yazar.
        firstname.sendKeys("Ahmet");

        WebElement lastname = driver.findElement(By.cssSelector("#lastName"));
        lastname.click(); // lastname bulur, tıklar ve Yüce yazısını yazar. cssSelector göre çekildi.
        lastname.sendKeys("Yüce");

        WebElement email = driver.findElement(By.cssSelector("#userEmail"));
        email.click(); // email bulur, tıklar ve aşağıdaki adresi girer.
        email.sendKeys("yuceahmettt@gmail.com");

        WebElement Gender = driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
        Gender.click(); // Cinsiyeti bulur ve erkek tıklar

        JavascriptExecutor jsx2 = (JavascriptExecutor) driver;
        jsx2.executeScript("window.scrollBy(0,500)"); // sayfayı aşağı kaydırır

        WebElement mobileNumber = driver.findElement(By.xpath("//input[@id='userNumber']"));
        mobileNumber.click(); // MobileNumber bulur, tıklar ve numarayı atar.
        mobileNumber.sendKeys("5436071097");


        WebElement dateofBirth = driver.findElement(By.xpath("//input[@id='dateOfBirthInput']"));
        dateofBirth.click(); // dateofbirth kutusuna tıklar

        WebElement month = driver.findElement(By.className("react-datepicker__month-select")); // Ayların olduğu yere gider

        Select select= new Select(month);
        select.selectByIndex(1); // index nosu 1 olanı seçer

        WebElement year=driver.findElement(By.className("react-datepicker__year-select"));
        Select select2= new Select(year);
        select2.selectByVisibleText("1998"); // yıl kısmına gider ve 1998 olanı seçer

        WebElement day = driver.findElement(By.xpath("//div[@aria-label='Choose Friday, February 27th, 1998']"));
        day.click(); // Günü 27 olanı seçer

        WebElement hobbies = driver.findElement(By.xpath("//label[@for='hobbies-checkbox-2']"));
        hobbies.click(); // hobiler kısmında 2. kutucuğa tıklar

        WebElement currentAdress = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        currentAdress.click();
        currentAdress.sendKeys("İstanbul");  // Adres kutusuna tıkladı ve İstanbul yazısı yazdırıldı.

        //WebElement subject = driver.findElement(By.xpath("//div[@class='subjects-auto-complete__value-container subjects-auto-complete__value-container--is-multi css-1hwfws3']"));
        //subject.sendKeys("E"); // English seçeneği için dropdown'dan gelecek ilk seçeneği seçtirecek
        //driver.findElement(By.className("css-1rhbuit-multiValue subjects-auto-complete__multi-value")).click();// İngilizceye tıklar

        //WebElement submitButton = driver.findElement(By.id("submit"));
        // submitButton.click(); // formu submit eder

        //**Submit yorum satırı yapmamın nedeni açılan test sayfasının zoom oranından dolayı ekranda submit butonu görünmüyor.
        // Sayfada aşağı doğru scroll edilmiyor.

        Thread.sleep(5000); // 5 saniye bekler

        TakesScreenshot xx = (TakesScreenshot)driver; // ekran görüntüsü alıp screenshots dosyasına kaydeder.
        File ımage = xx.getScreenshotAs((OutputType<File>) OutputType.FILE);
        Files.move((java.io.File) ımage,new java.io.File("screenshots/ss1.png"));

        driver.quit(); // sayfayı kapatır.

        // WebElement state= driver.findElement(By.id("state")); State için çalışma yapıldı fakat kod parçacığı çalışmadı.
        // driver.findElement(By.xpath("//div[@id='react-select-3-option-0']")).click();

        // Select drpstate = new Select(driver.findElement(By.name("css-1wa3eu0-placeholder")));
        // drpstate.selectByVisibleText("NCR");












    }
}
