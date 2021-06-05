
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
	
	public static void main(String[] args) {

		String[] fisiere = new String[] {
				"C:\\Users\\paul_\\OneDrive\\Desktop\\Licenta\\Test-email.xlsx",
				"C:\\Users\\paul_\\OneDrive\\Desktop\\Licenta\\Test-numar.xlsx",
				"C:\\Users\\paul_\\OneDrive\\Desktop\\Licenta\\Test-numar-email.xlsx"
		};
		
		for (String fisier : fisiere) {
			ArrayList<Persoana> persoane = incarcaFisier(fisier);
			afiseazaPersoane(persoane);
			
			Collections.sort(persoane, new Comparator<Persoana>() {

				@Override
				public int compare(Persoana p1, Persoana p2) {
					return p1.getNume().compareTo(p2.getNume());
				}
			});
			afiseazaPersoane(persoane);
		}
		
		for(String fisier : fisiere) {
			ArrayList<Persoana> persoane = incarcaFisier(fisier);
			
			Collections.sort(persoane, new Comparator<Persoana>() {

				@Override
				public int compare(Persoana p1, Persoana p2) {
					
					return p1.getPrenume().compareTo(p2.getPrenume());
				}
				
			});
			afiseazaPersoane(persoane);
			
			
		}
	}
	
	public static ArrayList<Persoana> incarcaFisier(String numeFisier) {
		ArrayList<Persoana> lista = new ArrayList<Persoana>();
		// cazuri: 1 - am doar numar, 2 - am doar email , 3 - am si numar si email

		try {
			File file = new File(numeFisier);
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
					String coloanaTrei = cell.getStringCellValue();
					
					String email = "";
					String numar = "";
					
					if (coloanaTrei.contains("@")) { // cazul 1
						email = coloanaTrei;
					} else { // cazul 2 sau 3
						numar = coloanaTrei;
						
						if (cellIterator.hasNext()) { // cazul 3
							cell = cellIterator.next();
							email = cell.getStringCellValue();
						}
					}

					Persoana p1 = new Persoana(nume, prenume, email, numar);
					lista.add(p1);
				}
			}

			wb.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return lista;
	}

	public static void afiseazaPersoane(ArrayList<Persoana> persoane) {
		System.out.println(persoane);
	}
}