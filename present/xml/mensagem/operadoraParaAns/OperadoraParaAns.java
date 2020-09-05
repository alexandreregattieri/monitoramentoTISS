package present.xml.mensagem.operadoraParaAns;

import model.to.mensagem.operadoraParaAns.OperadoraParaANSTo;
import model.to.mensagem.operadoraParaAns.guiaMonitoramento.GuiaMonitoramentoTo;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import present.xml.mensagem.operadoraParaAns.guiaMonitotamento.GuiaMonitoramento;

public class OperadoraParaAns {

	public Element getOperadoraParaAns(Document doc, Element el, OperadoraParaANSTo opa) {
		Element el1 = null;
		GuiaMonitoramento gm = null;
		String fatura = null;
		try {
			gm = new GuiaMonitoramento();
			
			for (GuiaMonitoramentoTo to : opa.getGuiaMonitoramento()) {
				fatura = to.getNumeroGuia_operadora();
				el1 = doc.createElement("ans:guiaMonitoramento");
				el1 = gm.getGuiaMonitoramento(doc, el1, to);
				el.appendChild(el1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("present.xml.mensagem.operadoraParaAns.OperadoraParaAns.getOperadoraParaAns - Fatura = " + fatura + " - e= " + e.toString());
		}
		return el;
	}
	
}
