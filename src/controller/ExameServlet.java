package controller;

import java.io.IOException;
import java.io.PrintWriter;
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

import model.Exame;
import model.ExameArquivo;
import model.Pessoa;
import service.ExameService;
import service.LoginService;
import service.RegisterService;





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

			}else if (url.equalsIgnoreCase("/listarExames")) {
				listarExames(request, response);

			}else {
				response.sendRedirect("/");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
	                     String fieldvalue = item.getString();
	                     System.out.println(fieldname);
	                     System.out.println(fieldvalue);
	                     // ... (do your job here)
	                     exame.setTpExame(fieldvalue);
	                 } else {
	                     // Process form file field (input type="file").
	                     String fieldname = item.getFieldName();
	                     String filename = FilenameUtils.getName(item.getName());
	                     InputStream filecontent = item.getInputStream();

		            	 
		            	    byte[] examedata = new byte[(int) item.getSize()];
		            	    try {
		            	    
		            	    	filecontent.read(examedata);
		            	    	filecontent.close();
		            	    } catch (Exception e) {
		            	    e.printStackTrace();
		            	    }
		            	    //String nome[] = item.getName().split(".");
		            	    //System.out.println(nome.toString());
		            	    ExameArquivo exameArquivo = new ExameArquivo();
		            	    exameArquivo.setExame(examedata);
		            	    exameArquivo.setNomeExame(item.getName());
		            	    exame.setExameArquivo(exameArquivo);
		            	    
		            	    exame.setDtEntrada(new java.sql.Date(System.currentTimeMillis()));
		            	    //exame.setNomePaciente((item.getName().split("."))[0]);
		            	    
		            	   
		            	   
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
	
	
	
}