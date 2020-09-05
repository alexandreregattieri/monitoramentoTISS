package present.xml.cabecalho;

import model.to.cabecalho.CabecalhoTo;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class Cabecalho {

	public Element getCabecalho(Document doc, Element el, CabecalhoTo cab) {
		Element el1 = null;
		Text texto = null;
		IdentificacaoTransacao id = null;
		try {
			id = new IdentificacaoTransacao();
			el = doc.createElement("ans:cabecalho");
			
			el1 = doc.createElement("ans:identificacaoTransacao");
			el1 = id.getIdentificacaoTransacao(doc, el1, cab.getIdentificacaoTransacao());
			el.appendChild(el1);
			el1 = doc.createElement("ans:registroANS");
			texto = doc.createTextNode(cab.getRegistroANS());
			el1.appendChild(texto);
			el.appendChild(el1);
			el1 = doc.createElement("ans:versaoPadrao");
			texto = doc.createTextNode(cab.getVersaoPadrao());
			el1.appendChild(texto);
			el.appendChild(el1);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("present.xml.cabecalho.IdentificacaoTransacaoTo.Cabecalho.getCabecalho - e= " + e.toString());
		}
		return el;
	}
	
}
