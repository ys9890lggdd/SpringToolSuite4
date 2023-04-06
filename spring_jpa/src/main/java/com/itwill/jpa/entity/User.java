package com.itwill.jpa.entity;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.ColumnDefault;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
@RequiredArgsConstructor
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity(name = "users")
@SequenceGenerator(	name = "users_id_SEQ_gen",
					sequenceName ="users_id_SEQ",
					initialValue = 1 ,
					allocationSize = 1)
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "users_id_SEQ_gen")
	@Column(name = "id")
	private Long id;
	
	@NonNull
	@Column(nullable = false)
	private String name;
	@NonNull
	private String email;
	
	@NonNull
	@Column(nullable = false,updatable = false)
	private LocalDateTime createdAt;
	
	@NonNull
	@Column(nullable = false)
	private LocalDateTime updatedAt;
	
}
