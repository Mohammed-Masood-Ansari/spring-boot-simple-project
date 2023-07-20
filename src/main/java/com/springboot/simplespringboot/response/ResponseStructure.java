package com.springboot.simplespringboot.response;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class ResponseStructure<T> {

	private int statusCode;
	private LocalDateTime dateTime;
	private String statusMessage;
	private String description;
	private T data; 
}
