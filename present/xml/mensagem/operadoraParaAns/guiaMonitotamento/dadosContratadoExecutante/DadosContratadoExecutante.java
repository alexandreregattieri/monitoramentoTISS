package present.xml.mensagem.operadoraParaAns.guiaMonitotamento.dadosContratadoExecutante;

import model.to.mensagem.operadoraParaAns.guiaMonitoramento.dadosContratadoExecutante.DadosContratadoExecutanteTo;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class DadosContratadoExecutante {

	public Element getDadosContratadoExecutante(Document doc, Element el, DadosContratadoExecutanteTo dce) {
		Element el1 = null;
		Text texto = null;
		try {
			el1 = doc.createElement("ans:CNES");
			texto = doc.createTextNode(dce.getCNES());
			el1.appendChild(texto);
			el.appendChild(el1);
			el1 = doc.createElement("ans:identificadorExecutante");
			texto = doc.createTextNode(dce.getIdentificadorExecutante());
			el1.appendChild(texto);
			el.appendChild(el1);
			el1 = doc.createElement("ans:codigoCNPJ_CPF");
			texto = doc.createTextNode(dce.getCodigoCNPJ_CPF());
			el1.appendChild(texto);
			el.appendChild(el1);
			el1 = doc.createElement("ans:municipioExecutante");
			texto = doc.createTextNode(dce.getMunicipioExecutante());
			el1.appendChild(texto);
			el.appendChild(el1);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("present.xml.mensagem.operadoraParaAns.guiaMonitotamento.dadosContratadoExecutante.DadosContratadoExecutante.getDadosContratadoExecutante - e= " + e.toString());
		}
		return el;
	}
	
}
