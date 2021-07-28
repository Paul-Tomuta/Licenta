package date;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import date.Persoana;

public class XLSXReaderExample {
	public static ArrayList<Persoana> incarcaFisier(String file_path) {
		ArrayList<Persoana> lista = new ArrayList<Persoana>();
		try {
			File file = new File(file_path);
			FileInputStream fis = new FileInputStream(file);

			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheetAt(0);
			Iterator<Row> itr = sheet.iterator();
			while (itr.hasNext()) {
				Row row = itr.next();
				Iterator<Cell> cellIterator = row.cellIterator();

				if (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					String nume = cell.getStringCellValue();
					if (nume == "")
						break;

					cell = cellIterator.next();
					String prenume = cell.getStringCellValue();

					cell = cellIterator.next();
					String email = cell.getStringCellValue();
					
					cell = cellIterator.next();
					String nrTel = cell.getStringCellValue();
					
					cell = cellIterator.next();
					int sex = Integer.parseInt(cell.getStringCellValue());

					Persoana p1 = new Persoana(nume, prenume, email, nrTel, sex);
					lista.add(p1);
				}
			}

			wb.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return lista;
	}
}
