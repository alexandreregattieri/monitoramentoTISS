package model.to.cabecalho;

public class IdentificacaoTransacaoTo {
	
	private String tipoTransacao;
	private String numeroLote;
	private String competenciaLote;
	private String dataRegistroTransacao;
	private String horaRegistroTransacao;
	
	public String getTipoTransacao() {
		return tipoTransacao;
	}
	public void setTipoTransacao(String tipoTransacao) {
		this.tipoTransacao = tipoTransacao;
	}
	public String getNumeroLote() {
		return numeroLote;
	}
	public void setNumeroLote(String numeroLote) {
		this.numeroLote = numeroLote;
	}
	public String getCompetenciaLote() {
		return competenciaLote;
	}
	public void setCompetenciaLote(String competenciaLote) {
		this.competenciaLote = competenciaLote;
	}
	public String getDataRegistroTransacao() {
		return dataRegistroTransacao;
	}
	public void setDataRegistroTransacao(String dataRegistroTransacao) {
		this.dataRegistroTransacao = dataRegistroTransacao;
	}
	public String getHoraRegistroTransacao() {
		return horaRegistroTransacao;
	}
	public void setHoraRegistroTransacao(String horaRegistroTransacao) {
		this.horaRegistroTransacao = horaRegistroTransacao;
	}


}
