package in.srivath.util;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionFactory {
	private static DataSource dataSource = null;

	public static Connection getConnection() throws SQLException {
		if (dataSource == null) {
			try {
				FileInputStream fis = new FileInputStream(
						new File("C:\\Users\\SRIVATH\\new-eclipse-ws\\Servlet-04-UserLoginApp\\dbconfig.properties"));
				Properties prop = new Properties();
				prop.load(fis);
				HikariConfig config = new HikariConfig();
				config.setDriverClassName(prop.getProperty("db.driver"));
				config.setJdbcUrl(prop.getProperty("db.url"));
				config.setUsername(prop.getProperty("db.username"));
				config.setPassword(prop.getProperty("db.password"));
				dataSource = new HikariDataSource(config);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dataSource.getConnection();
	}
}
