package com.Api.Livraria.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.Api.Livraria.dto.SaleDto;
import com.Api.Livraria.entities.Book;
import com.Api.Livraria.entities.Client;
import com.Api.Livraria.entities.Employee;
import com.Api.Livraria.entities.ItemSale;
import com.Api.Livraria.entities.Sale;
import com.Api.Livraria.repositories.EmployeeRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private SaleService saleService;

	@Autowired
	private BookService bookService;
	

	public Sale sellBook(SaleDto saleDto) {
		
		Employee employee = employeeRepository.findById(saleDto.employeeId())
				.orElseThrow(() -> new RuntimeException("Employee not Found! "));
		
		Client client = clientService.findById(saleDto.clientId());
				
		Sale newSale = new Sale();
		newSale.setDate(LocalDateTime.now());
		newSale.setClient(client);
		
		List<ItemSale> items = saleDto
				.itemsSale()
				.stream()
				.map(item -> {
					Book book = bookService.findById(item.bookId());
					return new ItemSale(null,
							book, 
							newSale,
							item.quantity());
					//setar quantidade
					//calcular preço
				})
				.collect(Collectors.toList());
		
		newSale.setItemsSale(items);
		
		
		return null;
	}
	

	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

}
