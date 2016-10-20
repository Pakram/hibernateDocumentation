package pokramovich.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;


import java.sql.SQLException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.oracle.jrockit.jfr.ContentType.Address;

/**
 * Created by Pokramovich on 23.08.2016.
 */
@Controller
public class HelloController {

    @GetMapping("/")
    public String mainPage(){
        return "home";
    }


}
