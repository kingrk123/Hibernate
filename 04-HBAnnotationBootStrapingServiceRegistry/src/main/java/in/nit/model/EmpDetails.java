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
@Table(name = "Employee")
public class EmpDetails {

	@Id
	@Column(name = "Eid" ,length = 10)
	private int id;
	
	@Column(name = "FirstName",length = 20)
	private String fname;
	@Column(name = "LastName",length = 20)
	private String lname;
	@Column(name = "Email",length = 20)
	private String mail;
	
}
