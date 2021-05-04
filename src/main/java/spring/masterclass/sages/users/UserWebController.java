package spring.masterclass.sages.users;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class UserWebController {

    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping("show-users.html")
    public ModelAndView showUsers(@RequestParam(defaultValue = "0") int pageNumber,
                                  @RequestParam(defaultValue = "5") int pageSize) {

        var users = userService.getAll(pageNumber, pageSize);

        ModelAndView modelAndView = new ModelAndView("users");
        modelAndView.addObject("users", users);

        return modelAndView;
    }

}
