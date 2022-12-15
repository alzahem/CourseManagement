package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/teacher_add")

public class AddTeacherServlet extends HttpServlet {

	// create query
	private static final String INSERT_QUERY = "INSERT INTO teacher_names(Names, subject, class) VALUES(?,?,?)";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// get PrintWriter
		PrintWriter pw = res.getWriter();
		// set Content type
		res.setContentType("text/html");
		// read
		String names = req.getParameter("names");
		String subject = req.getParameter("subject");
		String classRoom = req.getParameter("class");
		PreparedStatement ps;

		// load the jdbc driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Create connection with mySQL
		try {Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/School", "root", "");
			ps = con.prepareStatement(INSERT_QUERY);
			//set the vlaues
			ps.setString(1, names);
			ps.setString(2, subject);
			ps.setString(3, classRoom);
			
			int count = ps.executeUpdate();
			if(count == 0) {
				pw.println("Record not stored in DataBase");
			}else {
				pw.println("Record Stored into Data");
			}
		} catch (SQLException se) {
			pw.println(se.getMessage());
			se.printStackTrace();
		} catch (Exception e) {
			pw.println(e.getMessage());
			e.printStackTrace();
		}

		// close the stream
		pw.close();

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
