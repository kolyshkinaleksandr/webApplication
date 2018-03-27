package com.kolyshkin;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kolyshkin.database.DatabaseConnection;

@SuppressWarnings("serial")
@WebServlet("/RetreiveImage")
public class RetreiveImage extends HttpServlet{
	 @Override
		protected void doGet(HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws ServletException, IOException {
			// TODO Auto-generated method stub
			Statement statement= null;
			ResultSet resultSet;
			InputStream inputStream;
			String SQL;
			try {
				String fileId= httpRequest.getParameter("Id");
				System.out.println("inside servlet > " +fileId);
				Connection connection= DatabaseConnection.getConnection();
				statement= connection.createStatement();
				SQL= "SELECT file FROM Registration WHERE id= '"+fileId+"'";
				 resultSet= statement.executeQuery(SQL);
				  if(resultSet.next()){
					byte[]byteArray= new byte[524288];
					int size= 0;
					inputStream= resultSet.getBinaryStream(1);
					httpResponse.reset();
					httpResponse.setContentType("image/jpeg");
					 while((size= inputStream.read(byteArray))!= -1){
						 httpResponse.getOutputStream().write(byteArray, 0, size);
					 }
				  }
			} catch(IOException eIO) {
				System.out.println("I/O error in retreiveImage servlet"+eIO);
			}catch(Exception e){
				System.out.println("Error in retreiveImage servlet"+e);
			}
		}
}
