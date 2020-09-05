package present.xml.mensagem.operadoraParaAns.guiaMonitotamento.procedimentos;

import model.to.mensagem.operadoraParaAns.guiaMonitoramento.procedimentos.ProcedimentoTo;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class Procedimento {

	public Element getProcedimento(Document doc, Element el, ProcedimentoTo pc) {
		Element el1 = null;
		Text texto = null;
		try {
			if (pc.getGrupoProcedimento() != null) {
				el1 = doc.createElement("ans:grupoProcedimento");
				texto = doc.createTextNode(pc.getGrupoProcedimento());
				el1.appendChild(texto);
				el.appendChild(el1);
			} else {
				el1 = doc.createElement("ans:codigoProcedimento");
				texto = doc.createTextNode(pc.getCodigoProcedimento());
				el1.appendChild(texto);
				el.appendChild(el1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("present.xml.mensagem.operadoraParaAns.guiaMonitotamento.procedimentos.Procedimento.getProcedimento - e= " + e.toString());
		}
		return el;
	}
	
}
