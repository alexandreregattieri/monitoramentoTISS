package present.xml.mensagem.operadoraParaAns.guiaMonitotamento.diagnosticosCID10;

import model.to.mensagem.operadoraParaAns.guiaMonitoramento.diagnosticosCID10.DiagnosticosCID10To;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class DiagnosticosCID10 {

	public Element getDiagnosticosCID10(Document doc, Element el, DiagnosticosCID10To dc) {
		Element el1 = null;
		Text texto = null;
		try {
			el1 = doc.createElement("ans:diagnosticoCID");
			texto = doc.createTextNode(dc.getDiagnosticoCID());
			el1.appendChild(texto);
			el.appendChild(el1);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("present.xml.mensagem.operadoraParaAns.guiaMonitotamento.diagnosticosCID10.DiagnosticosCID10.getDiagnosticosCID10 - e= " + e.toString());
		}
		return el;
	}
	
}
