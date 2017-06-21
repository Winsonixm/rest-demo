package com.example.exceptions;

public class NotFoundException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 4250802240551667998L;

	public NotFoundException(String msg) {
        super(msg);
    }
}
