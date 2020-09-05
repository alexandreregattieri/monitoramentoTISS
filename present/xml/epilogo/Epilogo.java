package present.xml.epilogo;

import model.to.epilogo.EpilogoTo;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class Epilogo {

	public Element getEpilogo(Document doc, Element el, EpilogoTo ep) {
		Element el1 = null;
		Text texto = null;
		try {
			el = doc.createElement("ans:epilogo");
			
			el1 = doc.createElement("ans:hash");
			texto = doc.createTextNode(ep.getHash());
			el1.appendChild(texto);
			el.appendChild(el1);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("present.xml.epilogo.Epilogo.getEpilogo - e= " + e.toString());
		}
		return el;
	}
	
}
