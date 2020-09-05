package model.dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import model.to.MensagemEnvioANSTo;
import model.to.epilogo.EpilogoTo;
import model.to.mensagem.operadoraParaAns.guiaMonitoramento.GuiaMonitoramentoTo;
import model.to.mensagem.operadoraParaAns.guiaMonitoramento.procedimentos.ProcedimentosTo;

public class EpilogoDao {
	
	public EpilogoTo getEpilogo(MensagemEnvioANSTo mea) {
		EpilogoTo to = null;
		String hash = "";
		try {
			to = new EpilogoTo();
			hash = geraDadosHash(mea);
			to.setHash(this.stringHexa(this.gerarHash(hash, "MD5")));
		} catch (Exception e) {
			System.out.println("model.dao.EpilogoDao.getEpilogo - e= " + e.toString());
		}
		return to;
	}

	private String geraDadosHash(MensagemEnvioANSTo mea) {
		String to = "";
		try {
			to = to + mea.getCabecalho().getIdentificacaoTransacao().getTipoTransacao();
			to = to + mea.getCabecalho().getIdentificacaoTransacao().getNumeroLote();
			to = to + mea.getCabecalho().getIdentificacaoTransacao().getCompetenciaLote();
			to = to + mea.getCabecalho().getIdentificacaoTransacao().getDataRegistroTransacao();
			to = to + mea.getCabecalho().getIdentificacaoTransacao().getHoraRegistroTransacao();
			to = to + mea.getCabecalho().getRegistroANS();
			to = to + mea.getCabecalho().getVersaoPadrao();
			for (GuiaMonitoramentoTo gm : mea.getMensagem().getOperadoraParaANS().getGuiaMonitoramento()) {
				to = to + gm.getTipoRegistro();
				if (gm.getVersaoTISSPrestador() != null) {
					to = to + gm.getVersaoTISSPrestador();
				}
				to = to + gm.getFormaEnvio();
				to = to + gm.getDadosContratadoExecutante().getCNES();
				to = to + gm.getDadosContratadoExecutante().getIdentificadorExecutante();
				to = to + gm.getDadosContratadoExecutante().getCodigoCNPJ_CPF();
				to = to + gm.getDadosContratadoExecutante().getMunicipioExecutante();
				if (gm.getRegistroANSOperadoraIntermediaria() != null) {
					to = to + gm.getRegistroANSOperadoraIntermediaria();
				}
				if (gm.getTipoAtendimentoOperadoraIntermediaria() != null) {
					to = to + gm.getTipoAtendimentoOperadoraIntermediaria();
				}
				/*
				if (gm.getDadosBeneficiario().getIdentBeneficiario().getNumeroCartaoNacionalSaude() != null) {
					to = to + gm.getDadosBeneficiario().getIdentBeneficiario().getNumeroCartaoNacionalSaude();
				} else {
					to = to + gm.getDadosBeneficiario().getIdentBeneficiario().getDadosSemCartao().getSexo();
					to = to + gm.getDadosBeneficiario().getIdentBeneficiario().getDadosSemCartao().getDataNascimento();
					to = to + gm.getDadosBeneficiario().getIdentBeneficiario().getDadosSemCartao().getMunicipioResidencia();
				}
				*/
				if (gm.getDadosBeneficiario().getIdentBeneficiario().getNumeroCartaoNacionalSaude() != null) {
					to = to + gm.getDadosBeneficiario().getIdentBeneficiario().getNumeroCartaoNacionalSaude();
				}
				to = to + gm.getDadosBeneficiario().getIdentBeneficiario().getDadosSemCartao().getSexo();
				to = to + gm.getDadosBeneficiario().getIdentBeneficiario().getDadosSemCartao().getDataNascimento();
				to = to + gm.getDadosBeneficiario().getIdentBeneficiario().getDadosSemCartao().getMunicipioResidencia();
				to = to + gm.getDadosBeneficiario().getNumeroRegistroPlano();
				to = to + gm.getTipoEventoAtencao();
				to = to + gm.getOrigemEventoAtencao();
				to = to + gm.getNumeroGuia_prestador();
				to = to + gm.getNumeroGuia_operadora();
				to = to + gm.getIdentificacaoReembolso();
				if (gm.getIdentificacaoValorPreestabelecido() != null) {
					to = to + gm.getIdentificacaoValorPreestabelecido();
				}
				if (gm.getGuiaSolicitacaoInternacao() != null) {
					to = to + gm.getGuiaSolicitacaoInternacao();
				}
				if (gm.getDataSolicitacao() != null) {
					to = to + gm.getDataSolicitacao();
				}
				if (gm.getNumeroGuiaSPSADTPrincipal() != null) {
					to = to + gm.getNumeroGuiaSPSADTPrincipal();
				}
				if (gm.getDataAutorizacao() != null) {
					to = to + gm.getDataAutorizacao();
				}
				to = to + gm.getDataRealizacao();
				if (gm.getDataInicialFaturamento() != null) {
					to = to + gm.getDataInicialFaturamento();
				}
				if (gm.getDataFimPeriodo() != null) {
					to = to + gm.getDataFimPeriodo();
				}
				to = to + gm.getDataProtocoloCobranca();
				if (gm.getDataPagamento() != null) {
					to = to + gm.getDataPagamento();
				}
				to = to + gm.getDataProcessamentoGuia();
				if (gm.getTipoConsulta() != null) {
					to = to + gm.getTipoConsulta();
				}
				if (gm.getCboExecutante() != null) {
					to = to + gm.getCboExecutante();
				}
				if (gm.getIndicacaoRecemNato() != null) {
					to = to + gm.getIndicacaoRecemNato();
				}
				if (gm.getIndicacaoAcidente() != null) {
					to = to + gm.getIndicacaoAcidente();
				}
				if (gm.getCaraterAtendimento() != null) {
					to = to + gm.getCaraterAtendimento();
				}
				if (gm.getTipoInternacao() != null) {
					to = to + gm.getTipoInternacao();
				}
				if (gm.getRegimeInternacao() != null) {
					to = to + gm.getRegimeInternacao();
				}
				if (gm.getDiagnosticosCID10().getDiagnosticoCID() != null) {
					to = to + gm.getDiagnosticosCID10().getDiagnosticoCID();
				}
				if (gm.getTipoAtendimento() != null) {
					to = to + gm.getTipoAtendimento();					
				}
				if (gm.getTipoFaturamento() != null) {
					to = to + gm.getTipoFaturamento();
				}
				if (gm.getDiariasAcompanhante() != null) {
					to = to + gm.getDiariasAcompanhante();
				}
				if (gm.getDiariasUTI() != null) {
					to = to + gm.getDiariasUTI();
				}
				if (gm.getMotivoSaida() != null) {
					to = to + gm.getMotivoSaida();
				}
				to = to + gm.getValoresGuia().getValorTotalInformado();
				to = to + gm.getValoresGuia().getValorProcessado();
				to = to + gm.getValoresGuia().getValorTotalPagoProcedimentos();
				to = to + gm.getValoresGuia().getValorTotalDiarias();
				to = to + gm.getValoresGuia().getValorTotalTaxas();
				to = to + gm.getValoresGuia().getValorTotalMateriais();
				to = to + gm.getValoresGuia().getValorTotalOPME();
				to = to + gm.getValoresGuia().getValorTotalMedicamentos();
				to = to + gm.getValoresGuia().getValorGlosaGuia();
				to = to + gm.getValoresGuia().getValorPagoGuia();
				to = to + gm.getValoresGuia().getValorPagoFornecedores();
				to = to + gm.getValoresGuia().getValorTotalTabelaPropria();
				to = to + gm.getValoresGuia().getValorTotalCoParticipacao();
				if (gm.getDeclaracaoNascido() != null) {
					to = to + gm.getDeclaracaoNascido();
				}
				if (gm.getDeclaracaoObito()!= null) {
					to = to + gm.getDeclaracaoObito();
				}
				
				for (ProcedimentosTo pcd : gm.getProcedimentos()) {
					to = to + pcd.getIdentProcedimento().getCodigoTabela();
					if (pcd.getIdentProcedimento().getProcedimento().getGrupoProcedimento() != null) {
						to = to + pcd.getIdentProcedimento().getProcedimento().getGrupoProcedimento();
					} else {
						to = to + pcd.getIdentProcedimento().getProcedimento().getCodigoProcedimento();
					}
					if (pcd.getDenteRegiao().getCodDente() != null || pcd.getDenteRegiao().getCodRegiao() != null) {
						if (pcd.getDenteRegiao().getCodDente() != null) {
							to = to + pcd.getDenteRegiao().getCodDente();
						} else if (pcd.getDenteRegiao().getCodRegiao() != null) {
							to = to + pcd.getDenteRegiao().getCodRegiao();
						}
					}
					if (pcd.getDenteFace() != null) {
						to = to + pcd.getDenteFace();
					}
					to = to + pcd.getQuantidadeInformada();
					to = to + pcd.getValorInformado();
					to = to + pcd.getQuantidadePaga();
					to = to + pcd.getValorPagoProc();
					to = to + pcd.getValorPagoFornecedor();
					if (pcd.getCNPJFornecedor() != null) {
						to = to + pcd.getCNPJFornecedor();
					}
					to = to + pcd.getValorCoParticipacao();
					if (pcd.getDetalhePacote().getCodigoProcedimento() != null) {
						to = to + pcd.getDetalhePacote().getCodigoTabela();
						to = to + pcd.getDetalhePacote().getCodigoProcedimento();
						to = to + pcd.getDetalhePacote().getQuantidade();
					}
					
				}
						
			}
		} catch (Exception e) {
			System.out.println("model.dao.EpilogoDao.geraDadosHash - e= " + e.toString());
		}
		return to;
	}
	
	private String stringHexa(byte[] bytes) {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < bytes.length; i++) {
			int parteAlta = ((bytes[i] >> 4) & 0xf) << 4;
			int parteBaixa = bytes[i] & 0xf;
			if (parteAlta == 0) s.append('0');
			s.append(Integer.toHexString(parteAlta | parteBaixa));
		}
		return s.toString();
	}

	private byte[] gerarHash(String frase, String algoritmo) {
		try {
			MessageDigest md = MessageDigest.getInstance(algoritmo);
			md.update(frase.getBytes());
			return md.digest();
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
	}
	
}
