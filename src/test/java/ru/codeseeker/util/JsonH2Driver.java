package ru.codeseeker.util;

import org.h2.Driver;
import org.h2.jdbc.JdbcConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JsonH2Driver extends Driver {
    @Override
    public Connection connect(String url, Properties info) throws SQLException {
        JdbcConnection connect = (JdbcConnection) super.connect(url, info);
        Statement statement = connect.createStatement();
        statement.execute("CREATE TYPE IF NOT EXISTS JSONB AS JAVA_OBJECT;");
        return connect;
    }
}
