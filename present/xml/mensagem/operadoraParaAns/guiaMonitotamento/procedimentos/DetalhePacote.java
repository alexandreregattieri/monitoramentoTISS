package present.xml.mensagem.operadoraParaAns.guiaMonitotamento.procedimentos;

import model.to.mensagem.operadoraParaAns.guiaMonitoramento.procedimentos.DetalhePacoteTo;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class DetalhePacote {

	public Element getDetalhePacote(Document doc, Element el, DetalhePacoteTo dp) {
		Element el1 = null;
		Text texto = null;
		try {
			el1 = doc.createElement("ans:codigoTabela");
			texto = doc.createTextNode(dp.getCodigoTabela());
			el1.appendChild(texto);
			el.appendChild(el1);
			el1 = doc.createElement("ans:codigoProcedimento");
			texto = doc.createTextNode(dp.getCodigoProcedimento());
			el1.appendChild(texto);
			el.appendChild(el1);
			el1 = doc.createElement("ans:quantidade");
			texto = doc.createTextNode(dp.getQuantidade());
			el1.appendChild(texto);
			el.appendChild(el1);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("present.xml.mensagem.operadoraParaAns.guiaMonitotamento.procedimentos.DetalhePacote.getDetalhePacote - e= " + e.toString());
		}
		return el;
	}
	
}
