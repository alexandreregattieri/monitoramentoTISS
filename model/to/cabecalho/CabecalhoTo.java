package model.to.cabecalho;

public class CabecalhoTo {

	private IdentificacaoTransacaoTo identificacaoTransacao;
	private String registroANS;
	private String versaoPadrao;
	
	public IdentificacaoTransacaoTo getIdentificacaoTransacao() {
		return identificacaoTransacao;
	}
	public void setIdentificacaoTransacao(
			IdentificacaoTransacaoTo identificacaoTransacao) {
		this.identificacaoTransacao = identificacaoTransacao;
	}
	public String getRegistroANS() {
		return registroANS;
	}
	public void setRegistroANS(String registroANS) {
		this.registroANS = registroANS;
	}
	public String getVersaoPadrao() {
		return versaoPadrao;
	}
	public void setVersaoPadrao(String versaoPadrao) {
		this.versaoPadrao = versaoPadrao;
	}
	
}
