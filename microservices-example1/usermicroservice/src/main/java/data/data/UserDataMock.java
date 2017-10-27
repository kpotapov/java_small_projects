package data.data;

import data.domain.User;

public class UserDataMock implements UserData {

    @Override
    public User getUserDetails(String userId) {
        if ("1".equals(userId)) {
            return new User("one", "1");
        } else {
            return new User("two-and-more", "2");
        }
    }
}
