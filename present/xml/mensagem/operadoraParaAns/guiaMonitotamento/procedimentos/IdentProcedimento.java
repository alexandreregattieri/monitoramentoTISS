package present.xml.mensagem.operadoraParaAns.guiaMonitotamento.procedimentos;

import model.to.mensagem.operadoraParaAns.guiaMonitoramento.procedimentos.IdentProcedimentoTo;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class IdentProcedimento {

	public Element getIdentProcedimento(Document doc, Element el, IdentProcedimentoTo ip) {
		Element el1 = null;
		Text texto = null;
		Procedimento pcd = null;
		try {
			pcd = new Procedimento();
			
			el1 = doc.createElement("ans:codigoTabela");
			texto = doc.createTextNode(ip.getCodigoTabela());
			el1.appendChild(texto);
			el.appendChild(el1);
			
			el1 = doc.createElement("ans:Procedimento");
			el1 = pcd.getProcedimento(doc, el1, ip.getProcedimento());
			el.appendChild(el1);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("present.xml.mensagem.operadoraParaAns.guiaMonitotamento.procedimentos.IdentProcedimento.getIdentProcedimento - e= " + e.toString());
		}
		return el;
	}
	
}
