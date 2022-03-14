package com.webapp.bookmyshowapp.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="casting")
@Getter@Setter
public class Casting implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -7043767503442215835L;

	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String castName;

    private String castImage;

}
