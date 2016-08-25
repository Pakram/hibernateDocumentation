
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pojo.Event;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Pokramovich on 22.07.2016.
 */
@Component
public class Main {
    private final
    DataSource dataSource;

    @Autowired
    public Main(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static void main(String[] args) {


    }

    void test(){
        try {
          Connection conn= dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
