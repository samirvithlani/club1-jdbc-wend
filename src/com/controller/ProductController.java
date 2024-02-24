package com.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.util.DBConnection;

public class ProductController {

	public void addProduct() {

		Connection conn = DBConnection.getDBConnection();
		if (conn != null) {

			// ? place holder...
			String insertSQL = "insert into product(pname,pprice,pqty,pcolor)values(?,?,?,?)";
			try {
				PreparedStatement pstmt = conn.prepareStatement(insertSQL);
				pstmt.setString(1, "iphone 15");
				pstmt.setInt(2, 140000);
				pstmt.setInt(3, 2);
				pstmt.setString(4, "blue");

				int res = pstmt.executeUpdate();
				if (res > 0) {

					System.out.println(res + " product added...");
				} else {
					System.out.println("error in adding product...");
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public void updateProduct() {

		Connection conn = DBConnection.getDBConnection();
		if (conn != null) {

			String updateSQl = "update product set pname = ? , pprice = ? ,pqty = ? where pid = ?";
			try {
				PreparedStatement pstmt = conn.prepareStatement(updateSQl);
				pstmt.setString(1, "iphone14 pro");
				pstmt.setInt(2, 145600);
				pstmt.setInt(3, 2);
				pstmt.setInt(4, 1);
				
				int res = pstmt.executeUpdate();
				if(res>0) {
					
					System.out.println(res+" product updated..");
				}
				else {
					System.out.println("no product updated..");
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	public void deleteProduct() {
		
		Connection conn = DBConnection.getDBConnection();
		if(conn!=null) {
			
			
			String deleteSQL  = "delete from product where pid = ?";
			try {
				PreparedStatement pstmt = conn.prepareStatement(deleteSQL);
				pstmt.setInt(1, 1);
				int res = pstmt.executeUpdate();
				if(res>0) {
					
					System.out.println(res+" product deleted...");
				}
				else {
					
					System.out.println("no product deleted..");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
				
		
		
	}

	public static void main(String[] args) {

		ProductController productController = new ProductController();
		// productController.addProduct();
//		productController.updateProduct();
		productController.deleteProduct();

	}
}
