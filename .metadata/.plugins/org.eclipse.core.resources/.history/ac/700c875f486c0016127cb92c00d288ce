import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
@Entity
@Table(name="bond")
public class Bond implements Serializable {
	private static final long serialVersionUID = 1L;
	private int serialID;
	private String issuerName;
	private String bondID;
	private Double couponPrice;
	private Date maturityDate;
	private Double dayHigh;
	private Double dayLow;
	private Double closePrice;
	private Double yield;
	private Double change;
	private Date startDate;
	private String creditRating;
	private String bondType;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getSerialID() {
		return serialID;
	}
	public void setSerialID(int serialID) {
		this.serialID = serialID;
	}
	public String getIssuerName() {
		return issuerName;
	}
	public void setIssuerName(String issuerName) {
		this.issuerName = issuerName;
	}
	public String getBondID() {
		return bondID;
	}
	public void setBondID(String bondID) {
		this.bondID = bondID;
	}
	public Double getCouponPrice() {
		return couponPrice;
	}
	public void setCouponPrice(Double couponPrice) {
		this.couponPrice = couponPrice;
	}
	public Date getMaturityDate() {
		return maturityDate;
	}
	public void setMaturityDate(Date maturityDate) {
		this.maturityDate = maturityDate;
	}
	public Double getDayHigh() {
		return dayHigh;
	}
	public void setDayHigh(Double dayHigh) {
		this.dayHigh = dayHigh;
	}
	public Double getDayLow() {
		return dayLow;
	}
	public void setDayLow(Double dayLow) {
		this.dayLow = dayLow;
	}
	public Double getClosePrice() {
		return closePrice;
	}
	public void setClosePrice(Double closePrice) {
		this.closePrice = closePrice;
	}
	public Double getYield() {
		return yield;
	}
	public void setYield(Double yield) {
		this.yield = yield;
	}
	public Double getChange() {
		return change;
	}
	public void setChange(Double change) {
		this.change = change;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public String getCreditRating() {
		return creditRating;
	}
	public void setCreditRating(String creditRating) {
		this.creditRating = creditRating;
	}
	public String getBondType() {
		return bondType;
	}
	public void setBondType(String bondType) {
		this.bondType = bondType;
	}	
	

}
