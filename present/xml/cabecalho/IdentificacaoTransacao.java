package present.xml.cabecalho;

import model.to.cabecalho.IdentificacaoTransacaoTo;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class IdentificacaoTransacao {

	public Element getIdentificacaoTransacao(Document doc, Element el, IdentificacaoTransacaoTo it) {
		Element el1 = null;
		Text texto = null;
		try {
			el1 = doc.createElement("ans:tipoTransacao");
			texto = doc.createTextNode(it.getTipoTransacao());
			el1.appendChild(texto);
			el.appendChild(el1);
			el1 = doc.createElement("ans:numeroLote");
			texto = doc.createTextNode(it.getNumeroLote());
			el1.appendChild(texto);
			el.appendChild(el1);
			el1 = doc.createElement("ans:competenciaLote");
			texto = doc.createTextNode(it.getCompetenciaLote());
			el1.appendChild(texto);
			el.appendChild(el1);
			el1 = doc.createElement("ans:dataRegistroTransacao");
			texto = doc.createTextNode(it.getDataRegistroTransacao());
			el1.appendChild(texto);
			el.appendChild(el1);
			el1 = doc.createElement("ans:horaRegistroTransacao");
			texto = doc.createTextNode(it.getHoraRegistroTransacao());
			el1.appendChild(texto);
			el.appendChild(el1);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("present.xml.cabecalho.IdentificacaoTransacaoTo.IdentificacaoTransacao.getIdentificacaoTransacao - e= " + e.toString());
		}
		return el;
	}
	
}
