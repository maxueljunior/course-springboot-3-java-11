package com.example.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.course.entities.Categoria;
import com.example.course.entities.OrderItem;
import com.example.course.entities.Pedido;
import com.example.course.entities.Produto;
import com.example.course.entities.Usuario;
import com.example.course.entities.enums.PedidoStatus;
import com.example.course.repositories.CategoryRepository;
import com.example.course.repositories.OrderItemRepository;
import com.example.course.repositories.PedidoRepository;
import com.example.course.repositories.ProductRepository;
import com.example.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepositoy;
	
	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Electronics");
		Categoria cat2 = new Categoria(null, "Books");
		Categoria cat3 = new Categoria(null, "Computers"); 
		
		Produto p1 = new Produto(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Produto p2 = new Produto(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Produto p3 = new Produto(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Produto p4 = new Produto(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Produto p5 = new Produto(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, ""); 

		
		categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		productRepositoy.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
		
		productRepositoy.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		
		Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456"); 
		Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		
		Pedido o1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"),PedidoStatus.PAID, u1); 
		Pedido o2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"),PedidoStatus.WAITING_PAYMENT, u2); 
		Pedido o3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"),PedidoStatus.WAITING_PAYMENT, u1); 
		
		userRepository.saveAll(Arrays.asList(u1,u2));
		pedidoRepository.saveAll(Arrays.asList(o1,o2,o3));
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());
		
		orderItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));
		
		
		
	}
	
	
}
