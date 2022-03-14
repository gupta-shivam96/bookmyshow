package com.webapp.bookmyshowapp.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="ticket")
@Getter
@Setter
public class Ticket implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -140417518244076644L;

	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "theater_id", referencedColumnName = "id")
	private Theater theater;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id", referencedColumnName = "id")
    private Movie movie;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "show_id", referencedColumnName = "id")
    private Show show;
    
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate showDate;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime bookingDate;
    
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "seat_detail_id", nullable = false)
    private SeatDetail seatDetail;
    
    private Double price;
    
    @Transient
    private String invoiceNumber;
    
    public String getInvoiceNumber() {
    	this.invoiceNumber = this.theater.getSubRegion().getCity().getName().substring(0, 3).toUpperCase() + 
    	this.theater.getSubRegion().getRegionName().substring(0,3).toUpperCase() + this.theater.getName().substring(0,3).toUpperCase() + 
    	this.movie.getName().substring(0,3).toUpperCase() + String.valueOf(this.show.getShowTime()) + String.valueOf(this.showDate);
    	return this.invoiceNumber;
    }
    
    
    
    
}
