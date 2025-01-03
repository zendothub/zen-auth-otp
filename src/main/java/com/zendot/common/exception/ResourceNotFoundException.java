package com.zendot.common.exception;

import java.io.Serial;

public class ResourceNotFoundException extends RuntimeException {

	@Serial
	private static final long serialVersionUID = -2947210857950100650L;

	public ResourceNotFoundException(String errorMessage) {
		super(errorMessage);
	}
}
