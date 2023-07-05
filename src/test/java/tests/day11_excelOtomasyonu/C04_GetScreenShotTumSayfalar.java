package tests.day11_excelOtomasyonu;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C04_GetScreenShotTumSayfalar extends TestBase {



    @Test
    public void test01() throws IOException {
        //Amazon anasayfaya gidin

        driver.get("https://www.amazon.com");

        //nutella için arama yaptırın


        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        //Sonuclarin nutella icerdigini test edin


        WebElement sonucElementi= driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));

        String expectedicerik="Nutella";
        String actualSonucYazisi= sonucElementi.getText();

        //Tum sayfa fotoğrafını cekmek icin 4 adıma ihtiyac var

        //1.adim driverı TakeScreenshot objesine cast edelim

        TakesScreenshot tss= (TakesScreenshot) driver;

        //2. adim ekran resminin kaydedilecegi bir file olusturalim

        File tumSayfaSs=new File("target/ekranScreenshot/tumsayfaSS.png");

        //3. adim tss objesini kullanarak screenshot alalim ve gecici bir dosyaya kaydedelim

        File geciciDosya=tss.getScreenshotAs(OutputType.FILE);

        //4. adim gecici dosyayı olusturdugumuz tumsayfaSS e kopyalayalım

        FileUtils.copyFile(geciciDosya,tumSayfaSs);

        Assert.assertTrue(actualSonucYazisi.contains(expectedicerik));








    }


}
