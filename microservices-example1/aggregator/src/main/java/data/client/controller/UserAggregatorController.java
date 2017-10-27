package data.client.controller;

import data.client.AddressClient;
import data.client.UserClient;
import data.client.domain.Address;
import data.client.domain.GenericUser;
import data.client.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.websocket.server.PathParam;

@Component
@RestController
@EnableFeignClients
public class UserAggregatorController {

    @Autowired
    UserClient userClient;

    @Autowired
    AddressClient addressClient;

    @RequestMapping(value = "/user/details/{userid}",
            method = RequestMethod.GET,
            produces = {"application/json"})
    public GenericUser userDetails(@PathVariable(value = "userid") String userid) {
        User userById = userClient.findUserById(userid);
        Address addressClientUserById = addressClient.findUserById(userid);

        GenericUser genericUser = new GenericUser(userById, addressClientUserById);
        return genericUser;
    }

    @RequestMapping(value = "/user/details/view/{userid}",
            method = RequestMethod.GET,
            produces = {"application/json"})
    public ModelAndView userDetailsView(@PathVariable(value = "userid") String userid) {
        User userById = userClient.findUserById(userid);
        Address addressClientUserById = addressClient.findUserById(userid);

        GenericUser genericUser = new GenericUser(userById, addressClientUserById);
        return new ModelAndView("messages/genericUser", "genericUser", genericUser);
    }

}


