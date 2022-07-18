package com.example.course.entities.pk;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.course.entities.Pedido;
import com.example.course.entities.Produto;

@Embeddable
public class OrderItemPK implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Pedido order;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Produto product;
	
	public Pedido getOrder() {
		return order;
	}
	public void setOrder(Pedido order) {
		this.order = order;
	}
	public Produto getProduct() {
		return product;
	}
	public void setProduct(Produto product) {
		this.product = product;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(order, product);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItemPK other = (OrderItemPK) obj;
		return Objects.equals(order, other.order) && Objects.equals(product, other.product);
	}
	
	
	
}
