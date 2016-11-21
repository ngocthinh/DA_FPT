package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class DA_suatindang
 */
@WebServlet("/DA_suatindang")
public class DA_suatindang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DA_suatindang() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String username = null;
		String gia = null;
		String anh = null;
		System.out.println(request.getParameter("gia"));
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		System.out.println(isMultipart);
        if (isMultipart) {
        	// Create a factory for disk-based file items
        //	FileItemFactory factory = new DiskFileItemFactory();

        	// Create a new file upload handler
        //	ServletFileUpload upload = new ServletFileUpload(factory);
 
            try {
            	
            	// Parse the request
            	List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
            	String inputName = "";
            	for(FileItem item : multiparts){
            		
            	 if(!item.isFormField()){   // Check regular field.
            	   anh = new File(item.getName()).getName();
            	  
            	  item.write( new File("C:/Users/congago/git/DA_FPT/WebContent/images"+ File.separator + anh));
            	 }
            	 if(item.isFormField()){  // Check regular field.
            	  inputName = (String)item.getFieldName(); 
            	  if(inputName.equalsIgnoreCase("username")){ 
            		 System.out.println(username);
            	    username = (String)item.getString(); 
            	    username = new String(item.getString().getBytes(), "UTF-8");
            	    username=item.getString("UTF-8").trim();
            	  }
            	  if(inputName.equalsIgnoreCase("gia")){ 
            		  
               	    gia = (String)item.getString(); 
               	 System.out.println(gia);
               	    gia = new String(item.getString().getBytes(), "UTF-8");
                 	gia=item.getString("UTF-8").trim();
               	  }
            	 } 
            	}
            } catch (FileUploadException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
	}
		
		// AddTourBO addtourBO=new AddTourBO();
	//	 try {
		//	addtourBO.insertNewTour(tentour, sgia, ngaydi, ngayve, mota, anh);
		//	response.sendRedirect("ShowListTourController");
	//	} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
	//		e.printStackTrace();
	//	}
	}

}
