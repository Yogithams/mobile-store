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

@WebServlet(value="/edit")
public class UpdateStage2 extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String brand = req.getParameter("author");
        double price = Double.parseDouble(req.getParameter("price"));
        
        Mobile m = new Mobile();
        m.setId(id);
        m.setName(name);
        m.setBrand(brand);
        m.setPrice(price);
        
        int result = MobileCRUD.updateMobilebyId(id, m);
        
     
        if(result==1) {
 				RequestDispatcher rd = req.getRequestDispatcher("view");
 				rd.forward(req, resp);
 			}
 	    else {
 				RequestDispatcher rd = req.getRequestDispatcher("result.jsp");
 				req.setAttribute("msg", "No Book Available To Update");
 				rd.forward(req, resp);
 			}
        }
}
