package xml;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class XmlParser {

	private final String file = "Parola.xml";

	public boolean verificaParola(String parolaIntrodusa) {

		boolean raspuns = true;

		try {
			File inputFile = new File("Parola.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

			NodeList nList = doc.getElementsByTagName("algoritm");
			String algo = nList.item(0).getTextContent();
			algo=algo.trim();
			main.Main.logger.info("Algoritmul de criptare este " + (algo.equalsIgnoreCase("a1") ? "RC6" : "RSA"));

			NodeList valueLs = doc.getElementsByTagName("value");
			String value = valueLs.item(0).getTextContent().trim();
			main.Main.logger.info("Parola criptata este " + value);
			
			if (algo.equalsIgnoreCase("a1")) {
				main.Main.logger.info("Algoritmul este RC6");
				Scanner sc = new Scanner(value);
				sc.useDelimiter(",");
				
				ArrayList<Integer> a = new ArrayList<Integer>();
				
				while(sc.hasNext()) {
					a.add(Integer.parseInt(sc.next().trim()));
					
				}
				Integer[] v = new Integer[a.size()];
				for(int i = 0 ; i <v.length; i++) {
					v[i] = a.get(i);
				}
				
				main.Main.logger.info("*** Vectorul din XML este: "+Arrays.toString(v));
				
				RC6 d = new RC6();
				byte[] dec = RC6.encrypt(parolaIntrodusa.getBytes(), "123456789abcdefg".getBytes());
				Integer[] dec2=new Integer[dec.length];
				for(int i=0;i<dec.length;i++)
					dec2[i]=(int)dec[i];

				main.Main.logger.info("*** Parola criptata este: " + Arrays.toString(dec2));
				String parolaDecriptata=Arrays.toString(dec);
				
				
				
				if(Arrays.equals(v, dec2)) {
					raspuns=true;
					main.Main.logger.info("Parola corecta");
					return raspuns;
					
				}
				else {
					raspuns=false;
					main.Main.logger.info("Parola gresita");
					return raspuns;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return raspuns;

	}

	public static void main(String[] args) {
		
		XmlParser pw = new XmlParser();

		pw.verificaParola("Parola1234");
	}

}
