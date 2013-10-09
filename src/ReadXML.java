import java.io.IOException;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class ReadXML {
	
	public static void main(String args[])
	{
		try {
			HashMap<String, String> elements = readXML("src/config.xml");
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static HashMap<String, String> readXML(String file) throws ParserConfigurationException, SAXException, IOException
	{
		String browser = null;
		int i = 0;
		HashMap<String, String> contents = new HashMap<>();;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document xml = builder.parse(file);
		xml.getDocumentElement().normalize();
		NodeList nodes = xml.getElementsByTagName("run");
		while(nodes.item(i)!=null)
		{
			Element elem = (Element) nodes.item(i);
			browser = elem.getElementsByTagName("browser").item(0).getChildNodes().item(0).getNodeValue().trim();
			i++;
		}
//		Element element = xml.getElementById("browser");
		
		contents.put("browser", browser);
		return contents;
	}
}
