package model.to.mensagem.operadoraParaAns.guiaMonitoramento;

import java.util.List;

import model.to.mensagem.operadoraParaAns.guiaMonitoramento.dadosBeneficiario.DadosBeneficiarioTo;
import model.to.mensagem.operadoraParaAns.guiaMonitoramento.dadosContratadoExecutante.DadosContratadoExecutanteTo;
import model.to.mensagem.operadoraParaAns.guiaMonitoramento.diagnosticosCID10.DiagnosticosCID10To;
import model.to.mensagem.operadoraParaAns.guiaMonitoramento.procedimentos.ProcedimentosTo;
import model.to.mensagem.operadoraParaAns.guiaMonitoramento.valoresGuia.ValoresGuiaTo;

public class GuiaMonitoramentoTo {

	private String tipoRegistro;
	private String versaoTISSPrestador;
	private String formaEnvio;
	private DadosContratadoExecutanteTo dadosContratadoExecutante;
	private String registroANSOperadoraIntermediaria;
	private String tipoAtendimentoOperadoraIntermediaria;
	private DadosBeneficiarioTo dadosBeneficiario;
	private String tipoEventoAtencao;
	private String origemEventoAtencao;
	private String numeroGuia_prestador;
	private String numeroGuia_operadora;
	private String identificacaoReembolso;
	private String identificacaoValorPreestabelecido;
	private String guiaSolicitacaoInternacao;
	private String dataSolicitacao;
	private String numeroGuiaSPSADTPrincipal;
	private String dataAutorizacao;
	private String dataRealizacao;
	private String dataInicialFaturamento;
	private String dataFimPeriodo;
	private String dataProtocoloCobranca;
	private String dataPagamento;
	private String dataProcessamentoGuia;
	private String tipoConsulta;
	private String cboExecutante;
	private String indicacaoRecemNato;
	private String indicacaoAcidente;
	private String caraterAtendimento;
	private String tipoInternacao;
	private String regimeInternacao;
	private DiagnosticosCID10To diagnosticosCID10;
	private String tipoAtendimento;
	private String tipoFaturamento;
	private String diariasAcompanhante;
	private String diariasUTI;
	private String motivoSaida;
	private ValoresGuiaTo valoresGuia;
	private String declaracaoNascido;
	private String declaracaoObito;
	private List<ProcedimentosTo> procedimentos;
	private String matricula; //Exclusivo CESAN
	
	public String getTipoRegistro() {
		return tipoRegistro;
	}
	public void setTipoRegistro(String tipoRegistro) {
		this.tipoRegistro = tipoRegistro;
	}
	public String getVersaoTISSPrestador() {
		return versaoTISSPrestador;
	}
	public void setVersaoTISSPrestador(String versaoTISSPrestador) {
		this.versaoTISSPrestador = versaoTISSPrestador;
	}
	public String getFormaEnvio() {
		return formaEnvio;
	}
	public void setFormaEnvio(String formaEnvio) {
		this.formaEnvio = formaEnvio;
	}
	public DadosContratadoExecutanteTo getDadosContratadoExecutante() {
		return dadosContratadoExecutante;
	}
	public void setDadosContratadoExecutante(
			DadosContratadoExecutanteTo dadosContratadoExecutante) {
		this.dadosContratadoExecutante = dadosContratadoExecutante;
	}
	public String getRegistroANSOperadoraIntermediaria() {
		return registroANSOperadoraIntermediaria;
	}
	public void setRegistroANSOperadoraIntermediaria(
			String registroANSOperadoraIntermediaria) {
		this.registroANSOperadoraIntermediaria = registroANSOperadoraIntermediaria;
	}
	public String getTipoAtendimentoOperadoraIntermediaria() {
		return tipoAtendimentoOperadoraIntermediaria;
	}
	public void setTipoAtendimentoOperadoraIntermediaria(
			String tipoAtendimentoOperadoraIntermediaria) {
		this.tipoAtendimentoOperadoraIntermediaria = tipoAtendimentoOperadoraIntermediaria;
	}
	public DadosBeneficiarioTo getDadosBeneficiario() {
		return dadosBeneficiario;
	}
	public void setDadosBeneficiario(DadosBeneficiarioTo dadosBeneficiario) {
		this.dadosBeneficiario = dadosBeneficiario;
	}
	public String getTipoEventoAtencao() {
		return tipoEventoAtencao;
	}
	public void setTipoEventoAtencao(String tipoEventoAtencao) {
		this.tipoEventoAtencao = tipoEventoAtencao;
	}
	public String getOrigemEventoAtencao() {
		return origemEventoAtencao;
	}
	public void setOrigemEventoAtencao(String origemEventoAtencao) {
		this.origemEventoAtencao = origemEventoAtencao;
	}
	public String getNumeroGuia_prestador() {
		return numeroGuia_prestador;
	}
	public void setNumeroGuia_prestador(String numeroGuia_prestador) {
		this.numeroGuia_prestador = numeroGuia_prestador;
	}
	public String getNumeroGuia_operadora() {
		return numeroGuia_operadora;
	}
	public void setNumeroGuia_operadora(String numeroGuia_operadora) {
		this.numeroGuia_operadora = numeroGuia_operadora;
	}
	public String getIdentificacaoReembolso() {
		return identificacaoReembolso;
	}
	public void setIdentificacaoReembolso(String identificacaoReembolso) {
		this.identificacaoReembolso = identificacaoReembolso;
	}
	public String getIdentificacaoValorPreestabelecido() {
		return identificacaoValorPreestabelecido;
	}
	public void setIdentificacaoValorPreestabelecido(
			String identificacaoValorPreestabelecido) {
		this.identificacaoValorPreestabelecido = identificacaoValorPreestabelecido;
	}
	public String getGuiaSolicitacaoInternacao() {
		return guiaSolicitacaoInternacao;
	}
	public void setGuiaSolicitacaoInternacao(String guiaSolicitacaoInternacao) {
		this.guiaSolicitacaoInternacao = guiaSolicitacaoInternacao;
	}
	public String getDataSolicitacao() {
		return dataSolicitacao;
	}
	public void setDataSolicitacao(String dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}
	public String getNumeroGuiaSPSADTPrincipal() {
		return numeroGuiaSPSADTPrincipal;
	}
	public void setNumeroGuiaSPSADTPrincipal(String numeroGuiaSPSADTPrincipal) {
		this.numeroGuiaSPSADTPrincipal = numeroGuiaSPSADTPrincipal;
	}
	public String getDataAutorizacao() {
		return dataAutorizacao;
	}
	public void setDataAutorizacao(String dataAutorizacao) {
		this.dataAutorizacao = dataAutorizacao;
	}
	public String getDataRealizacao() {
		return dataRealizacao;
	}
	public void setDataRealizacao(String dataRealizacao) {
		this.dataRealizacao = dataRealizacao;
	}
	public String getDataInicialFaturamento() {
		return dataInicialFaturamento;
	}
	public void setDataInicialFaturamento(String dataInicialFaturamento) {
		this.dataInicialFaturamento = dataInicialFaturamento;
	}
	public String getDataFimPeriodo() {
		return dataFimPeriodo;
	}
	public void setDataFimPeriodo(String dataFimPeriodo) {
		this.dataFimPeriodo = dataFimPeriodo;
	}
	public String getDataProtocoloCobranca() {
		return dataProtocoloCobranca;
	}
	public void setDataProtocoloCobranca(String dataProtocoloCobranca) {
		this.dataProtocoloCobranca = dataProtocoloCobranca;
	}
	public String getDataPagamento() {
		return dataPagamento;
	}
	public void setDataPagamento(String dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	public String getDataProcessamentoGuia() {
		return dataProcessamentoGuia;
	}
	public void setDataProcessamentoGuia(String dataProcessamentoGuia) {
		this.dataProcessamentoGuia = dataProcessamentoGuia;
	}
	public String getTipoConsulta() {
		return tipoConsulta;
	}
	public void setTipoConsulta(String tipoConsulta) {
		this.tipoConsulta = tipoConsulta;
	}
	public String getCboExecutante() {
		return cboExecutante;
	}
	public void setCboExecutante(String cboExecutante) {
		this.cboExecutante = cboExecutante;
	}
	public String getIndicacaoRecemNato() {
		return indicacaoRecemNato;
	}
	public void setIndicacaoRecemNato(String indicacaoRecemNato) {
		this.indicacaoRecemNato = indicacaoRecemNato;
	}
	public String getIndicacaoAcidente() {
		return indicacaoAcidente;
	}
	public void setIndicacaoAcidente(String indicacaoAcidente) {
		this.indicacaoAcidente = indicacaoAcidente;
	}
	public String getCaraterAtendimento() {
		return caraterAtendimento;
	}
	public void setCaraterAtendimento(String caraterAtendimento) {
		this.caraterAtendimento = caraterAtendimento;
	}
	public String getTipoInternacao() {
		return tipoInternacao;
	}
	public void setTipoInternacao(String tipoInternacao) {
		this.tipoInternacao = tipoInternacao;
	}
	public String getRegimeInternacao() {
		return regimeInternacao;
	}
	public void setRegimeInternacao(String regimeInternacao) {
		this.regimeInternacao = regimeInternacao;
	}
	public DiagnosticosCID10To getDiagnosticosCID10() {
		return diagnosticosCID10;
	}
	public void setDiagnosticosCID10(DiagnosticosCID10To diagnosticosCID10) {
		this.diagnosticosCID10 = diagnosticosCID10;
	}
	public String getTipoAtendimento() {
		return tipoAtendimento;
	}
	public void setTipoAtendimento(String tipoAtendimento) {
		this.tipoAtendimento = tipoAtendimento;
	}
	public String getTipoFaturamento() {
		return tipoFaturamento;
	}
	public void setTipoFaturamento(String tipoFaturamento) {
		this.tipoFaturamento = tipoFaturamento;
	}
	public String getDiariasAcompanhante() {
		return diariasAcompanhante;
	}
	public void setDiariasAcompanhante(String diariasAcompanhante) {
		this.diariasAcompanhante = diariasAcompanhante;
	}
	public String getDiariasUTI() {
		return diariasUTI;
	}
	public void setDiariasUTI(String diariasUTI) {
		this.diariasUTI = diariasUTI;
	}
	public String getMotivoSaida() {
		return motivoSaida;
	}
	public void setMotivoSaida(String motivoSaida) {
		this.motivoSaida = motivoSaida;
	}
	public ValoresGuiaTo getValoresGuia() {
		return valoresGuia;
	}
	public void setValoresGuia(ValoresGuiaTo valoresGuia) {
		this.valoresGuia = valoresGuia;
	}
	public String getDeclaracaoNascido() {
		return declaracaoNascido;
	}
	public void setDeclaracaoNascido(String declaracaoNascido) {
		this.declaracaoNascido = declaracaoNascido;
	}
	public String getDeclaracaoObito() {
		return declaracaoObito;
	}
	public void setDeclaracaoObito(String declaracaoObito) {
		this.declaracaoObito = declaracaoObito;
	}
	public List<ProcedimentosTo> getProcedimentos() {
		return procedimentos;
	}
	public void setProcedimentos(List<ProcedimentosTo> procedimentos) {
		this.procedimentos = procedimentos;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
}
