package Tester;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import static dbUtils.DBUtils.openConnection;

public class TestUpdate {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in);
				Connection cn = openConnection();
				PreparedStatement pst = cn.prepareStatement("update emp set ename = ? where empno = ?");
				PreparedStatement pstDisplay = cn.prepareStatement("Select empno,ename from emp where empno = ?");) {
			System.out.println("Enter empno whose name you want to update..");
			int empno = sc.nextInt();
			System.out.println("Enter new name..");
			String ename = sc.next();

			pst.setInt(2, empno);
			pst.setString(1, ename);

			pst.execute();
			int updateCount = pst.getUpdateCount();
			
			if(updateCount>0) {
				System.out.println("Update successfull..");
			}else {
				System.out.println("No record found..");
			}
			
			
			pstDisplay.setInt(1, empno);

			ResultSet rst = pstDisplay.executeQuery();

			while (rst.next()) {
				System.out.println("Empno: " + rst.getInt(1) + "\nEname: " + rst.getString(2));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
