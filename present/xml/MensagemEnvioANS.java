package present.xml;

import model.to.MensagemEnvioANSTo;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import present.xml.cabecalho.Cabecalho;
import present.xml.epilogo.Epilogo;
import present.xml.mensagem.Mensagem;

public class MensagemEnvioANS {
	
	public Element getMensagemEnvioANS(Document doc, Element el, MensagemEnvioANSTo mea) {
		Element el1 = null;
		Element el2 = null;
		Element el3 = null;
		Cabecalho cab = null;
		Mensagem msg = null;
		Epilogo epl = null;
		try {
			cab = new Cabecalho();
			msg = new Mensagem();
			epl = new Epilogo();
			
			//el = doc.createElement("ans:cabecalho");
			el1 = cab.getCabecalho(doc, el, mea.getCabecalho());
			el.appendChild(el1);
			//el = doc.createElement("ans:mensagem");
			el2 = msg.getMensagem(doc, el, mea.getMensagem());
			el.appendChild(el2);
			//el = doc.createElement("ans:epilogo");
			el3 = epl.getEpilogo(doc, el, mea.getEpilogo());
			el.appendChild(el3);
		} catch (Exception e) {
			System.out.println("present.xml.MensagemEnvioANS.getMensagemEnvioANS - e= " + e.toString());
		}
		return el;
	}

}
