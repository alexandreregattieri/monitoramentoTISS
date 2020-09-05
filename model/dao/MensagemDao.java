package model.dao;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import model.to.mensagem.MensagemTo;
import model.to.mensagem.operadoraParaAns.OperadoraParaANSTo;
import model.to.mensagem.operadoraParaAns.guiaMonitoramento.GuiaMonitoramentoTo;
import model.to.mensagem.operadoraParaAns.guiaMonitoramento.dadosBeneficiario.DadosBeneficiarioTo;
import model.to.mensagem.operadoraParaAns.guiaMonitoramento.dadosBeneficiario.DadosSemCartaoTo;
import model.to.mensagem.operadoraParaAns.guiaMonitoramento.dadosBeneficiario.IdentBeneficiarioTo;
import model.to.mensagem.operadoraParaAns.guiaMonitoramento.dadosContratadoExecutante.DadosContratadoExecutanteTo;
import model.to.mensagem.operadoraParaAns.guiaMonitoramento.diagnosticosCID10.DiagnosticosCID10To;
import model.to.mensagem.operadoraParaAns.guiaMonitoramento.procedimentos.DenteRegiaoTo;
import model.to.mensagem.operadoraParaAns.guiaMonitoramento.procedimentos.DetalhePacoteTo;
import model.to.mensagem.operadoraParaAns.guiaMonitoramento.procedimentos.IdentProcedimentoTo;
import model.to.mensagem.operadoraParaAns.guiaMonitoramento.procedimentos.ProcedimentoTo;
import model.to.mensagem.operadoraParaAns.guiaMonitoramento.procedimentos.ProcedimentosTo;
import model.to.mensagem.operadoraParaAns.guiaMonitoramento.valoresGuia.ValoresGuiaTo;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DateUtil;

import conexao.Conexao;


public class MensagemDao {

	public MensagemTo getMensagem(String mes, String ano, String plano, String guia, String excluir) throws Exception {
		Conexao con = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		StringBuilder sql = new StringBuilder();
		sql.append(" ");
		//
		MensagemTo to = null;
		OperadoraParaANSTo opa = null;
		List<GuiaMonitoramentoTo> guias = null;
		GuiaMonitoramentoTo gm = null;
		DadosContratadoExecutanteTo dce = null;
		DadosBeneficiarioTo dbf = null;
		IdentBeneficiarioTo ibf = null;
		DadosSemCartaoTo dsc = null;
		DiagnosticosCID10To dcd = null;
		ValoresGuiaTo vlg = null;
		List<ProcedimentosTo> proceds = null;
		String auxPto = null;
		String auxAno = null;
		String auxFat = null;
		try {
			con = new Conexao();
			conn = con.getConexao();
			stmt = conn.prepareStatement(sql.toString());
			rs = stmt.executeQuery();
			//
			to = new MensagemTo();
			opa = new OperadoraParaANSTo();
			guias = new ArrayList<GuiaMonitoramentoTo>();
			
			while (rs.next()) {
				gm = new GuiaMonitoramentoTo();
				gm.setTipoRegistro(rs.getString(1));
				gm.setVersaoTISSPrestador(rs.getString(2));
				gm.setFormaEnvio(rs.getString(3));
				dce = new DadosContratadoExecutanteTo();
				dce.setCNES(rs.getString(5));
				dce.setIdentificadorExecutante(rs.getString(6));
				dce.setCodigoCNPJ_CPF(rs.getString(7));
				dce.setMunicipioExecutante(rs.getString(8));
				gm.setDadosContratadoExecutante(dce);
				gm.setRegistroANSOperadoraIntermediaria(rs.getString(9));
				gm.setTipoAtendimentoOperadoraIntermediaria(rs.getString(10));
				dbf = new DadosBeneficiarioTo();
				ibf = new IdentBeneficiarioTo();
				ibf.setNumeroCartaoNacionalSaude(rs.getString(13));
				dsc = new DadosSemCartaoTo();
				dsc.setSexo(rs.getString(15));
				dsc.setDataNascimento(rs.getString(16));
				dsc.setMunicipioResidencia(rs.getString(17));
				ibf.setDadosSemCartao(dsc);
				dbf.setIdentBeneficiario(ibf);
				dbf.setNumeroRegistroPlano(rs.getString(18));
				gm.setDadosBeneficiario(dbf);
				gm.setTipoEventoAtencao(rs.getString(19));
				gm.setOrigemEventoAtencao(rs.getString(20));
				gm.setNumeroGuia_prestador(rs.getString(21));
				gm.setNumeroGuia_operadora(rs.getString(22));
				gm.setIdentificacaoReembolso(rs.getString(23));
				gm.setIdentificacaoValorPreestabelecido(rs.getString(24));
				gm.setGuiaSolicitacaoInternacao(rs.getString(25));
				gm.setDataSolicitacao(rs.getString(26));
				gm.setNumeroGuiaSPSADTPrincipal(rs.getString(27));
				gm.setDataAutorizacao(rs.getString(28));
				gm.setDataRealizacao(rs.getString(29));
				gm.setDataInicialFaturamento(rs.getString(30));
				gm.setDataFimPeriodo(rs.getString(31));
				gm.setDataProtocoloCobranca(rs.getString(32));
				gm.setDataPagamento(rs.getString(33));
				gm.setDataProcessamentoGuia(rs.getString(34));
				gm.setTipoConsulta(rs.getString(35));
				gm.setCboExecutante(rs.getString(36));
				gm.setIndicacaoRecemNato(rs.getString(37));
				gm.setIndicacaoAcidente(rs.getString(38));
				gm.setCaraterAtendimento(rs.getString(39));
				gm.setTipoInternacao(rs.getString(40));
				gm.setRegimeInternacao(rs.getString(41));
				dcd = new DiagnosticosCID10To();
				dcd.setDiagnosticoCID(rs.getString(43));
				gm.setDiagnosticosCID10(dcd);
				gm.setTipoAtendimento(rs.getString(44));
				gm.setTipoFaturamento(rs.getString(45));
				gm.setDiariasAcompanhante(rs.getString(46));
				gm.setDiariasUTI(rs.getString(47));
				gm.setMotivoSaida(rs.getString(48));
				gm.setDeclaracaoNascido(rs.getString(49));
				gm.setDeclaracaoObito(rs.getString(50));
				auxPto = rs.getString(51);
				auxAno = rs.getString(52);
				auxFat = rs.getString(53);
				gm.setMatricula(rs.getString(54));
				vlg = new ValoresGuiaTo();
				vlg = getValores(auxPto, auxAno, auxFat);
				gm.setValoresGuia(vlg);
				proceds = new ArrayList<ProcedimentosTo>();
				proceds = getProcedimentos(auxPto, auxAno, auxFat);
				gm.setProcedimentos(proceds);
				guias.add(gm);
			}
			opa.setGuiaMonitoramento(guias);
			to.setOperadoraParaANS(opa);
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("model.dao.MensagemDao.getMensagem - e= " + e.toString());
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				System.out.println("model.dao.MensagemDao.getMensagem - e= " + e.toString());
			}
		}
		return to;
	}
	
	public MensagemTo getMensagemXls(String caminho) throws Exception {
		InputStream is = null;
		HSSFWorkbook work = null;
		HSSFSheet sheet = null;
		HSSFRow row = null;
		HSSFCell cel = null;
		int h = 0;
		int i = 1;
		int j = 1;
		//
		MensagemTo to = null;
		OperadoraParaANSTo opa = null;
		List<GuiaMonitoramentoTo> guias = null;
		GuiaMonitoramentoTo gm = null;
		DadosContratadoExecutanteTo dce = null;
		DadosBeneficiarioTo dbf = null;
		IdentBeneficiarioTo ibf = null;
		DadosSemCartaoTo dsc = null;
		DiagnosticosCID10To dcd = null;
		ValoresGuiaTo vlg = null;
		List<ProcedimentosTo> proceds = null;
		String auxPto = null;
		String auxAno = null;
		String auxFat = null;
		String ret = null;
		try {
			to = new MensagemTo();
			opa = new OperadoraParaANSTo();
			guias = new ArrayList<GuiaMonitoramentoTo>();
			
			is = new FileInputStream(caminho);
			work = new HSSFWorkbook(is);
			sheet = work.getSheetAt(0);
			h = 0;
			i = 1;
			j = 1;
			while (h == 0) {
				row = sheet.getRow(i);
				if (row != null) {
					cel = row.getCell(0);
					if (cel != null) {
						ret = this.pegaDadosCelula(cel);
						gm = new GuiaMonitoramentoTo();
						gm.setTipoRegistro(ret);
						
						cel = row.getCell(1);
						ret = this.pegaDadosCelula(cel);
						gm.setVersaoTISSPrestador(ret);
						
						cel = row.getCell(2);
						ret = this.pegaDadosCelula(cel);
						gm.setFormaEnvio(ret);
						
						cel = row.getCell(4);
						ret = this.pegaDadosCelula(cel);
						dce = new DadosContratadoExecutanteTo();
						dce.setCNES(ret);
						
						cel = row.getCell(5);
						ret = this.pegaDadosCelula(cel);
						dce.setIdentificadorExecutante(ret);
						
						cel = row.getCell(6);
						ret = this.pegaDadosCelula(cel);
						dce.setCodigoCNPJ_CPF(ret);
						
						cel = row.getCell(7);
						ret = this.pegaDadosCelula(cel);
						dce.setMunicipioExecutante(ret);
						gm.setDadosContratadoExecutante(dce);
						
						cel = row.getCell(8);
						ret = this.pegaDadosCelula(cel);
						gm.setRegistroANSOperadoraIntermediaria(ret);
						
						cel = row.getCell(9);
						ret = this.pegaDadosCelula(cel);
						gm.setTipoAtendimentoOperadoraIntermediaria(ret);
						
						cel = row.getCell(12);
						ret = this.pegaDadosCelula(cel);
						dbf = new DadosBeneficiarioTo();
						ibf = new IdentBeneficiarioTo();
						ibf.setNumeroCartaoNacionalSaude(ret);
						
						cel = row.getCell(14);
						ret = this.pegaDadosCelula(cel);
						dsc = new DadosSemCartaoTo();
						dsc.setSexo(ret);
						
						cel = row.getCell(15);
						ret = this.pegaDadosCelula(cel);
						dsc.setDataNascimento(ret);
						
						cel = row.getCell(16);
						ret = this.pegaDadosCelula(cel);
						dsc.setMunicipioResidencia(ret);
						ibf.setDadosSemCartao(dsc);
						dbf.setIdentBeneficiario(ibf);
						
						cel = row.getCell(17);
						ret = this.pegaDadosCelula(cel);
						dbf.setNumeroRegistroPlano(ret);
						gm.setDadosBeneficiario(dbf);
						
						cel = row.getCell(18);
						ret = this.pegaDadosCelula(cel);
						gm.setTipoEventoAtencao(ret);
						
						cel = row.getCell(19);
						ret = this.pegaDadosCelula(cel);
						gm.setOrigemEventoAtencao(ret);
						
						cel = row.getCell(20);
						ret = this.pegaDadosCelula(cel);
						gm.setNumeroGuia_prestador(ret);
						
						cel = row.getCell(21);
						ret = this.pegaDadosCelula(cel);
						gm.setNumeroGuia_operadora(ret);
						
						cel = row.getCell(22);
						ret = this.pegaDadosCelula(cel);
						gm.setIdentificacaoReembolso(ret);
						
						cel = row.getCell(23);
						ret = this.pegaDadosCelula(cel);
						gm.setIdentificacaoValorPreestabelecido(ret);
						
						cel = row.getCell(24);
						ret = this.pegaDadosCelula(cel);
						gm.setGuiaSolicitacaoInternacao(ret);
						
						cel = row.getCell(25);
						ret = this.pegaDadosCelula(cel);
						gm.setDataSolicitacao(ret);
						
						cel = row.getCell(26);
						ret = this.pegaDadosCelula(cel);
						gm.setNumeroGuiaSPSADTPrincipal(ret);
						
						cel = row.getCell(27);
						ret = this.pegaDadosCelula(cel);
						gm.setDataAutorizacao(ret);
						
						cel = row.getCell(28);
						ret = this.pegaDadosCelula(cel);
						gm.setDataRealizacao(ret);
						
						cel = row.getCell(29);
						ret = this.pegaDadosCelula(cel);
						gm.setDataInicialFaturamento(ret);
						
						cel = row.getCell(30);
						ret = this.pegaDadosCelula(cel);
						gm.setDataFimPeriodo(ret);
						
						cel = row.getCell(31);
						ret = this.pegaDadosCelula(cel);
						gm.setDataProtocoloCobranca(ret);
						
						cel = row.getCell(32);
						ret = this.pegaDadosCelula(cel);
						gm.setDataPagamento(ret);
						
						cel = row.getCell(33);
						ret = this.pegaDadosCelula(cel);
						gm.setDataProcessamentoGuia(ret);
						
						cel = row.getCell(34);
						ret = this.pegaDadosCelula(cel);
						gm.setTipoConsulta(ret);
						
						cel = row.getCell(35);
						ret = this.pegaDadosCelula(cel);
						gm.setCboExecutante(ret);
						
						cel = row.getCell(36);
						ret = this.pegaDadosCelula(cel);
						gm.setIndicacaoRecemNato(ret);
						
						cel = row.getCell(37);
						ret = this.pegaDadosCelula(cel);
						gm.setIndicacaoAcidente(ret);
						
						cel = row.getCell(38);
						ret = this.pegaDadosCelula(cel);
						gm.setCaraterAtendimento(ret);
						
						cel = row.getCell(39);
						ret = this.pegaDadosCelula(cel);
						gm.setTipoInternacao(ret);
						
						cel = row.getCell(40);
						ret = this.pegaDadosCelula(cel);
						gm.setRegimeInternacao(ret);
						
						cel = row.getCell(42);
						ret = this.pegaDadosCelula(cel);
						dcd = new DiagnosticosCID10To();
						dcd.setDiagnosticoCID(ret);
						gm.setDiagnosticosCID10(dcd);
						
						cel = row.getCell(43);
						ret = this.pegaDadosCelula(cel);
						gm.setTipoAtendimento(ret);
						
						cel = row.getCell(44);
						ret = this.pegaDadosCelula(cel);
						gm.setTipoFaturamento(ret);
						
						cel = row.getCell(45);
						ret = this.pegaDadosCelula(cel);
						gm.setDiariasAcompanhante(ret);
						
						cel = row.getCell(46);
						ret = this.pegaDadosCelula(cel);
						gm.setDiariasUTI(ret);
						
						cel = row.getCell(47);
						ret = this.pegaDadosCelula(cel);
						gm.setMotivoSaida(ret);
						
						cel = row.getCell(48);
						ret = this.pegaDadosCelula(cel);
						gm.setDeclaracaoNascido(ret);
						
						cel = row.getCell(49);
						ret = this.pegaDadosCelula(cel);
						gm.setDeclaracaoObito(ret);
						
						cel = row.getCell(50);
						ret = this.pegaDadosCelula(cel);
						auxPto = ret;
						
						cel = row.getCell(51);
						ret = this.pegaDadosCelula(cel);
						auxAno = ret;
						
						cel = row.getCell(52);
						ret = this.pegaDadosCelula(cel);
						auxFat = ret;
						
						cel = row.getCell(53);
						ret = this.pegaDadosCelula(cel);
						gm.setMatricula(ret);
						
						vlg = new ValoresGuiaTo();
						vlg = getValoresXls(work, auxPto, auxAno, auxFat);
						gm.setValoresGuia(vlg);
						proceds = new ArrayList<ProcedimentosTo>();
						proceds = getProcedimentosXls(work, auxPto, auxAno, auxFat, j);
						j = Integer.parseInt(proceds.get(proceds.size()-1).getLinha());
						gm.setProcedimentos(proceds);
						guias.add(gm);
						
						i++;
					} else {
						h = 1;
					}
				} else {
					h = 1;
				}	
			}
			opa.setGuiaMonitoramento(guias);
			to.setOperadoraParaANS(opa);
		} catch (Exception e) {
			System.out.println("model.dao.MensagemDao.getMensagemXls - i: " + i + " - e= " + e.toString());
		}
		return to;
	}
	
	public ValoresGuiaTo getValores(String prot, String ano, String guia) throws Exception {
		Conexao con = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		StringBuilder sql = new StringBuilder();
		sql.append(" ")
		.append("  ");
		//
		ValoresGuiaTo to = null;
		try {
			con = new Conexao();
			conn = con.getConexao();
			stmt = conn.prepareStatement(sql.toString());
			rs = stmt.executeQuery();
			//
			to = new ValoresGuiaTo();
			if (rs.next()) {
				to.setValorTotalInformado(rs.getString(1));
				to.setValorProcessado(rs.getString(2));
				to.setValorTotalPagoProcedimentos(rs.getString(3));
				to.setValorTotalDiarias(rs.getString(4));
				to.setValorTotalTaxas(rs.getString(5));
				to.setValorTotalMateriais(rs.getString(6));
				to.setValorTotalOPME(rs.getString(7));
				to.setValorTotalMedicamentos(rs.getString(8));
				to.setValorGlosaGuia(rs.getString(9));
				to.setValorPagoGuia(rs.getString(10));
				to.setValorPagoFornecedores(rs.getString(11));
				to.setValorTotalTabelaPropria(rs.getString(12));
				to.setValorTotalCoParticipacao(rs.getString(13));
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("model.dao.MensagemDao.getValores - Fatura: " + guia + " - e= " + e.toString());
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				System.out.println("model.dao.MensagemDao.getValores - Fatura: " + guia + " - e= " + e.toString());
			}
		}
		return to;
	}
	
	
	public ValoresGuiaTo getValoresXls(HSSFWorkbook wb, String prot, String ano, String guia) throws Exception {
		ValoresGuiaTo to = null;
		HSSFSheet sheet = null;
		HSSFRow row = null;
		HSSFCell cel = null;
		String auxPto = null;
		String auxAno = null;
		String auxFat = null;
		String ret = null;
		int h;
		int i;
		try {
			sheet = wb.getSheetAt(1);
			h = 0;
			i = 1;
			while (h == 0) {
				row = sheet.getRow(i);
				if (row != null) {
					to = new ValoresGuiaTo();
					cel = row.getCell(0);
					if (cel != null && h == 0) {
						ret = this.pegaDadosCelula(cel);
						auxPto = ret;
						
						cel = row.getCell(1);
						ret = this.pegaDadosCelula(cel);
						auxAno = ret;
						
						cel = row.getCell(2);
						ret = this.pegaDadosCelula(cel);
						auxFat = ret;
						
						if (prot.equals(auxPto) && ano.equals(auxAno) && guia.equals(auxFat)) {
							cel = row.getCell(3);
							ret = this.pegaDadosCelula(cel);
							to.setValorTotalInformado(ret);
							
							cel = row.getCell(4);
							ret = this.pegaDadosCelula(cel);
							to.setValorProcessado(ret);
							
							cel = row.getCell(5);
							ret = this.pegaDadosCelula(cel);
							to.setValorTotalPagoProcedimentos(ret);
							
							cel = row.getCell(6);
							ret = this.pegaDadosCelula(cel);
							to.setValorTotalDiarias(ret);
							
							cel = row.getCell(7);
							ret = this.pegaDadosCelula(cel);
							to.setValorTotalTaxas(ret);
							
							cel = row.getCell(8);
							ret = this.pegaDadosCelula(cel);
							to.setValorTotalMateriais(ret);
							
							cel = row.getCell(9);
							ret = this.pegaDadosCelula(cel);
							to.setValorTotalOPME(ret);
							
							cel = row.getCell(10);
							ret = this.pegaDadosCelula(cel);
							to.setValorTotalMedicamentos(ret);
							
							cel = row.getCell(11);
							ret = this.pegaDadosCelula(cel);
							to.setValorGlosaGuia(ret);
							
							cel = row.getCell(12);
							ret = this.pegaDadosCelula(cel);
							to.setValorPagoGuia(ret);
							
							cel = row.getCell(13);
							ret = this.pegaDadosCelula(cel);
							to.setValorPagoFornecedores(ret);
							
							cel = row.getCell(14);
							ret = this.pegaDadosCelula(cel);
							to.setValorTotalTabelaPropria(ret);
							
							cel = row.getCell(15);
							ret = this.pegaDadosCelula(cel);
							to.setValorTotalCoParticipacao(ret);
							
							i++;
							h = 1;
						} else {
							i++;
						}	
					} else {
						h = 1;
					}
				} else {
					h = 1;
				}
			}
		} catch (Exception e) {
			System.out.println("model.dao.MensagemDao.getValoresXls - e= " + e.toString());
		}
		return to;
	}
	
	public List<ProcedimentosTo> getProcedimentos(String prot, String ano, String guia) throws Exception {
		Conexao con = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		StringBuilder sql = new StringBuilder();
		sql.append(" ");
		//
		List<ProcedimentosTo> to = null;
		ProcedimentosTo dado = null;
		IdentProcedimentoTo idp = null;
		ProcedimentoTo pcd = null;
		DenteRegiaoTo drg = null;
		DetalhePacoteTo pct = null;
		try {
			con = new Conexao();
			conn = con.getConexao();
			stmt = conn.prepareStatement(sql.toString());
			rs = stmt.executeQuery();
			//
			to = new ArrayList<ProcedimentosTo>();
			while (rs.next()) {
				dado = new ProcedimentosTo();
				idp = new IdentProcedimentoTo();
				idp.setCodigoTabela(rs.getString(3));
				pcd = new ProcedimentoTo();
				pcd.setGrupoProcedimento(rs.getString(5));
				pcd.setCodigoProcedimento(rs.getString(6));
				idp.setProcedimento(pcd);
				dado.setIdentProcedimento(idp);
				drg = new DenteRegiaoTo();
				drg.setCodDente(rs.getString(8));
				drg.setCodRegiao(rs.getString(9));
				dado.setDenteRegiao(drg);
				dado.setDenteFace(rs.getString(10));
				dado.setQuantidadeInformada(rs.getString(11));
				dado.setValorInformado(rs.getString(12));
				dado.setQuantidadePaga(rs.getString(13));
				dado.setValorPagoProc(rs.getString(14));
				dado.setValorPagoFornecedor(rs.getString(15));
				dado.setCNPJFornecedor(rs.getString(16));
				dado.setValorCoParticipacao(rs.getString(17));
				pct = new DetalhePacoteTo();
				pct.setCodigoTabela(rs.getString(19));
				pct.setCodigoProcedimento(rs.getString(20));
				pct.setQuantidade(rs.getString(21));
				dado.setDetalhePacote(pct);
				to.add(dado);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("model.dao.MensagemDao.getProcedimentos - Fatura: " + guia + " - e= " + e.toString());
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				System.out.println("model.dao.MensagemDao.getProcedimentos - Fatura: " + guia + " - e= " + e.toString());
			}
		}
		return to;
	}
	
	public List<ProcedimentosTo> getProcedimentosXls(HSSFWorkbook wb, String prot, String ano, String guia, int linha) throws Exception {
		List<ProcedimentosTo> to = null;
		ProcedimentosTo dado = null;
		IdentProcedimentoTo idp = null;
		ProcedimentoTo pcd = null;
		DenteRegiaoTo drg = null;
		DetalhePacoteTo pct = null;
		HSSFSheet sheet = null;
		HSSFRow row = null;
		HSSFCell cel = null;
		String auxPto = null;
		String auxAno = null;
		String auxFat = null;
		String ret = null;
		int h;
		int i;
		try {
			to = new ArrayList<ProcedimentosTo>();
			sheet = wb.getSheetAt(2);
			h = 0;
			i = linha;
			while (h == 0) {
				row = sheet.getRow(i);
				if (row != null) {
					cel = row.getCell(0);
					if (cel != null) {
						ret = this.pegaDadosCelula(cel);
						auxPto = ret;
						
						cel = row.getCell(1);
						ret = this.pegaDadosCelula(cel);
						auxAno = ret;
						
						cel = row.getCell(2);
						ret = this.pegaDadosCelula(cel);
						auxFat = ret;
						
						if (prot.equals(auxPto) && ano.equals(auxAno) && guia.equals(auxFat)) {
							dado = new ProcedimentosTo();
							idp = new IdentProcedimentoTo();
							
							cel = row.getCell(5);
							ret = this.pegaDadosCelula(cel);
							idp.setCodigoTabela(ret);
							pcd = new ProcedimentoTo();
							
							cel = row.getCell(7);
							ret = this.pegaDadosCelula(cel);
							pcd.setGrupoProcedimento(ret);
							
							cel = row.getCell(8);
							ret = this.pegaDadosCelula(cel);
							pcd.setCodigoProcedimento(ret);
							idp.setProcedimento(pcd);
							dado.setIdentProcedimento(idp);
							drg = new DenteRegiaoTo();
							
							cel = row.getCell(10);
							ret = this.pegaDadosCelula(cel);
							drg.setCodDente(ret);
							
							cel = row.getCell(11);
							ret = this.pegaDadosCelula(cel);
							drg.setCodRegiao(ret);
							dado.setDenteRegiao(drg);
							
							cel = row.getCell(12);
							ret = this.pegaDadosCelula(cel);
							dado.setDenteFace(ret);
							
							cel = row.getCell(13);
							ret = this.pegaDadosCelula(cel);
							dado.setQuantidadeInformada(ret);
							
							cel = row.getCell(14);
							ret = this.pegaDadosCelula(cel);
							dado.setValorInformado(ret);
							
							cel = row.getCell(15);
							ret = this.pegaDadosCelula(cel);
							dado.setQuantidadePaga(ret);
							
							cel = row.getCell(16);
							ret = this.pegaDadosCelula(cel);
							dado.setValorPagoProc(ret);
							
							cel = row.getCell(17);
							ret = this.pegaDadosCelula(cel);
							dado.setValorPagoFornecedor(ret);
							
							cel = row.getCell(18);
							ret = this.pegaDadosCelula(cel);
							dado.setCNPJFornecedor(ret);
							
							cel = row.getCell(19);
							ret = this.pegaDadosCelula(cel);
							dado.setValorCoParticipacao(ret);
							pct = new DetalhePacoteTo();
							
							cel = row.getCell(21);
							ret = this.pegaDadosCelula(cel);
							pct.setCodigoTabela(ret);
							
							cel = row.getCell(22);
							ret = this.pegaDadosCelula(cel);
							pct.setCodigoProcedimento(ret);
							
							cel = row.getCell(23);
							ret = this.pegaDadosCelula(cel);
							pct.setQuantidade(ret);
							dado.setDetalhePacote(pct);
							dado.setLinha(""+i);
							to.add(dado);
							
							i++;
						} else {
							i++;
						}	
					} else {
						h = 1;
					}
				} else {
					h = 1;
				}
			}
		} catch (Exception e) {
			System.out.println("model.dao.MensagemDao.getProcedimentosXls - e= " + e.toString());
		}
		return to;
	}
	
	private String pegaDadosCelula(HSSFCell cel) {
		SimpleDateFormat sdf = null;
		String resp = null;
		try {
			sdf = new SimpleDateFormat("dd/MM/yyyy");
			if (cel.getCellType() == HSSFCell.CELL_TYPE_STRING) {
				 resp = "" + cel.getStringCellValue();
				 if ("NULL".equals(resp)) {
					 resp = null;
				 }
			} else if (cel.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
				if (DateUtil.isCellDateFormatted(cel)) {
					resp = sdf.format(cel.getDateCellValue());
				} else {
					if (cel.getNumericCellValue() >= 0) {
						resp = "" + cel.getNumericCellValue();
						if (resp.contains("E")) {
							String tam = resp.substring((resp.indexOf("E") + 1), resp.length());
							Long tam2 = Long.parseLong(tam);
							String tam3 = resp.substring(resp.indexOf("."), resp.indexOf("E"));
							Long tam4 = (long)tam3.length();
							Long num = (tam4 - tam2 - 1);
							
							resp = resp.substring(0, resp.indexOf("E")).replace(".", "");
							
							if (num < 0) {
								num = (num * (-1));
								for(int k = 0; k <= 10; k++){
						        	if(k < num){
						        		resp = resp.concat("0");
						           	} else {
						        		break;
						        	}
						        }
							}
							
							for(int k = 1; k <= 11; k++){
				        		if(resp.length() < 11){
				        			resp = "0".concat(resp);
				            	} else {
				        			break;
				        		}
				        	}
						}
					} else {
						resp = "" + (cel.getNumericCellValue()*(-1));
					}
				}
			} else if (cel.getCellType() == HSSFCell.CELL_TYPE_BOOLEAN) {
				resp = "" + cel.getBooleanCellValue();
			} else if (cel.getCellType() == HSSFCell.CELL_TYPE_BOOLEAN) {
				resp = "" + cel.getCellFormula();
			} else if (cel.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
				resp = "";
			} else if (cel.getCellType() == HSSFCell.CELL_TYPE_FORMULA) {
				resp = ""; 
			} else {
				resp = "";
			}
		} catch (Exception e) {
			System.out.println("model.dao.MensagemDao.pegaDadosCelula - e= " + e.toString());
		}
		return resp;
	}
	
}
