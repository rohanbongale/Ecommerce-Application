import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDriven {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		FileInputStream fis = new FileInputStream("C:\\Users\\1234\\Desktop\\Book1.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook();
	}

}
