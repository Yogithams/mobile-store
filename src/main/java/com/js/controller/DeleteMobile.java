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

@WebServlet(value="/delete")
public class DeleteMobile extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		   int id = Integer.parseInt(req.getParameter("id"));
		      
		      int result =MobileCRUD.deletemobile(id);
		      
		      if(result==1) {
					RequestDispatcher rd = req.getRequestDispatcher("view");
					rd.forward(req, resp);
				}
				else {
					RequestDispatcher rd = req.getRequestDispatcher("result.jsp");
					req.setAttribute("msg", "No Books Available");
					rd.forward(req, resp);
				}
	}
}
