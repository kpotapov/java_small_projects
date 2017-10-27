package data.client.domain;

public class GenericUser {

	private User user;
	private Address address;

	public GenericUser() {
	}

	public GenericUser(User user, Address address) {
		this.user = user;
		this.address = address;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}
