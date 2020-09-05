package present.xml.mensagem.operadoraParaAns.guiaMonitotamento;

import model.to.mensagem.operadoraParaAns.guiaMonitoramento.GuiaMonitoramentoTo;
import model.to.mensagem.operadoraParaAns.guiaMonitoramento.procedimentos.ProcedimentosTo;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import present.xml.mensagem.operadoraParaAns.guiaMonitotamento.dadosBeneficiario.DadosBeneficiario;
import present.xml.mensagem.operadoraParaAns.guiaMonitotamento.dadosContratadoExecutante.DadosContratadoExecutante;
import present.xml.mensagem.operadoraParaAns.guiaMonitotamento.diagnosticosCID10.DiagnosticosCID10;
import present.xml.mensagem.operadoraParaAns.guiaMonitotamento.procedimentos.Procedimentos;
import present.xml.mensagem.operadoraParaAns.guiaMonitotamento.valoresGuia.ValoresGuia;

public class GuiaMonitoramento {

	public Element getGuiaMonitoramento(Document doc, Element el, GuiaMonitoramentoTo gm) {
		Element el1 = null;
		Text texto = null;
		DadosContratadoExecutante dce = null;
		DadosBeneficiario db = null;
		DiagnosticosCID10 dc = null;
		ValoresGuia vg = null;
		Procedimentos pc = null;
		try {
			dce = new DadosContratadoExecutante();
			db = new DadosBeneficiario();
			dc = new DiagnosticosCID10();
			vg = new ValoresGuia();
			pc = new Procedimentos();
			
			el1 = doc.createElement("ans:tipoRegistro");
			texto = doc.createTextNode(gm.getTipoRegistro());
			el1.appendChild(texto);
			el.appendChild(el1);
			
			if (gm.getVersaoTISSPrestador() != null) {
				el1 = doc.createElement("ans:versaoTISSPrestador");
				texto = doc.createTextNode(gm.getVersaoTISSPrestador());
				el1.appendChild(texto);
				el.appendChild(el1);	
			}
			
			el1 = doc.createElement("ans:formaEnvio");
			texto = doc.createTextNode(gm.getFormaEnvio());
			el1.appendChild(texto);
			el.appendChild(el1);
			
			el1 = doc.createElement("ans:dadosContratadoExecutante");
			el1 = dce.getDadosContratadoExecutante(doc, el1, gm.getDadosContratadoExecutante());
			el.appendChild(el1);
			
			if (gm.getRegistroANSOperadoraIntermediaria() != null) {
				el1 = doc.createElement("ans:registroANSOperadoraIntermediaria");
				texto = doc.createTextNode(gm.getRegistroANSOperadoraIntermediaria());
				el1.appendChild(texto);
				el.appendChild(el1);
			}
			
			if (gm.getTipoAtendimentoOperadoraIntermediaria() != null) {
				el1 = doc.createElement("ans:tipoAtendimentoOperadoraIntermediaria");
				texto = doc.createTextNode(gm.getTipoAtendimentoOperadoraIntermediaria());
				el1.appendChild(texto);
				el.appendChild(el1);
			}
			
			el1 = doc.createElement("ans:dadosBeneficiario");
			el1 = db.getDadosBeneficiario(doc, el1, gm.getDadosBeneficiario());
			el.appendChild(el1);
			
			el1 = doc.createElement("ans:tipoEventoAtencao");
			texto = doc.createTextNode(gm.getTipoEventoAtencao());
			el1.appendChild(texto);
			el.appendChild(el1);
			
			el1 = doc.createElement("ans:origemEventoAtencao");
			texto = doc.createTextNode(gm.getOrigemEventoAtencao());
			el1.appendChild(texto);
			el.appendChild(el1);
			
			el1 = doc.createElement("ans:numeroGuia_prestador");
			texto = doc.createTextNode(gm.getNumeroGuia_prestador());
			el1.appendChild(texto);
			el.appendChild(el1);
			
			el1 = doc.createElement("ans:numeroGuia_operadora");
			texto = doc.createTextNode(gm.getNumeroGuia_operadora());
			el1.appendChild(texto);
			el.appendChild(el1);
			
			el1 = doc.createElement("ans:identificacaoReembolso");
			texto = doc.createTextNode(gm.getIdentificacaoReembolso());
			el1.appendChild(texto);
			el.appendChild(el1);
			
			if (gm.getIdentificacaoValorPreestabelecido() != null) {
				el1 = doc.createElement("ans:identificacaoValorPreestabelecido");
				texto = doc.createTextNode(gm.getIdentificacaoValorPreestabelecido());
				el1.appendChild(texto);
				el.appendChild(el1);
			}
			
			if (gm.getGuiaSolicitacaoInternacao() != null) {
				el1 = doc.createElement("ans:guiaSolicitacaoInternacao");
				texto = doc.createTextNode(gm.getGuiaSolicitacaoInternacao());
				el1.appendChild(texto);
				el.appendChild(el1);
			}
			
			if (gm.getDataSolicitacao() != null) {
				el1 = doc.createElement("ans:dataSolicitacao");
				texto = doc.createTextNode(gm.getDataSolicitacao());
				el1.appendChild(texto);
				el.appendChild(el1);
			}
			
			if (gm.getNumeroGuiaSPSADTPrincipal() != null) {
				el1 = doc.createElement("ans:numeroGuiaSPSADTPrincipal");
				texto = doc.createTextNode(gm.getNumeroGuiaSPSADTPrincipal());
				el1.appendChild(texto);
				el.appendChild(el1);
			}
			
			if (gm.getDataAutorizacao() != null) {
				el1 = doc.createElement("ans:dataAutorizacao");
				texto = doc.createTextNode(gm.getDataAutorizacao());
				el1.appendChild(texto);
				el.appendChild(el1);
			}
			
			el1 = doc.createElement("ans:dataRealizacao");
			texto = doc.createTextNode(gm.getDataRealizacao());
			el1.appendChild(texto);
			el.appendChild(el1);
			
			if (gm.getDataInicialFaturamento() != null) {
				el1 = doc.createElement("ans:dataInicialFaturamento");
				texto = doc.createTextNode(gm.getDataInicialFaturamento());
				el1.appendChild(texto);
				el.appendChild(el1);
			}
			
			if (gm.getDataFimPeriodo() != null) {
				el1 = doc.createElement("ans:dataFimPeriodo");
				texto = doc.createTextNode(gm.getDataFimPeriodo());
				el1.appendChild(texto);
				el.appendChild(el1);
			}
			
			el1 = doc.createElement("ans:dataProtocoloCobranca");
			texto = doc.createTextNode(gm.getDataProtocoloCobranca());
			el1.appendChild(texto);
			el.appendChild(el1);
			
			if (gm.getDataPagamento() != null) {
				el1 = doc.createElement("ans:dataPagamento");
				texto = doc.createTextNode(gm.getDataPagamento());
				el1.appendChild(texto);
				el.appendChild(el1);
			}
			
			el1 = doc.createElement("ans:dataProcessamentoGuia");
			texto = doc.createTextNode(gm.getDataProcessamentoGuia());
			el1.appendChild(texto);
			el.appendChild(el1);
			
			if (gm.getTipoConsulta() != null) {
				el1 = doc.createElement("ans:tipoConsulta");
				texto = doc.createTextNode(gm.getTipoConsulta());
				el1.appendChild(texto);
				el.appendChild(el1);
			}
			
			if (gm.getCboExecutante() != null) {
				el1 = doc.createElement("ans:cboExecutante");
				texto = doc.createTextNode(gm.getCboExecutante());
				el1.appendChild(texto);
				el.appendChild(el1);
			}
			
			if (gm.getIndicacaoRecemNato() != null) {
				el1 = doc.createElement("ans:indicacaoRecemNato");
				texto = doc.createTextNode(gm.getIndicacaoRecemNato());
				el1.appendChild(texto);
				el.appendChild(el1);
			}
			
			if (gm.getIndicacaoAcidente() != null) {
				el1 = doc.createElement("ans:indicacaoAcidente");
				texto = doc.createTextNode(gm.getIndicacaoAcidente());
				el1.appendChild(texto);
				el.appendChild(el1);
			}
			
			if (gm.getCaraterAtendimento() != null) {
				el1 = doc.createElement("ans:caraterAtendimento");
				texto = doc.createTextNode(gm.getCaraterAtendimento());
				el1.appendChild(texto);
				el.appendChild(el1);
			}
			
			if (gm.getTipoInternacao() != null) {
				el1 = doc.createElement("ans:tipoInternacao");
				texto = doc.createTextNode(gm.getTipoInternacao());
				el1.appendChild(texto);
				el.appendChild(el1);
			}
			
			if (gm.getRegimeInternacao() != null) {
				el1 = doc.createElement("ans:regimeInternacao");
				texto = doc.createTextNode(gm.getRegimeInternacao());
				el1.appendChild(texto);
				el.appendChild(el1);
			}
			
			if (gm.getDiagnosticosCID10().getDiagnosticoCID() != null) {
				el1 = doc.createElement("ans:diagnosticosCID10");
				el1 = dc.getDiagnosticosCID10(doc, el1, gm.getDiagnosticosCID10());
				el.appendChild(el1);
			}
			
			if (gm.getTipoAtendimento() != null) {
				el1 = doc.createElement("ans:tipoAtendimento");
				texto = doc.createTextNode(gm.getTipoAtendimento());
				el1.appendChild(texto);
				el.appendChild(el1);
			}
			
			if (gm.getTipoFaturamento() != null) {
				el1 = doc.createElement("ans:tipoFaturamento");
				texto = doc.createTextNode(gm.getTipoFaturamento());
				el1.appendChild(texto);
				el.appendChild(el1);
			}
			
			if (gm.getDiariasAcompanhante() != null) {
				el1 = doc.createElement("ans:diariasAcompanhante");
				texto = doc.createTextNode(gm.getDiariasAcompanhante());
				el1.appendChild(texto);
				el.appendChild(el1);
			}
			
			if (gm.getDiariasUTI() != null) {
				el1 = doc.createElement("ans:diariasUTI");
				texto = doc.createTextNode(gm.getDiariasUTI());
				el1.appendChild(texto);
				el.appendChild(el1);
			}
			
			if (gm.getMotivoSaida() != null) {
				el1 = doc.createElement("ans:motivoSaida");
				texto = doc.createTextNode(gm.getMotivoSaida());
				el1.appendChild(texto);
				el.appendChild(el1);
			}
			
			el1 = doc.createElement("ans:valoresGuia");
			el1 = vg.getValoresGuia(doc, el1, gm.getValoresGuia());
			el.appendChild(el1);
			
			if (gm.getDeclaracaoNascido() != null) {
				el1 = doc.createElement("ans:declaracaoNascido");
				texto = doc.createTextNode(gm.getDeclaracaoNascido());
				el1.appendChild(texto);
				el.appendChild(el1);
			}
			
			if (gm.getDeclaracaoObito()!= null) {
				el1 = doc.createElement("ans:declaracaoObito");
				texto = doc.createTextNode(gm.getDeclaracaoObito());
				el1.appendChild(texto);
				el.appendChild(el1);
			}
			
			for (ProcedimentosTo to : gm.getProcedimentos()) {
				el1 = doc.createElement("ans:procedimentos");
				el1 = pc.getProcedimentos(doc, el1, to);
				el.appendChild(el1);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("present.xml.mensagem.operadoraParaAns.guiaMonitotamento.GuiaMonitoramento.getGuiaMonitoramento - e= " + e.toString());
		}
		return el;
	}
	
}
