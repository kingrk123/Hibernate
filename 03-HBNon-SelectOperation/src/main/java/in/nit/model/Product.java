package in.nit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="prdtab")
public class Product {

	@Id
	@Column(name = "pId")
	private int pid;
	@Column(name = "pName")
	private String pname;
	@Column(name = "price")
	private float price;
	@Column(name = "qty")
	private int qty;
	
}
