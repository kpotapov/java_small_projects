package ex1.data.data;

import ex1.data.domain.Address;

public class AddressDataMock implements AddressData {

    @Override
    public Address getAddress(String userId) {
        if ("1".equals(userId)) {
            return new Address("1", "N", "n1","1/12");
        } else if ("10".equals(userId)) {
            return new Address("10", "N", "n10","10");
        } else {
            return new Address("13", "Z", "n13","13");
        }
    }
}
