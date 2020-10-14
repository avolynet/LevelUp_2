package ru.levelup.musicians.library.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnectionService {

    static {
        registerJdbcDriver();
    }
    private static void registerJdbcDriver(){
        try {
            Class.forName("org.postgresql.Driver");//загрузка в память
            // инициализируется объект Class класса класс, объект этого класса нельзя создать, содержит метаданные нашего класса
        } catch (ClassNotFoundException e) {
            throw  new RuntimeException("Couldn't register JDBC driver", e);
        }
    }

    public Connection openConnection(){ // если этот объект есть, то мы подключились к базе
        //Connection - phusical access
        try {
            return DriverManager.getConnection(

                    "jdbc:postgresql://127.0.0.1:5432/banks",//jdbc:<vendor_name>://<host>:<port>/<db_name>?<external_parameter>
                    "postgres",
                    "123"
            );
        } catch (SQLException exc) {
            throw new RuntimeException("Couldn't open connection to db", exc);
        }
    }
}
