package present;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import model.dao.CabecalhoDao;
import model.dao.EpilogoDao;
import model.dao.MensagemDao;
import model.to.MensagemEnvioANSTo;
import model.to.cabecalho.CabecalhoTo;
import model.to.epilogo.EpilogoTo;
import model.to.mensagem.MensagemTo;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import present.xml.cabecalho.Cabecalho;
import present.xml.epilogo.Epilogo;
import present.xml.mensagem.Mensagem;

public class GeraXml {
	
	public void getMonitoramentoTiss(String mes, String ano, String plano, String lote, String guia, String excluir, String caminho) {
		ByteArrayInputStream xml = null;
		DocumentBuilderFactory dbfac = null;
		DocumentBuilder docBuilder = null;
		Document doc = null;
		TransformerFactory transfac = null;
		Transformer trans = null;
		StreamResult result = null;
		DOMSource source = null;
		Element el = null;
		Element el1 = null;
		Element el2 = null;
		Element el3 = null;
		String header = null;
		MensagemDao dao = null;
		MensagemTo to = null;
		CabecalhoDao cdao = null;
		CabecalhoTo cab = null;
		EpilogoDao edao = null;
		EpilogoTo epl = null;
		MensagemEnvioANSTo mea = null;
		Cabecalho cabx = null;
		Mensagem msgx = null;
		Epilogo eplx = null;
		String aux = null;
		try {
			// Criando o arquivo
			header = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\" ?>";
			header = header + "\n<ans:mensagemEnvioANS>\n</ans:mensagemEnvioANS>";
			xml = new ByteArrayInputStream(new String(header.getBytes(), "ISO-8859-1").getBytes());
			dbfac = DocumentBuilderFactory.newInstance();
			docBuilder = dbfac.newDocumentBuilder();
			doc = docBuilder.parse(xml);
						
			//Criando a Mensagem
			el = doc.getDocumentElement();
			el.setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
			//el.setAttribute("xsi:schemaLocation", "http://www.ans.gov.br/padroes/tiss/schemas http://www.ans.gov.br/padroes/tiss/schemas/tissMonitoramentoV3_03_03.xsd");
			el.setAttribute("xsi:schemaLocation", "http://www.ans.gov.br/padroes/tiss/schemas http://www.ans.gov.br/padroes/tiss/schemas/tissMonitoramentoV1_00_00.xsd");
			el.setAttribute("xmlns:ans", "http://www.ans.gov.br/padroes/tiss/schemas");
			el.setAttribute("xmlns:ds", "http://www.w3.org/2000/09/xmldsig#");
			
			//Pegando os dados (Cabecalho, Mensagem e Epilogo)
			cdao = new CabecalhoDao();
			cab = cdao.getCabecalho(ano, mes, plano, lote);
			dao = new MensagemDao();
			to = new MensagemTo();
			
			if (caminho == null) {
				to = dao.getMensagem(mes, ano, plano, guia, excluir);
			} else {
				to = dao.getMensagemXls(caminho);
			}
			
			//Estruturando a mensagem (Cabecalho, Mensagem e Epilogo)
			mea = new MensagemEnvioANSTo();
			mea.setCabecalho(cab);
			mea.setMensagem(to);
			//
			edao = new EpilogoDao();
			epl = edao.getEpilogo(mea);
			mea.setEpilogo(epl);
			
			cabx = new Cabecalho();
			msgx = new Mensagem();
			eplx = new Epilogo();
			//
			el1 = cabx.getCabecalho(doc, el, mea.getCabecalho());
			el.appendChild(el1);
			
			el2 = msgx.getMensagem(doc, el, mea.getMensagem());
			el.appendChild(el2);
			
			el3 = eplx.getEpilogo(doc, el, mea.getEpilogo());
			el.appendChild(el3);
			
			
			//Atribuindo os parâmetros ao documento
	        transfac = TransformerFactory.newInstance();
            trans = transfac.newTransformer();
            //trans.setOutputProperty(OutputKeys.INDENT, "yes");
            trans.setOutputProperty(OutputKeys.INDENT, "no");
            
            //Salvando o documento           
            aux = "0000" + lote;
            lote = aux.substring(aux.length() - 4);
            aux = "00" + mes;
            mes = aux.substring(aux.length() - 2);
            if ("1".equals(plano)) {
            	aux = "392405";
            } else {
            	aux = "329665";
            }
            result = new StreamResult(new FileOutputStream("D:/" + aux + ano + mes + lote + ".XTE"));
            source = new DOMSource(doc);
            trans.transform(source, result);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("present.GeraXml.getMonitoramentoTiss - e= " + e.toString());
		}
	}

}
