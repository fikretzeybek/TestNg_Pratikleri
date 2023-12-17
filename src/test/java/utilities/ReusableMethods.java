package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class ReusableMethods {
    //========Returns the Text of the element given an element locator==//
    public static List<String> getElementsText(By locator) {
        List<WebElement> elems = Driver.getDriver().findElements(locator);
        List<String> elemTexts = new ArrayList<>();
        for (WebElement el : elems) {
            if (!el.getText().isEmpty()) {
                elemTexts.add(el.getText());
            }
        }
        return elemTexts;
    }




    //===============Explicit Wait==============//
    public static WebElement waitForVisibility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement waitForClickablility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void clickWithTimeOut(WebElement element, int timeout) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.click();
                return;
            } catch (WebDriverException e) {
                bekle(1);
            }
        }
    }

    public static void waitForPageToLoad(long timeout) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            System.out.println("Waiting for page to load...");
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
            wait.until(expectation);
        } catch (Throwable error) {
            System.out.println(
                    "Timeout waiting for Page Load Request to complete after " + timeout + " seconds");
        }
    }

    //========Hover Over=====//
    public static void hover(WebElement element) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();
    }

    //==========Return a list of string given a list of Web Element====////
    public static List<String> stringListeDonustur(List<WebElement> elementlerListesi) {
        List<String> stringlerListesi = new ArrayList<>();
        for (WebElement each : elementlerListesi
        ) {
            stringlerListesi.add(each.getText());
        }
        return stringlerListesi;
    }
    //   HARD WAIT WITH THREAD.SLEEP
    public static void bekle(int saniye) {
        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //========Switching Window=====//
    public static void titleIleSayfaDegistir(String hedefSayfaTitle) {
        Set<String> tumWhdSeti = Driver.getDriver().getWindowHandles();
        for (String each : tumWhdSeti
        ) {
            String eachTitle = Driver.getDriver().switchTo().window(each).getTitle();
            if (eachTitle.equals(hedefSayfaTitle)) {
                break;
            }
        }
    }

    public static String ilkSayfaWhdIleIkinciSayfaWhdBul(WebDriver driver, String ilkSayfaWhd) {
        Set<String> tumWhdSeti = driver.getWindowHandles();
        tumWhdSeti.remove(ilkSayfaWhd);
        for (String each : tumWhdSeti
        ) {
            return each;
        }
        return null; // bu satirin hic calismayacagini biliyoruz
        // sadece javanin endiselerini gidermek icin yazdik
    }

    public static void tumSayfaTakeScreenshot(WebDriver driver) {
        // tum sayfanin fotografini cekip kaydedin
        // 1.adim tss objesi olustur
        TakesScreenshot tss = (TakesScreenshot) driver;
        // 2.adim fotografi kaydedecegimiz dosya yolu ile bir File olusturalim
        //   her yeni kaydedilen resmin oncekinin ustune kaydedilmemesi icin
        //   kaydedilecek dosya yolunu dinamik yapabiliriz
        //   dinamik yapmak icin dosya yoluna tarih etiketi ekleyelim
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter istenenFormat = DateTimeFormatter.ofPattern("yyMMddHHmmss");
        String dinamikDosyaYolu = "target/screenshots/tumSayfaScreenshot" +
                localDateTime.format(istenenFormat) +
                ".jpg";
        File tumSayfaScreenshot = new File(dinamikDosyaYolu);
        // 3.adim tss objesini kullanarak fotografi cekip, gecici bir dosyaya kaydedelim
        File geciciDosya = tss.getScreenshotAs(OutputType.FILE);
        // 4.adim : gecici dosyayi, asil dosyaya kopyalayalim
        try {
            FileUtils.copyFile(geciciDosya, tumSayfaScreenshot);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ReusableMethods.bekle(5);
    }

    public static void tumSayfaTakeScreenshot(String testAdi, WebDriver driver) {
        // tum sayfanin fotografini cekip kaydedin
        // 1.adim tss objesi olustur
        TakesScreenshot tss = (TakesScreenshot) driver;
        // 2.adim fotografi kaydedecegimiz dosya yolu ile bir File olusturalim
        //   her yeni kaydedilen resmin oncekinin ustune kaydedilmemesi icin
        //   kaydedilecek dosya yolunu dinamik yapabiliriz
        //   dinamik yapmak icin dosya yoluna tarih etiketi ekleyelim
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter istenenFormat = DateTimeFormatter.ofPattern("yyMMddHHmmss");
        String dinamikDosyaYolu = "target/screenshots/" +
                testAdi + localDateTime.format(istenenFormat) + ".jpg";
        File tumSayfaScreenshot = new File(dinamikDosyaYolu);
        // 3.adim tss objesini kullanarak fotografi cekip, gecici bir dosyaya kaydedelim
        File geciciDosya = tss.getScreenshotAs(OutputType.FILE);
        // 4.adim : gecici dosyayi, asil dosyaya kopyalayalim
        try {
            FileUtils.copyFile(geciciDosya, tumSayfaScreenshot);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ReusableMethods.bekle(5);
    }

    public static void istenenWebelementScreenshot(WebElement istenenWebelement) {
        // 1.adim screenshot alacagimiz webelementi locate et
        // 2.adim scrennshot'i kaydedecegimiz file'i olusturalim
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter istenenFormat = DateTimeFormatter.ofPattern("yyMMddHHmmss");
        String dinamikDosyaYolu = "target/screenshots/istenenWebelementScreenshot" +
                localDateTime.format(istenenFormat) + ".jpg";
        File istenenWebelementScreenshot = new File(dinamikDosyaYolu);
        // 3.adim webelement uzerinden screenshot'i alip gecici bir dosyaya kaydedin
        File geciciDosya = istenenWebelement.getScreenshotAs(OutputType.FILE);
        // 4.adim gecici dosyayi asil dosyaya kopyalayalim
        try {
            FileUtils.copyFile(geciciDosya, istenenWebelementScreenshot);
        } catch (IOException e) {
            System.out.println("Screenshot kopyalanamadi");
            throw new RuntimeException(e);
        }
    }

    public static String getScreenshot(String name) throws IOException {
        // naming the screenshot with the current date to avoid duplication
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        // TakesScreenshot is an interface of selenium that takes the screenshot
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        // full path to the screenshot location
        String target = System.getProperty("user.dir") + "/test-output/Screenshots/" + name + date + ".png";
        File finalDestination = new File(target);
        // save the screenshot to the path given
        FileUtils.copyFile(source, finalDestination);
        return target;
    }
}
