package databaseUtilities;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DbUtilities {
    String userName = "postgres";
    String password = "postgres2101";
    String hostName = "localhost";
    String portNumber = "5432";
    String database = "dvdrental";
    String query = "SELECT actor_id, first_name, last_name, last_update FROM public.actor limit 10;";
    String url = "jdbc:postgresql://" + hostName +":"+ portNumber + "/" + database ;

    public Connection connecDB() throws SQLException {
        Connection connection = (Connection) connecDB().createStatement();
        return connection;
    }
    public ResultSet executeSelectQuery(String query) throws SQLException {
      Statement statement = connecDB().createStatement();
      ResultSet resultSet = statement.executeQuery(query);
      return resultSet;
    }

    public  List<String> getAColumn(String query, String columnName) throws SQLException {
        DbUtilities dbUtilities = new DbUtilities();
        List<String> list = new ArrayList<>();
        ResultSet resultSet = dbUtilities.executeSelectQuery(query);
        // Process results
        while (resultSet.next()) {
            list.add(resultSet.getString(columnName));
        }
        System.out.println("Number of records: " + list.size());
        list.forEach(s -> System.out.println(s));
        return list;
    }

    public List<Map<String, String>> processResponseTableInList(String query)throws SQLException{
        ResultSet resultSet =  executeSelectQuery(query);
        List<Map<String, String>> listOfRecords = new ArrayList<>();
        Map<String , String> record = new HashMap<>();
        int i = 0;
        while (resultSet.next()) {
            record = null;
            record.put("actor_id", resultSet.getString("actor_id"));
            record.put("first_name", resultSet.getString("first_name"));
            record.put("last_name", resultSet.getString("last_name"));
            record.put("last_update", resultSet.getString("last_update"));
            listOfRecords.add(i, record);
            i++;
        }

        System.out.println(listOfRecords.size());
        return listOfRecords;

    }
}
