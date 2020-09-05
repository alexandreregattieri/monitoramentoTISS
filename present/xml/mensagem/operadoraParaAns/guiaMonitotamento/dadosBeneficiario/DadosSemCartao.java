package present.xml.mensagem.operadoraParaAns.guiaMonitotamento.dadosBeneficiario;

import model.to.mensagem.operadoraParaAns.guiaMonitoramento.dadosBeneficiario.DadosSemCartaoTo;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class DadosSemCartao {

	public Element getDadosSemCartao(Document doc, Element el, DadosSemCartaoTo dsc) {
		Element el1 = null;
		Text texto = null;
		try {
			el1 = doc.createElement("ans:sexo");
			texto = doc.createTextNode(dsc.getSexo());
			el1.appendChild(texto);
			el.appendChild(el1);
			el1 = doc.createElement("ans:dataNascimento");
			texto = doc.createTextNode(dsc.getDataNascimento());
			el1.appendChild(texto);
			el.appendChild(el1);
			el1 = doc.createElement("ans:municipioResidencia");
			texto = doc.createTextNode(dsc.getMunicipioResidencia());
			el1.appendChild(texto);
			el.appendChild(el1);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("present.xml.mensagem.operadoraParaAns.guiaMonitotamento.dadosBeneficiario.DadosSemCartao.getDadosSemCartao - e= " + e.toString());
		}
		return el;
	}
	
}
