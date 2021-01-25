package com.alianza.rs.client.response;

public class ClientOperationResponse {

	private String sharedKey;
	private String message;
	private boolean confirmation;

	public String getSharedKey() {
		return sharedKey;
	}

	public void setSharedKey(String sharedKey) {
		this.sharedKey = sharedKey;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isConfirmation() {
		return confirmation;
	}

	public void setConfirmation(boolean confirmation) {
		this.confirmation = confirmation;
	}

	@Override
	public String toString() {
		return "ClientOperationResponse [sharedKey=" + sharedKey + ", message=" + message + ", confirmation="
				+ confirmation + "]";
	}

}
