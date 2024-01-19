package com.app.entitities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name="reviews", uniqueConstraints = @UniqueConstraint(columnNames = {"movie_id", "user_id"}))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true, exclude = {"movie","user"})
public class Review extends BaseEntity{
	
	/*movie_id INT,
	review VARCHAR(1024),
	rating INT,
	user_id INT,
	modified TIMESTAMP,*/
	
	@Column(length=1024)
	private String review;
	
	@Column(name="rating")
	private Integer rating;
	
	private Timestamp modified;
	
	@ManyToOne
	@JoinColumn(name="movie_id",nullable = false)
	private Movie movie;
	
	@ManyToOne
	@JoinColumn(name="user_id", nullable=false)
	private User user;
	
	@PrePersist
    @PreUpdate
    public void prePersistAndUpdate() {
        this.modified = new Timestamp(System.currentTimeMillis());
    }
		
}
