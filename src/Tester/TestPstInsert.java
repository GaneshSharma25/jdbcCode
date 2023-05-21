package Tester;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import static dbUtils.DBUtils.openConnection;

public class TestPstInsert {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in);
				Connection cn = openConnection();
				PreparedStatement pst = cn
						.prepareStatement("insert into emp(empno,ename,job,hiredate,sal) values(?,?,?,?,?)");
				PreparedStatement pstDisplay = cn
						.prepareStatement("select empno,ename,job,hiredate,sal from emp where empno = ?");) {

			System.out.println("Enter empno,ename,job,hireDate,sal to insert a record in emp table..");
			int empno = sc.nextInt();
			String ename = sc.next();
			String job = sc.next();
			Date hireDate = Date.valueOf(sc.next());
			double sal = sc.nextDouble();

			pst.setInt(1, empno);
			pst.setString(2, ename);
			pst.setString(3, job);
			pst.setDate(4, hireDate);
			pst.setDouble(5, sal);
			pst.execute();

			int updateCount = pst.getUpdateCount();
			// System.out.println(updateCount);

			if (updateCount > 0) {
				System.out.println("Insert Successfull..");
			}

			pstDisplay.setInt(1, empno);
			ResultSet rstDisplay = pstDisplay.executeQuery();
			while (rstDisplay.next()) {
				System.out.println("empId: " + rstDisplay.getInt(1) + "\nename: " + rstDisplay.getString(2) + "\njob: "
						+ rstDisplay.getString(3) + "\nhireDate: " + rstDisplay.getDate(4) + "\nsalary: "
						+ rstDisplay.getDouble(5));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
