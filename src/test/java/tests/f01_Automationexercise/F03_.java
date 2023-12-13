package tests.f01_Automationexercise;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.DemoqaPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class F03_ {

    @Test
    public void sayfaTesti(){

        //1. “https://demoqa.com/webtables” sayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("demoqaUrl"));
        //2. Headers da bulunan basliklari yazdirin
        DemoqaPage demoqaPage = new DemoqaPage();
        List<WebElement> headersElementleriList = demoqaPage.baslikElementleriListesi;
        List<String> baslikYazilariList = ReusableMethods.stringListeDonustur(headersElementleriList);
        System.out.println("Basliklar : " + baslikYazilariList);
        //3. 3.sutunun basligini yazdirin
        System.out.println("3.sutun basligi : " +baslikYazilariList.get(2));
        //4. Tablodaki tum datalari yazdirin
        List<WebElement> tabloTumDataElementleriList = demoqaPage.tumDataElementleriListesi;
        List<String> tabloYaziList = ReusableMethods.stringListeDonustur(tabloTumDataElementleriList);
        System.out.println("Tablo tum datalar  : " + tabloYaziList);
        //5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
       int doluHucreSayisi = 0;
        for (String each : tabloYaziList
             ) {
            if (!each.isBlank()){
                doluHucreSayisi ++;
            }
        }
        System.out.println("Bos olmayan hucre sayisi : " + doluHucreSayisi);
        //6. Tablodaki satir sayisini yazdirin
        List<WebElement> tabloSatirElementleriList = demoqaPage.tabloSatirElementleriListesi;
        System.out.println("Tablo satir sayisi : " + tabloSatirElementleriList.size());
        //7. Tablodaki sutun sayisini yazdirin
        System.out.println("Sutun sayisi : " + baslikYazilariList.size());
        //8. Tablodaki 3.kolonu yazdirin
        List<WebElement> ucuncuKolonElementleriList = demoqaPage.ucuncuKolonElementleriListesi;
        List<String> ucuncuKolonYaziList = ReusableMethods.stringListeDonustur(ucuncuKolonElementleriList);
        System.out.println("Tablo 3.kolon listesi : " + ucuncuKolonYaziList);
        //9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
        System.out.println("Kierra maasi : " + demoqaPage.kierraMaasElementi.getText());
        //10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun
        //sayisini girdigimde bana datayi yazdirsin


       // ReusableMethods.bekle(2);

        Driver.closeDriver();
          }
}
