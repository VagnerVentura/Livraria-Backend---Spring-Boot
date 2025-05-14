package com.Api.Livraria.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_livros")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "title é obrigatório")
	@Column(name = "title")
	private String title;
	
	@NotBlank(message = "isbnt é obrigatório")
	@Column(unique = true)
	private String isbnt;
	
	private Integer stock;
	
	private LocalDate publicationDate;
	
	private BigDecimal price;
	
	@OneToMany(mappedBy = "book")
	@JsonManagedReference
	private List<OrderItem> orderItems;
	
	@ManyToMany
	@JsonManagedReference
	@JoinTable(name = "books_categories",
	joinColumns = @JoinColumn(name = "book_id"),
	inverseJoinColumns = @JoinColumn(name = "category_id"))
	private List<Category> categories;
	
    @NotNull(message = "autor é obrigatório")
    @ManyToOne
    @JoinColumn(name="author_id")
    @JsonBackReference
    private Author author;
    
    @NotNull(message = "editora é obrigatório")
    @ManyToOne
    @JoinColumn(name="publisher_id")
    @JsonBackReference
    private Publisher publisher;
    
    @OneToMany(mappedBy = "book")
    @JsonManagedReference
    private List<Review> reviews;
    
}

