package data.client;


import data.client.domain.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@FeignClient(name="userClient", url="http://localhost:11011")
public interface UserClient {

    @RequestMapping(method = RequestMethod.GET, value = "/user/details/{userid}")
    User findUserById(@PathVariable("userid") String userId);

}
