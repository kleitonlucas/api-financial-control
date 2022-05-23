package com.api.financial.models.dtos;

import java.time.LocalDate;

import com.api.financial.models.enums.OperationCategory;
import com.api.financial.models.enums.OperationType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperationDto {

	private OperationType type;
	private LocalDate dateOperation;
	private double value;
	private OperationCategory category;
	private String description;
	private Integer user;
}
