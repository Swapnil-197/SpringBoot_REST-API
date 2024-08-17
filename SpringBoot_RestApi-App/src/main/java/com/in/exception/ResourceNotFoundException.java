package com.in.exception;

public class ResourceNotFoundException extends RuntimeException{

	public ResourceNotFoundException(String errmsg) {
		super(errmsg);
	}
}
