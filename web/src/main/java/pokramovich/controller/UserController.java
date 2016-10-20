package pokramovich.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pokramovich.domain.pojo.User;
import pokramovich.service.userservice.UserService;

import java.util.concurrent.ExecutionException;

/**
 * Created by Pokramovich on 21.09.2016.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/getAll")
    public String getAllUsers(ModelMap model) {
        model.put("users", userService.getAll());
        System.out.println(model.get("users"));
        return "getAllUsers";
    }

    @GetMapping(value = "/createTestInformation")
    public String createTestInformation() {
        userService.createTestInformation();
        return "main";
    }
    @GetMapping(value = "/getAllAsync")
    public String getAllAsync(ModelMap model) throws ExecutionException, InterruptedException {
        for(int i=0;i<Integer.MAX_VALUE;i++){
           userService.getAllAsync().get();

        }


        return "getAllUsers";
    }
}
