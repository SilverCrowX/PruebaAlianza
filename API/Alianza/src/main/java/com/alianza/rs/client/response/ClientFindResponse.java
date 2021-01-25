package com.alianza.rs.client.response;

import com.alianza.rs.entity.Client;
import com.alianza.rs.utilities.DateManagement;
import com.alianza.rs.utilities.FLog;

public class ClientFindResponse {

	private Long id;
	private String key;
	private String businessId;
	private String email;
	private Long number;
	private String date;

	public ClientFindResponse(Client client) {

		if (client != null) {
			try {
				this.key = client.getSharedKey();
				this.id = client.getId();
				this.businessId = client.getBusinessId();
				this.email = client.getEmail();
				this.number = client.getPhone();
				this.date = DateManagement.getDateToString(client.getDateAdded());
			} catch (Exception e) {
				FLog.getLogger().warn("ClientFindResponse: ", e);
			}
		}

	}

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

	public String getBusinessId() {
		return businessId;
	}

	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "ClientFindResponse [id=" + id + ", key=" + key + ", businessId=" + businessId + ", email=" + email
				+ ", number=" + number + ", date=" + date + "]";
	}

}
