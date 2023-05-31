package com.js.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.js.dao.MobileCRUD;
import com.js.dto.Mobile;

@WebServlet(value="/update")
public class UpdateStage1 extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	     int id = Integer.parseInt(req.getParameter("id"));
	     
	     Mobile m = MobileCRUD.getmobilebyid(id);
	     if(m!=null) {
	    	 RequestDispatcher rd = req.getRequestDispatcher("update.jsp");
	    	 req.setAttribute("mobile", m);
	    	 rd.forward(req, resp);
	     } else {
	    	 RequestDispatcher rd = req.getRequestDispatcher("result.jsp");
	    	 req.setAttribute("msg", "No Mobile To Update");
	    	 rd.forward(req, resp);
	     }
	}
}
