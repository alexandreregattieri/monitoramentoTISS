package model.to.mensagem.operadoraParaAns.guiaMonitoramento.procedimentos;

public class ProcedimentosTo {

	private IdentProcedimentoTo identProcedimento;
	private DenteRegiaoTo denteRegiao;
	private String denteFace;
	private String quantidadeInformada;
	private String valorInformado;
	private String quantidadePaga;
	private String valorPagoProc;
	private String valorPagoFornecedor;
	private String CNPJFornecedor;
	private String valorCoParticipacao;
	private DetalhePacoteTo detalhePacote;
	private String linha;

	public IdentProcedimentoTo getIdentProcedimento() {
		return identProcedimento;
	}
	public void setIdentProcedimento(IdentProcedimentoTo identProcedimento) {
		this.identProcedimento = identProcedimento;
	}
	public DenteRegiaoTo getDenteRegiao() {
		return denteRegiao;
	}
	public void setDenteRegiao(DenteRegiaoTo denteRegiao) {
		this.denteRegiao = denteRegiao;
	}
	public String getDenteFace() {
		return denteFace;
	}
	public void setDenteFace(String denteFace) {
		this.denteFace = denteFace;
	}
	public String getQuantidadeInformada() {
		return quantidadeInformada;
	}
	public void setQuantidadeInformada(String quantidadeInformada) {
		this.quantidadeInformada = quantidadeInformada;
	}
	public String getValorInformado() {
		return valorInformado;
	}
	public void setValorInformado(String valorInformado) {
		this.valorInformado = valorInformado;
	}
	public String getQuantidadePaga() {
		return quantidadePaga;
	}
	public void setQuantidadePaga(String quantidadePaga) {
		this.quantidadePaga = quantidadePaga;
	}
	public String getValorPagoProc() {
		return valorPagoProc;
	}
	public void setValorPagoProc(String valorPagoProc) {
		this.valorPagoProc = valorPagoProc;
	}
	public String getValorPagoFornecedor() {
		return valorPagoFornecedor;
	}
	public void setValorPagoFornecedor(String valorPagoFornecedor) {
		this.valorPagoFornecedor = valorPagoFornecedor;
	}
	public String getCNPJFornecedor() {
		return CNPJFornecedor;
	}
	public void setCNPJFornecedor(String cNPJFornecedor) {
		CNPJFornecedor = cNPJFornecedor;
	}
	public String getValorCoParticipacao() {
		return valorCoParticipacao;
	}
	public void setValorCoParticipacao(String valorCoParticipacao) {
		this.valorCoParticipacao = valorCoParticipacao;
	}
	public DetalhePacoteTo getDetalhePacote() {
		return detalhePacote;
	}
	public void setDetalhePacote(DetalhePacoteTo detalhePacote) {
		this.detalhePacote = detalhePacote;
	}
	public String getLinha() {
		return linha;
	}
	public void setLinha(String linha) {
		this.linha = linha;
	}
	
}
