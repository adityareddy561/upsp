package com.upspapp.modal;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.upspapp.constants.Constants;

@Entity(name = Constants.SELLER_TABLE_NAME)
@JsonIgnoreProperties
public class Seller extends User {

	private static final long serialVersionUID = 1L;

}
