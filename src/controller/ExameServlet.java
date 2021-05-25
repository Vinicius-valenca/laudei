package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;

import org.apache.commons.fileupload.FileItem;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.*;
import javax.servlet.http.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.swing.text.html.HTMLDocument.Iterator;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.net.ftp.FTPClient;

import model.Exame;
import model.Pessoa;
import service.ExameService;
import service.LoginService;
import service.RegisterService;
import util.FTPUploader;





public class ExameServlet extends HttpServlet {
	
	  private String fileSavePath;
	    private static final String UPLOAD_DIRECTORY = "upload";
	    
	    
	    public void init() {
	        fileSavePath = getServletContext().getRealPath("/") + File.separator + UPLOAD_DIRECTORY;/*save uploaded files to a 'Upload' directory in the web app*/
	        if (!(new File(fileSavePath)).exists()) {
	            (new File(fileSavePath)).mkdir();    // creates the directory if it does not exist        
	        }
	    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		option(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		option(request, response);

	}

	protected void option(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String url = request.getServletPath();

			if (url.equalsIgnoreCase("/enviarExame")) {
				save(request, response);

			} else if (url.equalsIgnoreCase("/atualizarExame")) {
				delete(request, response);

			}else if (url.equalsIgnoreCase("/listarExamesSemLaudo")) {
				listarExamesSemLaudo(request, response);

			}else if (url.equalsIgnoreCase("/listarExamesComLaudo")) {
				listarExamesComLaudo(request, response);

			}
			else if (url.equalsIgnoreCase("/listarExames")) {
				listarExames(request, response);

			}else if (url.equalsIgnoreCase("/deletarExame")) {
				deletarExame(request, response);

			}else {
				response.sendRedirect("/");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public void save(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (!ServletFileUpload.isMultipartContent(request)) {
	         throw new IllegalArgumentException("Request is not multipart, please 'multipart/form-data' enctype for your form.");
	     }
		
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF8");

	     ServletFileUpload uploadHandler = new ServletFileUpload(new DiskFileItemFactory());
	     PrintWriter writer = response.getWriter();
	   
	     System.out.println(new File(request.getServletContext().getRealPath("/")+"images/"));
	     HttpSession session = request.getSession(true);
	     Pessoa p = new Pessoa();
	     p = (Pessoa)session.getAttribute("user");
		
		 
		
		 
		 
			
			
	     
	     try {
	         List<FileItem> items = uploadHandler.parseRequest(request);
	         Exame exame = new Exame();
	         exame.setNomeClinica(p);
	         for (FileItem item : items) {   
	                 if (item.isFormField()) {
	                     // Process regular form field (input type="text|radio|checkbox|etc", select, etc).
	                     String fieldname = item.getFieldName();
	                     String fieldvalue = item.getString("UTF-8").trim();
	                     System.out.println(fieldname);
	                     System.out.println(fieldvalue);
	                     // ... (do your job here)
	                     exame.setTpExame(fieldvalue);
	                 } else {
	                     // Process form file field (input type="file").
	                     String fieldname = item.getFieldName();
	                     String filename = FilenameUtils.getName(item.getName());
	                     InputStream filecontent = item.getInputStream();
	                     int dotIndex = item.getName().lastIndexOf('.');
	                    String nome=(dotIndex == -1) ? item.getName() : item.getName().substring(0, dotIndex);
	                    exame.setNomePaciente(nome);
		            	 
		            	    byte[] examedata = new byte[(int) item.getSize()];
		            	    try {
		            	    
		            	    	filecontent.read(examedata);
		            	    	filecontent.close();
		            	    } catch (Exception e) {
		            	    e.printStackTrace();
		            	    }
		            	    
		            	   
		            	    System.out.println(filename);
		            	    exame.setExamenome( removerAcentos(item.getName()));
		            	    exame.setDtEntrada(new java.sql.Date(System.currentTimeMillis()));
		            	    exame.setNomePaciente( removerAcentos(filename));
		            	    
		            	    FTPUploader ftpUploader = new FTPUploader("ftp.zeituneinformatica.com.br", "laudeisistema@laudeitelemedicina.com.br", "Pa6?Eo%D8#ix");
		            		//FTP server path is relative. So if FTP account HOME directory is "/home/pankaj/public_html/" and you need to upload 
		            		// files to "/home/pankaj/public_html/wp-content/uploads/image2/", you should pass directory parameter as "/wp-content/uploads/image2/"
		            		ftpUploader.uploadFile(item.getInputStream(), removerAcentos(item.getName()), "/");
		            		ftpUploader.disconnect();
		            		System.out.println("Done");
		            	   
		            	    ExameService exameService = new ExameService();
		            	 
		            	    Boolean resposta = exameService.register(exame);
		                    
		                     
		                     System.out.println("uploaded");
	                 }
	             }
	         } catch (FileUploadException e1) {
	             // TODO Auto-generated catch block
	             e1.printStackTrace();
	         }
	         
	   
	     finally {
	        
	         writer.close();
	     }
	        

	    
	}
	
	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean resposta = false;
		response.setContentType("text/plain; charset=UTF-8");
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		
		try {
			 
			 
			
			//LoginService loginService = new LoginService();
			//List<Pessoa> list =  loginService.getListOfPessoa();
			//System.out.println(list);
			System.out.println("id"+request.getParameter("id"));
			String id = request.getParameter("id");
			 Pessoa p = new Pessoa();
			 
			 p.setId(Long.valueOf(id));
			 
			 
				
				RegisterService registerService = new RegisterService();
				
				resposta = registerService.delete(p);
				
				System.out.println("Deletou?" + resposta );
				
				
			out.print(gson.toJson(resposta));
			
			
			out.flush();
			out.close();

		} catch (Exception ex) {
			
			//ex.printStackTrace();
			out.print(gson.toJson(resposta));
			out.flush();
			out.close();
			
		}
	}
	
	public void listarExames(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			 
			 
			response.setContentType("text/plain; charset=UTF-8");
			PrintWriter out = response.getWriter();
			Gson gson = new Gson();
			ExameService exameService = new ExameService();
			List<Exame> list =  exameService.getListOfExame();
			
			
			
			
			System.out.println(list);
			

			out.print(gson.toJson(list));
			out.flush();
			out.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	public void listarExamesSemLaudo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			 
			 
			response.setContentType("text/plain; charset=UTF-8");
			PrintWriter out = response.getWriter();
			Gson gson = new Gson();
			ExameService exameService = new ExameService();
			List<Exame> list =  exameService.getListOfExameSemLaudo();
			
			
			
			
			System.out.println(list);
			

			out.print(gson.toJson(list));
			out.flush();
			out.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void listarExamesComLaudo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			 
			 
			response.setContentType("text/plain; charset=UTF-8");
			PrintWriter out = response.getWriter();
			Gson gson = new Gson();
			ExameService exameService = new ExameService();
			List<Exame> list =  exameService.getListOfExameComLaudo();
			
			
			
			
			System.out.println(list);
			

			out.print(gson.toJson(list));
			out.flush();
			out.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void deletarExame(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean resposta = false;
		response.setContentType("text/plain; charset=UTF-8");
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		
		try {
			 
			 
			
			
			System.out.println("id"+request.getParameter("id"));
			System.out.println("Examenome"+request.getParameter("examenome"));
			String id = request.getParameter("id");
			Exame e = new Exame(); 
			 ExameService exameService = new ExameService();
			 e.setId(Long.valueOf(id));
			
     		
			 FTPClient client = new FTPClient();
			 client.connect("ftp.zeituneinformatica.com.br", 21);
			 client.login("laudeisistema@laudeitelemedicina.com.br", "Pa6?Eo%D8#ix");
			 client.deleteFile("/"+request.getParameter("examenome"));
			 client.disconnect();
				
				
				resposta = exameService.delete(e);
				
				System.out.println("Deletou?" + resposta );
				
				
			out.print(gson.toJson(resposta));
			
			
			out.flush();
			out.close();

		} catch (Exception ex) {
			
			//ex.printStackTrace();
			out.print(gson.toJson(resposta));
			out.flush();
			out.close();
			
		}
	}
	
	public static String removerAcentos(String str) {
	    return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
	}
	
	
}