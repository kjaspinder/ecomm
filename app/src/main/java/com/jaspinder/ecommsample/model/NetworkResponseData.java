package com.jaspinder.ecommsample.model;

public class NetworkResponseData {
	private String  errorMessage;
	private boolean success;
	private ErrorStatusType errorStatusType = ErrorStatusType.SERVER_ERROR;

	public NetworkResponseData(boolean success) {
		this.success = success;
	}

	public NetworkResponseData(String errorMessage, ErrorStatusType errorStatusType,
							   boolean success) {
		this.errorMessage = errorMessage;
		this.errorStatusType = errorStatusType;
		this.success = success;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public ErrorStatusType getErrorStatusType() {
		return errorStatusType;
	}

	public void setErrorStatusType(ErrorStatusType errorStatusType) {
		this.errorStatusType = errorStatusType;
	}

	@Override
	public String toString() {
		return "NetworkResponseData{" +
				"errorMessage='" + errorMessage + '\'' +
				", success=" + success +
				", errorStatusType=" + errorStatusType +
				'}';
	}
}

