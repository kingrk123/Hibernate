package in.nit.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="std_tab")
public class Student {
	/*@Id
	@Column(name="sid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)*/
	
	@Id
	@Column(name="sid")
	@SequenceGenerator(name = "gen1" ,sequenceName = "stno_seq1",initialValue = 10, allocationSize = 20)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer stdId;

	@Column(name="sname")
	private String stdName;

	@Column(name="semail")
	private String email;

}
