package ru.job4j.crud.setting;

import org.apache.log4j.Logger;
import ru.job4j.crud.listners.ConnectionDb;
import ru.job4j.crud.load.LoadResource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Yury Matskevich
 */
public class SettingUpDb {
	private static final Logger LOG = Logger.getLogger(ConnectionDb.class);
	private LoadResource res = new LoadResource("/db.properties");
	private String url = res.getProperty("db.path");
	private String username = res.getProperty("db.username");
	private String password = res.getProperty("db.password");
	private String createTable = res.getProperty("db.createTable");
	private String fillTable = res.getProperty("db.fillTables");

	public void clearDb() {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			LOG.error(e.getMessage(), e);
		}
		try (Connection conn = DriverManager.getConnection(url, username, password);
			Statement statement = conn.createStatement()) {
			statement.execute("DROP SCHEMA public CASCADE; CREATE SCHEMA public;");
		} catch (SQLException e) {
			LOG.error(e.getMessage(), e);
		}
	}

	public void fillDb() {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			LOG.error(e.getMessage(), e);
		}
		try (Connection conn = DriverManager.getConnection(url, username, password);
			 Statement statement = conn.createStatement()) {
			statement.execute(String.format("%s%s", createTable, fillTable));
		} catch (SQLException e) {
			LOG.error(e.getMessage(), e);
		}
	}
}
