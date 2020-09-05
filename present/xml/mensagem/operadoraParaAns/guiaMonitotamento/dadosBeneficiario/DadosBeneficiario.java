package present.xml.mensagem.operadoraParaAns.guiaMonitotamento.dadosBeneficiario;

import model.to.mensagem.operadoraParaAns.guiaMonitoramento.dadosBeneficiario.DadosBeneficiarioTo;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class DadosBeneficiario {

	public Element getDadosBeneficiario(Document doc, Element el, DadosBeneficiarioTo db) {
		Element el1 = null;
		Text texto = null;
		IdentBeneficiario ib = null;
		try {
			ib = new IdentBeneficiario();
			
			el1 = doc.createElement("ans:identBeneficiario");
			el1 = ib.getIdentBeneficiario(doc, el1, db.getIdentBeneficiario());
			el.appendChild(el1);
			el1 = doc.createElement("ans:numeroRegistroPlano");
			texto = doc.createTextNode(db.getNumeroRegistroPlano());
			el1.appendChild(texto);
			el.appendChild(el1);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("present.xml.mensagem.operadoraParaAns.guiaMonitotamento.dadosBeneficiario.DadosBeneficiario.getDadosBeneficiario - e= " + e.toString());
		}
		return el;
	}
	
}
