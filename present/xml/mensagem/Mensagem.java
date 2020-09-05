package present.xml.mensagem;

import model.to.mensagem.MensagemTo;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import present.xml.mensagem.operadoraParaAns.OperadoraParaAns;

public class Mensagem {
	
	public Element getMensagem(Document doc, Element el, MensagemTo msg) {
		Element el1 = null;
		OperadoraParaAns opa = null;
		try {
			opa = new OperadoraParaAns();
			el = doc.createElement("ans:Mensagem");
			
			el1 = doc.createElement("ans:operadoraParaANS");
			el1 = opa.getOperadoraParaAns(doc, el1, msg.getOperadoraParaANS());
			el.appendChild(el1);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("present.xml.mensagem.Mensagem.getMensagem - e= " + e.toString());
		}
		return el;
	}

}
