package in.nit.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Bank_Account")
public class BankAccount implements Serializable {

	@Id
	@Column(length = 10)
	@SequenceGenerator(name = "gen1",initialValue = 10, allocationSize = 1)
	@GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)
	private long acNo;
	
	private String holderName;
	private String type;
	private float balance;
	@Version
	private int version;
	@Column
	@UpdateTimestamp
	private Timestamp lastOperated;
	@Column
	@CreationTimestamp
	private Timestamp openingDate;
	
}
