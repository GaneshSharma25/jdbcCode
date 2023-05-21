package Tester;
import static dbUtils.DBUtils.openConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class TestEmp {
	
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in);		
			Connection cn = openConnection();
			PreparedStatement pst = cn.prepareStatement("select empno,ename,sal from emp where sal >= ?");	
		   )
		{
			System.out.println("enter salary..");
			double salary = sc.nextDouble();
			pst.setDouble(1, salary);
			ResultSet rst = pst.executeQuery();
			
			while(rst.next()) {
				System.out.println("empNo: "+rst.getInt(1) +" Ename: " +rst.getString(2) +" Salary: "+rst.getDouble(3));
			}	
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
