package com.nokia.hotel.payload.response;
import java.util.List;

public class UserInfoResponse {
	private Long id;
	private String username;
	private String fullName;
  	private String phoneNumber;
	private String email;
	private List<String> roles;

	public UserInfoResponse(Long id, String username, String fullName, String phoneNumer, String email, List<String> roles) {
		this.id = id;
		this.username = username;
		this.fullName = fullName;
		this.phoneNumber = phoneNumer;
		this.email = email;
		this.roles = roles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<String> getRoles() {
		return roles;
	}
	public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phoneNumber;
    }

    public void setPhone(String phone) {
        this.phoneNumber = phone;
    }
}
