package present.xml.mensagem.operadoraParaAns.guiaMonitotamento.procedimentos;

import model.to.mensagem.operadoraParaAns.guiaMonitoramento.procedimentos.ProcedimentosTo;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class Procedimentos {

	public Element getProcedimentos(Document doc, Element el, ProcedimentosTo pc) {
		Element el1 = null;
		Text texto = null;
		IdentProcedimento ip = null;
		DenteRegiao dr = null;
		DetalhePacote dp = null;
		try {
			ip = new IdentProcedimento();
			dr = new DenteRegiao();
			dp = new DetalhePacote();
			
			el1 = doc.createElement("ans:identProcedimento");
			el1 = ip.getIdentProcedimento(doc, el1, pc.getIdentProcedimento());
			el.appendChild(el1);
			
			if (pc.getDenteRegiao().getCodDente() != null || pc.getDenteRegiao().getCodRegiao() != null) {
				el1 = doc.createElement("ans:denteRegiao");
				el1 = dr.getDenteRegiao(doc, el1, pc.getDenteRegiao());
				el.appendChild(el1);
			}
			
			if (pc.getDenteFace() != null) {
				el1 = doc.createElement("ans:denteFace");
				texto = doc.createTextNode(pc.getDenteFace());
				el1.appendChild(texto);
				el.appendChild(el1);
			}
			
			el1 = doc.createElement("ans:quantidadeInformada");
			texto = doc.createTextNode(pc.getQuantidadeInformada());
			el1.appendChild(texto);
			el.appendChild(el1);
			
			el1 = doc.createElement("ans:valorInformado");
			texto = doc.createTextNode(pc.getValorInformado());
			el1.appendChild(texto);
			el.appendChild(el1);
			
			el1 = doc.createElement("ans:quantidadePaga");
			texto = doc.createTextNode(pc.getQuantidadePaga());
			el1.appendChild(texto);
			el.appendChild(el1);
			
			el1 = doc.createElement("ans:valorPagoProc");
			texto = doc.createTextNode(pc.getValorPagoProc());
			el1.appendChild(texto);
			el.appendChild(el1);
			
			el1 = doc.createElement("ans:valorPagoFornecedor");
			texto = doc.createTextNode(pc.getValorPagoFornecedor());
			el1.appendChild(texto);
			el.appendChild(el1);
			
			if (pc.getCNPJFornecedor() != null) {
				el1 = doc.createElement("ans:CNPJFornecedor");
				texto = doc.createTextNode(pc.getCNPJFornecedor());
				el1.appendChild(texto);
				el.appendChild(el1);
			}
			
			el1 = doc.createElement("ans:valorCoParticipacao");
			texto = doc.createTextNode(pc.getValorCoParticipacao());
			el1.appendChild(texto);
			el.appendChild(el1);
			
			if (pc.getDetalhePacote().getCodigoProcedimento() != null) {
				el1 = doc.createElement("ans:detalhePacote");
				el1 = dp.getDetalhePacote(doc, el1, pc.getDetalhePacote());
				el.appendChild(el1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("present.xml.mensagem.operadoraParaAns.guiaMonitotamento.procedimentos.Procedimentos.getProcedimentos - e= " + e.toString());
		}
		return el;
	}
	
}
