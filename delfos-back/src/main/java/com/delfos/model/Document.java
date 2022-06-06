package com.delfos.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Embeddable
public class Document {

	@NotNull
	@NotBlank
	private int documentType;
	
	@NotNull
	@NotBlank
    @Size(min = 11, max = 14)
	@Column(name = "document_number")
	private String documentNumber;

	public int getDocumentType() {
		return documentType;
	}

	public void setDocumentType(int documentType) {
		this.documentType = documentType;
	}

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	
}
