package present.xml.mensagem.operadoraParaAns.guiaMonitotamento.dadosBeneficiario;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import model.to.mensagem.operadoraParaAns.guiaMonitoramento.dadosBeneficiario.IdentBeneficiarioTo;

public class IdentBeneficiario {

	public Element getIdentBeneficiario(Document doc, Element el, IdentBeneficiarioTo dib) {
		Element el1 = null;
		Text texto = null;
		//DadosSemCartao dsc = null;
		try {
			/*
			dsc = new DadosSemCartao();
			if (dib.getNumeroCartaoNacionalSaude() != null) {
				el1 = doc.createElement("ans:numeroCartaoNacionalSaude");
				texto = doc.createTextNode(dib.getNumeroCartaoNacionalSaude());
				el1.appendChild(texto);
				el.appendChild(el1);
			} else {
				el1 = doc.createElement("ans:dadosSemCartao");
				el1 = dsc.getDadosSemCartao(doc, el1, dib.getDadosSemCartao());
				el.appendChild(el1);
			}*/
			if (dib.getNumeroCartaoNacionalSaude() != null) {
				el1 = doc.createElement("ans:numeroCartaoNacionalSaude");
				texto = doc.createTextNode(dib.getNumeroCartaoNacionalSaude());
				el1.appendChild(texto);
				el.appendChild(el1);
			}
			el1 = doc.createElement("ans:sexo");
			texto = doc.createTextNode(dib.getDadosSemCartao().getSexo());
			el1.appendChild(texto);
			el.appendChild(el1);
			el1 = doc.createElement("ans:dataNascimento");
			texto = doc.createTextNode(dib.getDadosSemCartao().getDataNascimento());
			el1.appendChild(texto);
			el.appendChild(el1);
			el1 = doc.createElement("ans:municipioResidencia");
			texto = doc.createTextNode(dib.getDadosSemCartao().getMunicipioResidencia());
			el1.appendChild(texto);
			el.appendChild(el1);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("present.xml.mensagem.operadoraParaAns.guiaMonitotamento.dadosBeneficiario.IdentBeneficiario.getIdentBeneficiario - e= " + e.toString());
		}
		return el;
	}
	
}
