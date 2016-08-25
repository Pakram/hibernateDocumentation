package controller;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Pokramovich on 23.08.2016.
 */
@Controller
public class HelloController {
@Autowired
    DataSource dataSource;
    @GetMapping(value = "/hello")
    public String printWelcome(ModelMap model) throws SQLException {
Connection conn=dataSource.getConnection();
        model.addAttribute("message", "Spring 3 MVC - Hello World");
        return "hello";

    }

}
