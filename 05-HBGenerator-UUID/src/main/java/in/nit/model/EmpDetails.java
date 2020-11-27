package in.nit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Emp")
public class EmpDetails {

	@Id
	@Column(name = "Eid" ,length = 10)
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	private String id;
	
	@Column(name = "FirstName",length = 20)
	private String fname;
	@Column(name = "LastName",length = 20)
	private String lname;
	@Column(name = "Email",length = 20)
	private String mail;
	
}
