package ReflectionPractice;

import com.sun.rowset.internal.Row;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;

/**
 * Created by jet533 on 9/10/2018.
 */
public class ExcelRead {

    public  static  void main(String args[]) throws IOException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, ClassNotFoundException {
        File file=new File("C:\\Users\\JET533\\workspace\\Test\\src\\main\\resources\\Test.xlsx");

        FileInputStream inputStream = new FileInputStream(file);

        Workbook mybook=new XSSFWorkbook(inputStream);
        Sheet mysheet=mybook.getSheet("Sheet1");

        int rowCount=(mysheet.getLastRowNum()-mysheet.getFirstRowNum())+1;
        System.out.println(rowCount);

        // Create a DataFormatter to format and get each cell's value as String
       // DataFormatter dataFormatter = new DataFormatter();

        Iterator<org.apache.poi.ss.usermodel.Row> rows=mysheet.rowIterator();
        //Printing data values
        System.out.println("Data values");

        XSSFRow row = (XSSFRow) rows.next();
        String clasname = null,methodname=null,parameter=null;
        while(rows.hasNext()) {

            row = (XSSFRow) rows.next();

            Iterator<Cell> cells=row.cellIterator();

            while (cells.hasNext())
            {
                Cell cell=cells.next();
                System.out.print(cell+ "\t");

            }
            System.out.print("\n");
//            row= (XSSFRow) rows.next();

            clasname="Test1.java";
            methodname="method2";
            parameter="Nikita";
        }

        Test obj=new Test();
        Class cls=Class.forName("ReflectionPractice.Test");
        Method m=cls.getDeclaredMethod(methodname,String.class);
        m.invoke(obj,parameter);
//    Test obj=new Test();
//        Class cls=obj.getClass();
//        Method m=cls.getDeclaredMethod("method2",String.class);
//        m.invoke(obj,"Nikita");





    }


}

class Test1
{
    private int x;
    Test1()
    {
        x=10;
    }
    //    public void method1()
//    {
//        System.out.print("Hello");
//    }
    protected   void method2(String x)
    {
        System.out.println("Hello " + x);
    }
}
