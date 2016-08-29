package electronic.bondtrader.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the bondsmaster database table.
 * 
 */
@Entity
@Table(name="bondsmaster")
@NamedQuery(name="Bond.findAll", query="SELECT b FROM Bond b")
public class Bond implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String bond_ID;

	private String bond_Currency;

	private String bond_Type;

	private BigDecimal change;

	private BigDecimal coupon_Rate;

	private String credit_Rating;

	private BigDecimal high;

	private String issuer_Name;

	private BigDecimal last;

	private BigDecimal low;

	private String maturity_Date;

	private int serial_ID;

	private String start_Date;

	private BigDecimal yield;

	public Bond() {
	}

	public String getBond_ID() {
		return this.bond_ID;
	}

	public void setBond_ID(String bond_ID) {
		this.bond_ID = bond_ID;
	}

	public String getBond_Currency() {
		return this.bond_Currency;
	}

	public void setBond_Currency(String bond_Currency) {
		this.bond_Currency = bond_Currency;
	}

	public String getBond_Type() {
		return this.bond_Type;
	}

	public void setBond_Type(String bond_Type) {
		this.bond_Type = bond_Type;
	}

	public BigDecimal getChange() {
		return this.change;
	}

	public void setChange(BigDecimal change) {
		this.change = change;
	}

	public BigDecimal getCoupon_Rate() {
		return this.coupon_Rate;
	}

	public void setCoupon_Rate(BigDecimal coupon_Rate) {
		this.coupon_Rate = coupon_Rate;
	}

	public String getCredit_Rating() {
		return this.credit_Rating;
	}

	public void setCredit_Rating(String credit_Rating) {
		this.credit_Rating = credit_Rating;
	}

	public BigDecimal getHigh() {
		return this.high;
	}

	public void setHigh(BigDecimal high) {
		this.high = high;
	}

	public String getIssuer_Name() {
		return this.issuer_Name;
	}

	public void setIssuer_Name(String issuer_Name) {
		this.issuer_Name = issuer_Name;
	}

	public BigDecimal getLast() {
		return this.last;
	}

	public void setLast(BigDecimal last) {
		this.last = last;
	}

	public BigDecimal getLow() {
		return this.low;
	}

	public void setLow(BigDecimal low) {
		this.low = low;
	}

	public String getMaturity_Date() {
		return this.maturity_Date;
	}

	public void setMaturity_Date(String maturity_Date) {
		this.maturity_Date = maturity_Date;
	}

	public int getSerial_ID() {
		return this.serial_ID;
	}

	public void setSerial_ID(int serial_ID) {
		this.serial_ID = serial_ID;
	}

	public String getStart_Date() {
		return this.start_Date;
	}

	public void setStart_Date(String start_Date) {
		this.start_Date = start_Date;
	}

	public BigDecimal getYield() {
		return this.yield;
	}

	public void setYield(BigDecimal yield) {
		this.yield = yield;
	}

}