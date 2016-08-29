package electronic.bondtrader.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the trade details database table.
 * 
 */
@Entity
@Table(name="tradedetails")
@NamedQuery(name="Trade.findAll", query="SELECT t FROM Trade t")

public class Trade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int order_ID;

	private String bond_ID;

	private BigDecimal trade_Amount;

	private String trade_Date;

	private BigDecimal trade_Price;

	private String trade_Type;

	private int trade_Volume;

	public Trade() {
	}

	public int getOrder_ID() {
		return this.order_ID;
	}

	public void setOrder_ID(int order_ID) {
		this.order_ID = order_ID;
	}

	public String getBond_ID() {
		return this.bond_ID;
	}

	public void setBond_ID(String bond_ID) {
		this.bond_ID = bond_ID;
	}

	public BigDecimal getTrade_Amount() {
		return this.trade_Amount;
	}

	public void setTrade_Amount(BigDecimal trade_Amount) {
		this.trade_Amount = trade_Amount;
	}

	public String getTrade_Date() {
		return this.trade_Date;
	}

	public void setTrade_Date(String trade_Date) {
		this.trade_Date = trade_Date;
	}

	public BigDecimal getTrade_Price() {
		return this.trade_Price;
	}

	public void setTrade_Price(BigDecimal trade_Price) {
		this.trade_Price = trade_Price;
	}

	public String getTrade_Type() {
		return this.trade_Type;
	}

	public void setTrade_Type(String trade_Type) {
		this.trade_Type = trade_Type;
	}

	public int getTrade_Volume() {
		return this.trade_Volume;
	}

	public void setTrade_Volume(int trade_Volume) {
		this.trade_Volume = trade_Volume;
	}

}