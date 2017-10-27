package data;

import data.data.UserData;
import data.domain.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")

public class UserController {
    private Log log = LogFactory.getLog(UserController.class);

    UserData userProvider;

    @Autowired
    public UserController(UserData userProvider) {
        this.userProvider = userProvider;
    }

    @RequestMapping(value = "/details/{userId}",
            produces = {"application/json"})
    public User details(@PathVariable(value = "userId") String userId) {
        return userProvider.getUserDetails(userId);
    }

}
