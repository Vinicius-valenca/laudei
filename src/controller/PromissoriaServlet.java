package controller;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.time.DateUtils;

import br.com.caelum.stella.inwords.FormatoDeReal;
import br.com.caelum.stella.inwords.InteiroSemFormato;
import br.com.caelum.stella.inwords.NumericToWordsConverter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import util.ordinalExtenso;



public class PromissoriaServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF8");
			int qtd_parcelas = Integer.valueOf(request.getParameter("num_parcelas"));
			
			
			String valortmp = request.getParameter("valor").replace(".", "").replace(",", ".");
			BigDecimal valor;
			if (valortmp == null || "".equals(valortmp)) {
	            valor= BigDecimal.ZERO;
	        }else{
	        valortmp.replace(".", "").replace(",", ".");
			valor = new BigDecimal(valortmp);
	        }
			
			String nomeCredor = request.getParameter("nomeCredor");			
			String cpfcnpjCredor = request.getParameter("cpfcnpjCredor");
			String nomeDevedor = request.getParameter("nomeDevedor");			
			String cpfcnpjDevedor = request.getParameter("cpfcnpjDevedor");
			String nomeAval1 = request.getParameter("nomeAval1");			
			String cpfcnpjAval1 = request.getParameter("cpfcnpjAval1");
			String nomeAval2 = request.getParameter("nomeAval2");			
			String cpfcnpjAval2 = request.getParameter("cpfcnpjAval2");
			
			String local = request.getParameter("local");
			
			String endCompleto;
			endCompleto = request.getParameter("endereco") + ", nº " + request.getParameter("numero") + ", ";			
			if(request.getParameter("complemento") != ""){
				endCompleto += request.getParameter("complemento") + ", ";
			}			
			endCompleto += request.getParameter("bairro") + ", "
			+ request.getParameter("cidade") + " - "
			+ request.getParameter("estado");
			System.out.println(endCompleto);
			
			String dt_emissaoString = request.getParameter("dt_emissao");
			String dt_1_vencString = request.getParameter("dt_1_venc");
			Date dt_emissao=null;
			Date dt_1_venc=null;
			try {
				dt_emissao = new SimpleDateFormat("dd/MM/yyyy").parse(dt_emissaoString);
				System.out.println(new SimpleDateFormat("dd/MM/yyyy").format(dt_emissao));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				dt_1_venc = new SimpleDateFormat("dd/MM/yyyy").parse(dt_1_vencString);
				System.out.println(new SimpleDateFormat("dd/MM/yyyy").format(dt_1_venc));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Date newDate = DateUtils.addMonths(dt_emissao, 1);
			System.out.println(new SimpleDateFormat("dd/MM/yyyy").format(newDate));
			
			NumericToWordsConverter converter2;  
			converter2 = new NumericToWordsConverter(new FormatoDeReal()); 
			String extenso2 = converter2.toWords(valor.doubleValue());  
			System.out.println(extenso2);
			
			
			NumericToWordsConverter converter;  
			converter = new NumericToWordsConverter(new InteiroSemFormato());  
			double numero = 2018;  
			String extenso1 = converter.toWords(numero);  
			System.out.println(extenso1);
			
			

			
			
			System.out.println(qtd_parcelas);
			ArrayList<Integer> num_parcelas = new ArrayList<Integer>();
			System.out.println(num_parcelas);
			
			for(int i = 1; i <= qtd_parcelas; i++){
				num_parcelas.add(i);			      
			  }
			
		
			      System.out.println(num_parcelas);
			 
			      ordinalExtenso teste1 = new ordinalExtenso(31);
			      System.out.println(teste1.resultado());
		
			response.setContentType("application/pdf");

			// set input and output stream
			ServletOutputStream servletOutputStream = response.getOutputStream();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			FileInputStream fis;
			BufferedInputStream bufferedInputStream;
			JRBeanCollectionDataSource jrbcds;
			JasperReport jasperReport;
			JasperPrint jasperPrint;


			try {
				// get report location
				ServletContext context = getServletContext();
				String reportLocation = context.getRealPath("");

				// img
				HashMap<String, Object> params = new HashMap<String, Object>();
				//params.put("logo", new javax.swing.ImageIcon(reportLocation + "img\\logo2.png").getImage());
				params.put("qtd_parcelas", qtd_parcelas);
				params.put("valorExtenso", extenso2);
				params.put("valor", valor);
				params.put("dt_1_venc", dt_1_venc);
				params.put("local", local);
				params.put("endCompleto", endCompleto);
				params.put("dt_emissao", dt_emissao);
				params.put("nomeCredor", nomeCredor);
				params.put("cpfcnpjCredor", cpfcnpjCredor);
				params.put("nomeDevedor", nomeDevedor);
				params.put("cpfcnpjDevedor", cpfcnpjDevedor);
				params.put("nomeAval1", nomeAval1);
				params.put("cpfcnpjAval1", cpfcnpjAval1);
				params.put("nomeAval2", nomeAval2);
				params.put("cpfcnpjAval2", cpfcnpjAval2);
				
				request.setCharacterEncoding("UTF-8");

				// get report
				fis = new FileInputStream(reportLocation + "relatorio\\promissoria.jasper");

				
				bufferedInputStream = new BufferedInputStream(fis);

				
				
				

				jrbcds = new JRBeanCollectionDataSource(num_parcelas);
				jasperReport = (JasperReport) JRLoader.loadObject(bufferedInputStream);

				jasperPrint = JasperFillManager.fillReport(jasperReport, params, jrbcds);

				// export to pdf
				JasperExportManager.exportReportToPdfStream(jasperPrint, baos);

				response.setContentLength(baos.size());
				baos.writeTo(servletOutputStream);

				// close it
				fis.close();
				bufferedInputStream.close();

			} catch (Exception ex) {
				ex.printStackTrace();

			} finally {

				servletOutputStream.flush();
				servletOutputStream.close();
				baos.close();
			}


		
	}

	
	
	
	
}