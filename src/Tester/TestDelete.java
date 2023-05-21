package Tester;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;
import static dbUtils.DBUtils.openConnection;

public class TestDelete {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in);
				Connection cn = openConnection();
				PreparedStatement pst = cn.prepareStatement("delete from emp where empno = ?");) 
		{

			System.out.println("Enter empno..");
			int empno = sc.nextInt();
			pst.setInt(1, empno);
			pst.execute();
			int updateCount = pst.getUpdateCount();
			//System.out.println(updateCount);
			
			if(updateCount>0) {
				System.out.println("Employee deleted successfully..");
			}else {
				System.out.println("No record found..");
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
