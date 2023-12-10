package tests.f02_ExcelOkuma;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class F02_ExcelMapDonusturme {

    @Test
    public void excelTest() throws IOException {

        String dosyaYolu = "src/test/java/tests/f02_ExcelOkuma/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        Map<String, String> ulkelerMap = new TreeMap<>();
        String satirdakiUlkeIsmi;
        String satirdakiBaskentIsmi;
        int sonSatirIndex = workbook.getSheet("Sayfa1").getLastRowNum();

        for (int i = 0; i <= sonSatirIndex; i++) {
            satirdakiUlkeIsmi = workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString();
            satirdakiBaskentIsmi = workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();
            ulkelerMap.put(satirdakiUlkeIsmi, satirdakiBaskentIsmi);
        }

        String expectedBaskentIsmi = "Moskova";
        String actualBaskentIsmi = ulkelerMap.get("Rusya");
        Assert.assertEquals(expectedBaskentIsmi,actualBaskentIsmi);

        Assert.assertTrue(ulkelerMap.containsValue("San Marino"));

        Assert.assertTrue(ulkelerMap.containsKey("Filipinler"));



    }
}
