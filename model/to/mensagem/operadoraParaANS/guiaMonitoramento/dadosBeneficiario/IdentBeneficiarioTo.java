package model.to.mensagem.operadoraParaAns.guiaMonitoramento.dadosBeneficiario;

public class IdentBeneficiarioTo {

	private String numeroCartaoNacionalSaude;
	private DadosSemCartaoTo dadosSemCartao;
	
	public String getNumeroCartaoNacionalSaude() {
		return numeroCartaoNacionalSaude;
	}
	public void setNumeroCartaoNacionalSaude(String numeroCartaoNacionalSaude) {
		this.numeroCartaoNacionalSaude = numeroCartaoNacionalSaude;
	}
	public DadosSemCartaoTo getDadosSemCartao() {
		return dadosSemCartao;
	}
	public void setDadosSemCartao(DadosSemCartaoTo dadosSemCartao) {
		this.dadosSemCartao = dadosSemCartao;
	}
	
}
