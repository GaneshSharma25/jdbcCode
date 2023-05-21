package Tester;

import static dbUtils.DBUtils.openConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class TestPst {

	public static void main(String[] args) throws SQLException {

		try (Scanner sc = new Scanner(System.in);
				Connection cn = openConnection();
				PreparedStatement pst = cn.prepareStatement("Select id,first_name,last_name,role from users");
				ResultSet rst = pst.executeQuery();) {
//id | first_name | last_name | email_id| password | reg_amt | reg_date   | role			
			while (rst.next()) {
				System.out.println("id : " + rst.getInt(1) + " Name : " + rst.getString(2) + " " + rst.getString(3)
						+ "-- Role : " + rst.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
