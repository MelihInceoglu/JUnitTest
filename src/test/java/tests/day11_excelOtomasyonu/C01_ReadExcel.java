package tests.day11_excelOtomasyonu;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel {


    @Test
    public void test01() throws IOException {


        String dosyayolu="src/test/java/tests/day11_excelOtomasyonu/ulkeler.xlsx";

       //Eger excel dosyasi proje icerisnde degilde
        //masa üstü yada downloads gibi baska bir kalsörün içinde ise
        //dosya yolu dinamik hale getirilebilir


        FileInputStream fis=new FileInputStream(dosyayolu);

        Workbook workbook = WorkbookFactory.create(fis);


        /*

        olusturdugumuz workbook bizim excelimizi canli olarak kullanmaz
        23. satir calistiginda file input stream deki yani verdigimiz dpsya yolunda olan exceldeki
        tum bilgileri alıp bu classda olsuturdugumuz workbook objesine yukler

        Yani workbook objesi exceldeki bilgilerin bir kopyasına sahip olur

        workboookd a bir degisiklil yaparsak

        ana excel degişmez

        Eger ana excelin de değişmesini isitiyorsak islem bittikten sonra yani claasısın en sonunda
        workbook daki yeni hali excele kaydetemiz gerekir.






         */


        Sheet sheet = workbook.getSheet("Sayfa1");
        Row row = sheet.getRow(3); //3. satır
        Cell cell=row.getCell(2); // 2. data


        System.out.println(cell);

        //excelde satir ve sutun numaralari index kullanır
        //yani 0 dan baslar



        //12.satırda bulunan azerbaycan'nın ingilizce baskent isminin Baku oldugunu test edin


        Row onIkinciSatir=sheet.getRow(11);
        Cell inglizceBaskent=onIkinciSatir.getCell(1);

        String expectedBaskentIsmi="Baku";

        String actualBaskentIsmi=inglizceBaskent.toString();

        Assert.assertEquals(expectedBaskentIsmi,actualBaskentIsmi);




    }




}
