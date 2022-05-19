package com.api.financial.models.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.api.financial.models.enums.CategoryType;
import com.api.financial.models.enums.OperationType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Operation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false, name = "type")
	private OperationType type;
	@Column(nullable = false, name = "date_operation")
	private Date dateOperation;
	@Column(nullable = false, name = "value")
	private double value;
	@Column(nullable = false, name = "category")
	private CategoryType category;
	@Column(length = 200, name = "description")
	private String description;
	@ManyToOne
	@JoinColumn(name = "user_id")
	@NotNull
	private User user;
}
