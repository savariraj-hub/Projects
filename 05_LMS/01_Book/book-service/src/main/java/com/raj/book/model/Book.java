package com.raj.book.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "book")
public class Book {
	
	@Id
//	@GeneratedValue(strategy = GenerationType.TABLE)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="book_seq")
	@SequenceGenerator(name = "book_seq", sequenceName = "book_seq", initialValue = 1, allocationSize=1)
	@Column(name = "book_id")
	private long bookId;
	
	@NotBlank(message = "* BooK title is mandatory")
	@Column(name = "title")
	private String title;	
	
	@NotBlank(message = "* BooK author is mandatory")
	@Column(name = "author")
	private String author;
	
//	@NotBlank(message = "* BooK cost is mandatory")
	@Column(name = "cost")
	private double cost;
	
	@Column(name = "user_id", nullable = true)
	private long userId;
	
	@Temporal( TemporalType.TIMESTAMP )
	@CreationTimestamp
	@Column(name = "create_on")
	private Date bookCreated;
	
	@Temporal( TemporalType.TIMESTAMP )
	@UpdateTimestamp
	@Column(name = "update_on")
	private Date bookUpdated;
	
	
}
