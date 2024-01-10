package com.nokia.hotel.payload.response;

import java.time.LocalDate;

public class ApiResponse<T> {
	
	private T data;
	
	public T getData() {
        return data;
    }

    private LocalDate date;
	
	public LocalDate getDate() {
        return date;
    }

    private String message;

    public String getMessage() {
        return message;
    }
    public ApiResponse(T data, LocalDate date, String message) {
        this.data = data;
        this.date = date;
	    this.message = message;
	  }
}
