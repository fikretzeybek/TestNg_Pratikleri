package tests.f01_Automationexercise;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.DemoqaPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class F02_WebtablesHomework {

    @Test
    public void test02() {

        //Bir Class olusturun WebtablesHomework
        //1. “https://demoqa.com/webtables” sayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("demoqaUrl"));
        //2. Headers da bulunan basliklari yazdirin
        DemoqaPage demoqaPage = new DemoqaPage();
        List<WebElement> baslikElementleriYaziListesi = demoqaPage.baslikElementleriListesi;
        List<String> baslikYazilariListesi = ReusableMethods.stringListeDonustur(baslikElementleriYaziListesi);
        System.out.println("Basliklar : " + baslikYazilariListesi);
        //3. 3.sutunun basligini yazdirin
        System.out.println("3.sutun basligi : " + baslikYazilariListesi.get(2));
        //4. Tablodaki tum datalari yazdirin
        List<WebElement> tabloDataElementleriListesi = demoqaPage.tumDataElementleriListesi;
        List<String> tabloDataYazilariListesi = ReusableMethods.stringListeDonustur(tabloDataElementleriListesi);
        System.out.println("Tablo datalar listesi : " + tabloDataYazilariListesi);
        System.out.println("Tablo datalar sayisi : " + tabloDataYazilariListesi.size());
        //5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
        List<String> cellDataListesi = ReusableMethods.stringListeDonustur(demoqaPage.hucrelerListesi);
        int doluHucreSayisi = 0;
        for (String each : cellDataListesi
        ) {
            if (!each.isBlank()) {
                doluHucreSayisi++;
            }
        }
        System.out.println("Bos olmayan hucre sayisi : " + doluHucreSayisi);
        //6. Tablodaki satir sayisini yazdirin
        List<String> tabloSatirYazilariListesi = ReusableMethods.stringListeDonustur(demoqaPage.tabloSatirElementleriListesi);
        System.out.println("Tablo satir sayisi : " + tabloSatirYazilariListesi.size());
        //7. Tablodaki sutun sayisini yazdirin
        System.out.println("Tablo sutun sayisi : " + baslikYazilariListesi.size());
        //8. Tablodaki 3.kolonu yazdirin
        List<String> ucuncuKolonYaziListesi = ReusableMethods.stringListeDonustur(demoqaPage.ucncuKolonElementleriListesi);
        System.out.println("Ucuncu kolon data listesi : " + ucuncuKolonYaziListesi);
        //9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
        System.out.println("Kierra maasi : " + demoqaPage.kierraMaasElementi.getText());
        //10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun
        //sayisini girdigimde bana datayi yazdirsin

        demoqaPage.istenenHucreDatasiniYazdir(2, 4);
        demoqaPage.istenenHucreDatasiniYazdir(1, 5);
        demoqaPage.istenenHucreDatasiniYazdir(3, 1);


        Driver.getDriver().quit();
    }
}
