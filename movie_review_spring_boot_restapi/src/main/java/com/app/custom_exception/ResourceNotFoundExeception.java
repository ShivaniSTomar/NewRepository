package com.app.custom_exception;

@SuppressWarnings("serial")
public class ResourceNotFoundExeception extends RuntimeException {

	public ResourceNotFoundExeception(String message) {
		super(message);
	}

}
