package com.raj.book.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	private long userId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private Date userCreated;
	private Date userUpdated;
}
