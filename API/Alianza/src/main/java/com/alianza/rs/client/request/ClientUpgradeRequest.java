package com.alianza.rs.client.request;

public class ClientUpgradeRequest {

	private Long id;
	private String key;
	private String email;
	private String businessId;
	private Long phone;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBusinessId() {
		return businessId;
	}

	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "ClientUpgradeRequest [id=" + id + ", key=" + key + ", email=" + email + ", businessId=" + businessId
				+ ", phone=" + phone + "]";
	}

}
