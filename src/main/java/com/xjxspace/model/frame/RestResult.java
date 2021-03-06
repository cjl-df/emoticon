package com.xjxspace.model.frame;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class RestResult implements Serializable{
	private static final long serialVersionUID = 1456012564784561234L;
	
	private Integer state;

	private boolean success;
	private String msg;
	
	private Object data;
	
	public RestResult(Integer state,String msg, Object data,boolean success){
		this.state =state;
		this.msg =msg;
		this.data =data;
		this.success = success;
	}
	public static RestResult ofSuccess(Object data) {
		return new RestResult(Status.SUCCESS.getCode(), Status.SUCCESS.getStandardMessage(), data,true);
	}

	public static RestResult ofSuccess(Object data,String message) {
		return new RestResult(Status.SUCCESS.getCode(), message, data,true);
	}

	public static RestResult ofError(Status status,String message) {
		return new RestResult(status.getCode(),message, null,false);
	}

	public static RestResult ofError(Status status) {
		return new RestResult(status.getCode(),status.getStandardMessage(), null,false);
	}



	public enum Status {
		SUCCESS(200, "OK"),
		BAD_REQUEST(400, "Bad Request"),
		NOT_FOUND(404, "Not Found"),
		INTERNAL_SERVER_ERROR(500, "Unknown Internal Error"),
		NOT_VALID_PARAM(40005, "Not valid Params"),
		NOT_SUPPORTED_OPERATION(40006, "Operation not supported"),
		NOT_LOGIN(50000, "Not Login");

		private int code;
		private String standardMessage;

		Status(int code, String standardMessage) {
			this.code = code;
			this.standardMessage = standardMessage;
		}

		public int getCode() {
			return code;
		}

		public void setCode(int code) {
			this.code = code;
		}

		public String getStandardMessage() {
			return standardMessage;
		}

		public void setStandardMessage(String standardMessage) {
			this.standardMessage = standardMessage;
		}
	}
}
