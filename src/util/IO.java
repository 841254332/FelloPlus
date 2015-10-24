package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class IO {
	private static String charset = "UTF-8";
	// private static String sql;
	// private static String table;

	//获取数据库数据
	public static Statement connectmsql(String database) {
		String driver = "com.mysql.jdbc.Driver";

		// URL指向要访问的数据库名scutcs
		String url = "jdbc:mysql://127.0.0.1:3306/"+database;

		// MySQL配置时的用户名
		String user = "root";

		// MySQL配置时的密码
		String password = "1234";

		Statement statement = null;
		
		ResultSet rs = null;
		Connection conn = null;
		try {
			// 加载驱动程序
			Class.forName(driver);

			// 连续数据库
			conn = DriverManager.getConnection(url, user, password);
			statement = conn.createStatement();
			
		} catch (ClassNotFoundException e) {
			System.out.println("Sorry,can`t find the Driver!");
			e.printStackTrace();

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return statement;
		
	}
	
	// 存进数据库
	public static void savetomysql(String database,String sql) {
		String driver = "com.mysql.jdbc.Driver";

		// URL指向要访问的数据库名scutcs
		String url = "jdbc:mysql://127.0.0.1:3306/"+database;

		// MySQL配置时的用户名
		String user = "root";

		// MySQL配置时的密码
		String password = "1234";

		Statement statement = null;

		try {
			// 加载驱动程序
			Class.forName(driver);

			// 连续数据库
			Connection conn = DriverManager.getConnection(url, user, password);

//			if (!conn.isClosed())
//				System.out.println("Succeeded connecting to the Database!");

			// statement用来执行SQL语句
			statement = conn.createStatement();
			int rs = statement.executeUpdate(sql);

			conn.close();
		} catch (ClassNotFoundException e) {
			System.out.println("Sorry,can`t find the Driver!");
			e.printStackTrace();

		} catch (SQLException e) {
			// System.out.println(company);
			e.printStackTrace();

		} catch (Exception e) {

			e.printStackTrace();

		}
	}

	// 字符串输出到文件
	public static void print(String content, String path) {
		try {
			PrintWriter pw = new PrintWriter(new File(path), charset);
			pw.print(content);
			pw.close();
		} catch (Exception ex) {
		}
	}

	// 字符串输出追加到文件
	public static void append(String content, String path) {
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(new File(path), true));
			pw.append(content);
			pw.close();
		} catch (Exception ex) {
		}
	}

	// 字符串数组输出到文件
	public static void print(List<String> list, String path) {
		try {
			PrintWriter pw = new PrintWriter(new File(path), charset);
			for (String line : list)
				pw.println(line);
			pw.close();
		} catch (Exception ex) {
		}
	}

	// 字符串数组追加到文件
	public static void append(List<String> list, String path) {
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(new File(path), true));
			for (String line : list)
				pw.println(line);
			pw.close();
		} catch (Exception ex) {
		}
	}

	// 读取字符串列表
	public static List<String> readList(String path) {
		List<String> idList = new ArrayList<>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File(path)));
			String line;
			while ((line = reader.readLine()) != null) {
				if (line.replaceAll("\\s+", "").length() > 0)
					idList.add(line);
			}
			reader.close();
		} catch (Exception ex) {
		}
		return idList;
	}

}
