package tests.f02_ExcelOkuma;

import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ReusableMethods;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class F01_ExcellOtamasyonu {

    FileInputStream fileInputStream;
    Workbook workbook;
    Sheet sayfa1;
    Row birinciSatir;
    Cell ikinciCell;
    String dosyaYolu = "src/test/java/tests/f02_ExcelOkuma/ulkeler.xlsx";

    @Test
    public void excelOtomasyonTesti() throws IOException {

        fileInputStream = new FileInputStream(dosyaYolu);
        workbook = WorkbookFactory.create(fileInputStream);
        sayfa1 = workbook.getSheet("Sayfa1");
        Row ucuncuSatir = sayfa1.getRow(3);
        Cell ikinciData = ucuncuSatir.getCell(2);

        System.out.println(ikinciData);

        // 12. satırdaki ulkenin turkce adinin Azerbaycan oldugunu dogrulayin

        String actualIstenenUlkeAdi = sayfa1.getRow(11).getCell(2).toString();
        String expectedUlkeAdi = "Azerbaycan";
        Assert.assertEquals(actualIstenenUlkeAdi, expectedUlkeAdi);

    }

    @Test
    public void readExcelTesti() throws IOException {
        dosyaYolu = "src/test/java/tests/f02_ExcelOkuma/ulkeler.xlsx";

        fileInputStream = new FileInputStream(dosyaYolu);
        workbook = WorkbookFactory.create(fileInputStream);
        sayfa1 = workbook.getSheet("Sayfa1");
        birinciSatir = sayfa1.getRow(0);
        ikinciCell = birinciSatir.getCell(1);
        System.out.println(ikinciCell);

        String baskent = ikinciCell.toString();
        System.out.println(baskent);

        String actualBaskentAfganistan = sayfa1.getRow(1).getCell(3).toString();
        String expectedBaskent = "Kabil";
        Assert.assertEquals(expectedBaskent, actualBaskentAfganistan);

        int satirSayisi = sayfa1.getLastRowNum();
        System.out.println(satirSayisi + 1);

        System.out.println(baskentBul("Peru", "Turkce"));
        System.out.println(baskentBul("Bangladesh", "ingilizce"));

        System.out.println("Fiziki kullanilan satir :" + sayfa1.getPhysicalNumberOfRows());

    }

    private String baskentBul(String ulkeAdi, String dilTercihi) {

        String satirdakiUlkeAdi;
        String baskentIsmi = "";

        for (int i = 0; i < sayfa1.getLastRowNum(); i++) {

            satirdakiUlkeAdi = sayfa1.getRow(i).getCell(0).toString();

            if (satirdakiUlkeAdi.equalsIgnoreCase(ulkeAdi)) {

                if (dilTercihi.equalsIgnoreCase("ingilizce")) {

                    baskentIsmi = sayfa1.getRow(i).getCell(1).toString();

                } else {
                    baskentIsmi = sayfa1.getRow(i).getCell(3).toString();

                }

            }
        }
        return baskentIsmi;
    }

    @Test
    public void excelReadTesti() throws IOException {

        fileInputStream = new FileInputStream(dosyaYolu);
        workbook = WorkbookFactory.create(fileInputStream);
        Sheet sayfa2 = workbook.getSheet("Sayfa2");

        int expectedSatirSayisi = 26;
        int actualSatirSayisi = sayfa2.getLastRowNum() + 1;
        Assert.assertEquals(expectedSatirSayisi, actualSatirSayisi);

        int expectedFizikiKullanilanSatirSayisi = 12;
        int actualFizikiKullanilanSatirSayisi = sayfa2.getPhysicalNumberOfRows();
        Assert.assertEquals(expectedFizikiKullanilanSatirSayisi, actualFizikiKullanilanSatirSayisi);


    }


}
