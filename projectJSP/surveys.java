import java.sql.*;
import java.text.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class surveys {
  public Connection conn;
  public Statement stmt;
  public int total;
  public int votes;
  String names[];
  String v[];
  DecimalFormat twoDigits = new DecimalFormat("0.00");
  public surveys() throws SQLException {
    DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
    conn = DriverManager.getConnection
        ("jdbc:oracle:thin:@localhost:1521:orcl", "aglan", "aglan");
  }

  void addVote(int value) throws SQLException {
    String query = "update surveyresults set votes=votes+1 where aid= " + value;
    stmt = conn.createStatement();
    stmt.executeUpdate(query);
  }

  void getAll() throws SQLException {
    // get total of all survey responses
    String query = "select surveyoption,votes,aid from surveyresults";
    ResultSet totalRS = stmt.executeQuery(query);
    totalRS.next();
    total = totalRS.getInt(1);

    // get results
    query = "SELECT surveyoption, votes, aid FROM surveyresults " +
        "ORDER BY id";
    ResultSet resultsRS = stmt.executeQuery(query);

    // process results
    names =new String[total];
    v=new String[total];
    int num=0;
    while (resultsRS.next()) {
      names[num]=resultsRS.getString(1);
      votes = resultsRS.getInt(2);
      v[num]=twoDigits.format((double) (votes / total * 100));
      num++;
    }

    resultsRS.close();

  }

  void finish() throws SQLException {
    //rs.close();
    conn.close();
  }
}
