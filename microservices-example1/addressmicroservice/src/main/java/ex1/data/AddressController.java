package ex1.data;

import ex1.data.data.AddressData;
import ex1.data.domain.Address;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/address")

public class AddressController {
    private Log log = LogFactory.getLog(AddressController.class);

    AddressData addressProvider;

    @Autowired
    public AddressController(AddressData addressProvider) {
        this.addressProvider = addressProvider;
    }

    @RequestMapping(value = "/details/{userId}",
            produces = {"application/json"})
    public Address details(@PathVariable(value = "userId") String userId) {
        return addressProvider.getAddress(userId);
    }

}
