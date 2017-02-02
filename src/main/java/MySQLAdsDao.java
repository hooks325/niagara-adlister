import com.mysql.jdbc.Driver;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nedwaldie on 2/1/17.
 */
public class MySQLAdsDao implements Ads {
    private Connection connection;

    public MySQLAdsDao() {
        Config config = new Config();
        Driver driver;

        try {
            driver = new Driver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUsername(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Ad> all() throws SQLException {
        String selectQuery = "SELECT * FROM ads";
        DriverManager.registerDriver(new Driver());

        // Create new list
        List<Ad> ads = new ArrayList<>();

        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(selectQuery);
        while (rs.next()) {
            // add a new Ad object to the ads list inside this loop
            long id = rs.getLong("id");
            //long userId = rs.getLong("userId");
            String title = rs.getString("title");
            String description = rs.getString("description");

            //user the rs.getLong(), getString, methods to grab values from the row (inthe db)
            // use those values to instantiate a new ad objects passing them to the constructor
            Ad ad = new Ad(id, 0, title, description);
            // add that new ad object to the ads arraylist
            ads.add(ad);
        }
        return ads;
    }

    public Long insert(Ad ad) {
        // insert into ads (column1, column2, column3)

        return null;
    }

    public Ad find(int id) {
        // Select * from ads where id = id
        return null;
    }
}
