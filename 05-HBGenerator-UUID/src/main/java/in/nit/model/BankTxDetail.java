package in.nit.model;

import java.util.Date;

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
@Table(name = "Bank_Tx_Detail")
public class BankTxDetail {

	@Id
	@GenericGenerator(name = "gen1", strategy = "increment")
	@GeneratedValue(generator = "gen1")
	
	/*	@Id
	@GenericGenerator(name = "gen1", strategy = "sequence")
	@GeneratedValue(generator = "gen1")
	 */
	/*	@Id
	@GenericGenerator(name = "gen1",
	 					strategy = "sequence"
	 					parameters = @Parameter(name ="sequence_name", value= "TxId_SEQ")
						)
	@GeneratedValue(generator = "gen1")
	 */
	private int txId;
	
	private String txName;
	private float txAmount;
	private Date txDate;
}
