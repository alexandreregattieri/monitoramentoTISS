package model.to.mensagem.operadoraParaAns.guiaMonitoramento.dadosContratadoExecutante;

public class DadosContratadoExecutanteTo {

	private String CNES;
	private String identificadorExecutante;
	private String codigoCNPJ_CPF;
	private String municipioExecutante;
	
	public String getCNES() {
		return CNES;
	}
	public void setCNES(String cNES) {
		CNES = cNES;
	}
	public String getIdentificadorExecutante() {
		return identificadorExecutante;
	}
	public void setIdentificadorExecutante(String identificadorExecutante) {
		this.identificadorExecutante = identificadorExecutante;
	}
	public String getCodigoCNPJ_CPF() {
		return codigoCNPJ_CPF;
	}
	public void setCodigoCNPJ_CPF(String codigoCNPJ_CPF) {
		this.codigoCNPJ_CPF = codigoCNPJ_CPF;
	}
	public String getMunicipioExecutante() {
		return municipioExecutante;
	}
	public void setMunicipioExecutante(String municipioExecutante) {
		this.municipioExecutante = municipioExecutante;
	}

	
}
