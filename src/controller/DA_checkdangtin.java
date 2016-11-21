package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import model.bean.Tindang;

import model.bo.CheckBO;

/**
 * Servlet implementation class DA_checkdangtin
 */
@WebServlet("/DA_checkdangtin")
public class DA_checkdangtin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DA_checkdangtin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/plain; charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");


		Tindang tindang = new Tindang();
		HttpSession session = request.getSession();
		String idaccount = (String) session.getAttribute("idaccount");
		tindang.setUsername(idaccount);
		System.out.print("session        " + idaccount);
		
		String chuyenmuc = null;
		String diachi = null;
		String doituong = null;
		String nhucau = null;
		String tieude = null;
		String noidung = null;
		String gia = null;
		String anh = null;
		System.out.println("Bài giảng hay nhất tôi");
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		System.out.println(isMultipart);
		if (isMultipart) {
			try {
				List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
				String inputName = "";
				for (FileItem item : multiparts) {
					if (!item.isFormField()) { // Check regular field.
						anh = new File(item.getName()).getName();
						item.write(new File("C:/Users/congago/git/DA_FPT/WebContent/images" + File.separator + anh));
					}
					if (item.isFormField()) { // Check regular field.
						inputName = (String) item.getFieldName();
						if (inputName.equalsIgnoreCase("chuyenmuc")) {
							chuyenmuc = (String) item.getString();
							System.out.println(diachi);
							chuyenmuc = new String(item.getString().getBytes(), "UTF-8");
							chuyenmuc = item.getString("UTF-8").trim();
						}
						if (inputName.equalsIgnoreCase("vung")) {
							diachi = (String) item.getString();
							System.out.println(diachi);
							diachi = new String(item.getString().getBytes(), "UTF-8");
							diachi = item.getString("UTF-8").trim();
						}
						if (inputName.equalsIgnoreCase("banla")) {
							doituong = (String) item.getString();
							System.out.println(doituong);
							doituong = new String(item.getString().getBytes(), "UTF-8");
							doituong = item.getString("UTF-8").trim();
						}
						if (inputName.equalsIgnoreCase("bdangtin")) {
							nhucau = (String) item.getString();
							System.out.println(nhucau);
							nhucau = new String(item.getString().getBytes(), "UTF-8");
							nhucau = item.getString("UTF-8").trim();
						}
						if (inputName.equalsIgnoreCase("tieude")) {
							tieude = (String) item.getString();
							System.out.println(tieude);
							tieude = new String(item.getString().getBytes(), "UTF-8");
							tieude = item.getString("UTF-8").trim();
						}
						if (inputName.equalsIgnoreCase("noidung")) {
							noidung = (String) item.getString();
							System.out.println(noidung);
							noidung = new String(item.getString().getBytes(), "UTF-8");
							noidung = item.getString("UTF-8").trim();
						}
						if (inputName.equalsIgnoreCase("gia")) {
							gia = (String) item.getString();
							System.out.println(gia);
							gia = new String(item.getString().getBytes(), "UTF-8");
							gia = item.getString("UTF-8").trim();
						}
						if (inputName.equalsIgnoreCase("gia")) {
							anh = (String) item.getString();
							System.out.println(gia);
							gia = new String(item.getString().getBytes(), "UTF-8");
							gia = item.getString("UTF-8").trim();
						}
					}
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		boolean isor=true,issa=true;
		if("Ca nhan".equals(doituong)) isor=false;
		if("can mua".equals(nhucau)) issa=false;
		tindang.setIdCategory(chuyenmuc);
        tindang.setUsername(idaccount);
        tindang.setAddress(diachi);
        tindang.setIdoranization(isor);
        tindang.setSalebuy(issa);
        tindang.setTitle(tieude);
        tindang.setContent(noidung);
        tindang.setCost(gia);
        tindang.setLinkImage(anh);
		CheckBO checkBO = new CheckBO();
		if (checkBO.isThemtindang(tindang)) {
			ArrayList<Tindang> arrTD = new ArrayList<Tindang>();
			arrTD = checkBO.getTindang();
			request.setAttribute("arrTD", arrTD);
			RequestDispatcher rd = request.getRequestDispatcher("DA_trangcanhan.jsp");
			rd.forward(request, response);
		} else {
			response.sendRedirect("DA_dangtin.jsp");
		}
	}

}
