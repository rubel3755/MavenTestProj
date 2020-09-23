package testPkg;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.List;

public class ExcelManager {

    public Object[][] getExcelData(String excelLocation, String sheetName) {

        try{
            File file= new File(excelLocation);
            FileInputStream fis= new FileInputStream(file );

            XSSFWorkbook workbook= new XSSFWorkbook(fis);
            XSSFSheet sheet= workbook.getSheet(sheetName);

            int totalNumberOfRows= sheet.getLastRowNum();
            System.out.println("totalNumberOfRows are: "+ totalNumberOfRows);
            int totalNumberOfColumns= sheet.getRow(0).getLastCellNum();
            System.out.println("cells in first row are: "+ totalNumberOfColumns);

            Object[][] dataSets = new Object[totalNumberOfRows+1][totalNumberOfColumns];//9:2

            Iterator<Row> rowIterator = sheet.iterator();
            int i=0;
            while(rowIterator.hasNext()){
                Row row= rowIterator.next();

                Iterator<Cell> cellIterator = row.cellIterator();
                int j=0;
                while(cellIterator.hasNext()) {

                    Cell cell = cellIterator.next();

                    if (cell != null) {
                        switch (cell.getCellType()) {
                            case BOOLEAN:
                                dataSets[i][j++] = cell.getBooleanCellValue();
                                break;
                            case NUMERIC:
                                dataSets[i][j++] = cell.getNumericCellValue();
                                break;
                            case STRING:
                                dataSets[i][j++] = cell.getStringCellValue();
                                break;
                            case FORMULA:
                                dataSets[i][j++] = cell.getCellFormula();
                                break;
                            case BLANK:
                                break;
                            case ERROR:
                                dataSets[i][j++] = cell.getStringCellValue();
                                break;
                            default:
                                System.out.println("No matching data type found");
                                break;
                        }


                    }
                }
                i++;
            }

            return dataSets;

        }catch(Exception e){
            e.printStackTrace();

        }
        return null;
    }


    @Test
    public void test(){
        ExcelManager excelManage= new ExcelManager();
        String excelLocation =System.getProperty("user.dir")+"/src/main/resources/TestData.xlsx";
        System.out.println(System.getProperty("user.dir"));
        Object[][] data = excelManage.getExcelData(excelLocation, "LoginDetails");

        System.out.println(data[0][0]);
        System.out.println(data[1][1]);

    }






}
