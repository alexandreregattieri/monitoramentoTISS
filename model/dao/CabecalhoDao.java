package model.dao;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import model.to.cabecalho.CabecalhoTo;
import model.to.cabecalho.IdentificacaoTransacaoTo;

public class CabecalhoDao {
	
	public CabecalhoTo getCabecalho(String ano, String mes, String plano, String lote) {
		CabecalhoTo to = null;
		IdentificacaoTransacaoTo it = null;
		try {
			to = new CabecalhoTo();
			it = new IdentificacaoTransacaoTo();
			it = getIdentificacao(ano, mes, lote);
			to.setIdentificacaoTransacao(it);
			if ("1".equals(plano)) {
				to.setRegistroANS("392405");
			} else {
				to.setRegistroANS("329665");
			}
			//to.setVersaoPadrao("3.03.03");
			to.setVersaoPadrao("1.00.00");
		} catch (Exception e) {
			System.out.println("model.dao.CabecalhoDao.getCabecalho - e= " + e.toString());
		}
		return to;
	}

	public IdentificacaoTransacaoTo getIdentificacao(String ano, String mes, String lote) {
		IdentificacaoTransacaoTo to = null;
		Date data = null;
		SimpleDateFormat sdf = null;
		SimpleDateFormat sdh = null;
		String aux = "";
		try {
			data = Calendar.getInstance().getTime();
			sdf = new SimpleDateFormat("yyyy-MM-dd");
			sdh = new SimpleDateFormat("HH:mm:ss");
			to = new IdentificacaoTransacaoTo();
			to.setTipoTransacao("MONITORAMENTO");
			to.setNumeroLote(lote);
			aux = "00" + mes;
			mes = aux.substring(aux.length() - 2);
			to.setCompetenciaLote(ano + mes);
			to.setDataRegistroTransacao(sdf.format(data));
			to.setHoraRegistroTransacao(sdh.format(data));
		} catch (Exception e) {
			System.out.println("model.dao.CabecalhoDao.getIdentificacao - e= " + e.toString());
		}
		return to;
	}
	
}
