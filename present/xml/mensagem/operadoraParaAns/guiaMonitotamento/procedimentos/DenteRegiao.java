package present.xml.mensagem.operadoraParaAns.guiaMonitotamento.procedimentos;

import model.to.mensagem.operadoraParaAns.guiaMonitoramento.procedimentos.DenteRegiaoTo;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class DenteRegiao {

	public Element getDenteRegiao(Document doc, Element el, DenteRegiaoTo dr) {
		Element el1 = null;
		Text texto = null;
		try {
			if (dr.getCodDente() != null) {
				el1 = doc.createElement("ans:codDente");
				texto = doc.createTextNode(dr.getCodDente());
				el1.appendChild(texto);
				el.appendChild(el1);
			} else if(dr.getCodRegiao() != null) {
				el1 = doc.createElement("ans:codRegiao");
				texto = doc.createTextNode(dr.getCodRegiao());
				el1.appendChild(texto);
				el.appendChild(el1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("present.xml.mensagem.operadoraParaAns.guiaMonitotamento.procedimentos.DenteRegiao.getDenteRegiao - e= " + e.toString());
		}
		return el;
	}
	
}
