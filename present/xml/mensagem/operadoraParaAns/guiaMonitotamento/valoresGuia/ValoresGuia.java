package present.xml.mensagem.operadoraParaAns.guiaMonitotamento.valoresGuia;

import model.to.mensagem.operadoraParaAns.guiaMonitoramento.valoresGuia.ValoresGuiaTo;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class ValoresGuia {

	public Element getValoresGuia(Document doc, Element el, ValoresGuiaTo vg) {
		Element el1 = null;
		Text texto = null;
		try {
			el1 = doc.createElement("ans:valorTotalInformado");
			texto = doc.createTextNode(vg.getValorTotalInformado());
			el1.appendChild(texto);
			el.appendChild(el1);
			el1 = doc.createElement("ans:valorProcessado");
			texto = doc.createTextNode(vg.getValorProcessado());
			el1.appendChild(texto);
			el.appendChild(el1);
			el1 = doc.createElement("ans:valorTotalPagoProcedimentos");
			texto = doc.createTextNode(vg.getValorTotalPagoProcedimentos());
			el1.appendChild(texto);
			el.appendChild(el1);
			el1 = doc.createElement("ans:valorTotalDiarias");
			texto = doc.createTextNode(vg.getValorTotalDiarias());
			el1.appendChild(texto);
			el.appendChild(el1);
			el1 = doc.createElement("ans:valorTotalTaxas");
			texto = doc.createTextNode(vg.getValorTotalTaxas());
			el1.appendChild(texto);
			el.appendChild(el1);
			el1 = doc.createElement("ans:valorTotalMateriais");
			texto = doc.createTextNode(vg.getValorTotalMateriais());
			el1.appendChild(texto);
			el.appendChild(el1);
			el1 = doc.createElement("ans:valorTotalOPME");
			texto = doc.createTextNode(vg.getValorTotalOPME());
			el1.appendChild(texto);
			el.appendChild(el1);
			el1 = doc.createElement("ans:valorTotalMedicamentos");
			texto = doc.createTextNode(vg.getValorTotalMedicamentos());
			el1.appendChild(texto);
			el.appendChild(el1);
			el1 = doc.createElement("ans:valorGlosaGuia");
			texto = doc.createTextNode(vg.getValorGlosaGuia());
			el1.appendChild(texto);
			el.appendChild(el1);
			el1 = doc.createElement("ans:valorPagoGuia");
			texto = doc.createTextNode(vg.getValorPagoGuia());
			el1.appendChild(texto);
			el.appendChild(el1);
			el1 = doc.createElement("ans:valorPagoFornecedores");
			texto = doc.createTextNode(vg.getValorPagoFornecedores());
			el1.appendChild(texto);
			el.appendChild(el1);
			el1 = doc.createElement("ans:valorTotalTabelaPropria");
			texto = doc.createTextNode(vg.getValorTotalTabelaPropria());
			el1.appendChild(texto);
			el.appendChild(el1);
			el1 = doc.createElement("ans:valorTotalCoParticipacao");
			texto = doc.createTextNode(vg.getValorTotalCoParticipacao());
			el1.appendChild(texto);
			el.appendChild(el1);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("present.xml.mensagem.operadoraParaAns.guiaMonitotamento.valoresGuia.ValoresGuia.getValoresGuia - e= " + e.toString());
		}
		return el;
	}
	
}
