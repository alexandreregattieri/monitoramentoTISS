package principal;

import present.GeraXml;

public class Principal {

	public static void main(String[] args) {
		GeraXml gx = null;
		String mes = "12";
		String ano = "2017";
		String plano = "2";
		String lote = "8074"; // CESAN: 9934 - VIVA+: 8072
		String guias = null;
		String excluir = null;
		String caminho = "D:/BaseTISSteste.xls";
		try {
			gx = new GeraXml();
			gx.getMonitoramentoTiss(mes, ano, plano, lote, guias, excluir, caminho);
			System.out.println(">>>> Processo Finalizado! <<<<");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

}
