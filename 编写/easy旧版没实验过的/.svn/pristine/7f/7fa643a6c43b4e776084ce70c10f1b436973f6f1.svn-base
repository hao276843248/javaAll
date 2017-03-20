package cn.hao.easybuy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * EasybuyOrderDetail entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "easybuy_order_detail", catalog = "easy")
public class EasybuyOrderDetail implements java.io.Serializable {

	// Fields

	private Integer eodId;
	private EasybuyProduct easybuyProduct;
	private EasybuyOrder easybuyOrder;
	private Integer eodQuantity;
	private Double eodCost;

	// Constructors

	/** default constructor */
	public EasybuyOrderDetail() {
	}

	/** full constructor */
	public EasybuyOrderDetail(EasybuyProduct easybuyProduct,
			EasybuyOrder easybuyOrder, Integer eodQuantity, Double eodCost) {
		this.easybuyProduct = easybuyProduct;
		this.easybuyOrder = easybuyOrder;
		this.eodQuantity = eodQuantity;
		this.eodCost = eodCost;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "EOD_ID", unique = true, nullable = false)
	public Integer getEodId() {
		return this.eodId;
	}

	public void setEodId(Integer eodId) {
		this.eodId = eodId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EP_ID", nullable = false)
	public EasybuyProduct getEasybuyProduct() {
		return this.easybuyProduct;
	}

	public void setEasybuyProduct(EasybuyProduct easybuyProduct) {
		this.easybuyProduct = easybuyProduct;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EO_ID", nullable = false)
	public EasybuyOrder getEasybuyOrder() {
		return this.easybuyOrder;
	}

	public void setEasybuyOrder(EasybuyOrder easybuyOrder) {
		this.easybuyOrder = easybuyOrder;
	}

	@Column(name = "EOD_QUANTITY", nullable = false)
	public Integer getEodQuantity() {
		return this.eodQuantity;
	}

	public void setEodQuantity(Integer eodQuantity) {
		this.eodQuantity = eodQuantity;
	}

	@Column(name = "EOD_COST", nullable = false, precision = 10)
	public Double getEodCost() {
		return this.eodCost;
	}

	public void setEodCost(Double eodCost) {
		this.eodCost = eodCost;
	}

}