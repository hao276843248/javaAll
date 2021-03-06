package cn.hao.easybuy.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * EasybuyProduct entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "easybuy_product", catalog = "easy")
public class EasybuyProduct implements java.io.Serializable {

	// Fields

	private Integer epId;
	private EasybuyProductCategory easybuyProductCategory;
	private String epName;
	private String epDescription;
	private Double epPrice;
	private Integer epStock;
	private Integer epcChildId;
	private String epFileName;
	private Set<EasybuyOrderDetail> easybuyOrderDetails = new HashSet<EasybuyOrderDetail>(
			0);

	// Constructors

	/** default constructor */
	public EasybuyProduct() {
	}

	/** minimal constructor */
	public EasybuyProduct(String epName, Double epPrice, Integer epStock) {
		this.epName = epName;
		this.epPrice = epPrice;
		this.epStock = epStock;
	}

	/** full constructor */
	public EasybuyProduct(EasybuyProductCategory easybuyProductCategory,
			String epName, String epDescription, Double epPrice,
			Integer epStock, Integer epcChildId, String epFileName,
			Set<EasybuyOrderDetail> easybuyOrderDetails) {
		this.easybuyProductCategory = easybuyProductCategory;
		this.epName = epName;
		this.epDescription = epDescription;
		this.epPrice = epPrice;
		this.epStock = epStock;
		this.epcChildId = epcChildId;
		this.epFileName = epFileName;
		this.easybuyOrderDetails = easybuyOrderDetails;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "EP_ID", unique = true, nullable = false)
	public Integer getEpId() {
		return this.epId;
	}

	public void setEpId(Integer epId) {
		this.epId = epId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "EPC_ID")
	public EasybuyProductCategory getEasybuyProductCategory() {
		return this.easybuyProductCategory;
	}

	public void setEasybuyProductCategory(
			EasybuyProductCategory easybuyProductCategory) {
		this.easybuyProductCategory = easybuyProductCategory;
	}

	@Column(name = "EP_NAME", nullable = false, length = 20)
	public String getEpName() {
		return this.epName;
	}

	public void setEpName(String epName) {
		this.epName = epName;
	}

	@Column(name = "EP_DESCRIPTION", length = 100)
	public String getEpDescription() {
		return this.epDescription;
	}

	public void setEpDescription(String epDescription) {
		this.epDescription = epDescription;
	}

	@Column(name = "EP_PRICE", nullable = false, precision = 10)
	public Double getEpPrice() {
		return this.epPrice;
	}

	public void setEpPrice(Double epPrice) {
		this.epPrice = epPrice;
	}

	@Column(name = "EP_STOCK", nullable = false)
	public Integer getEpStock() {
		return this.epStock;
	}

	public void setEpStock(Integer epStock) {
		this.epStock = epStock;
	}

	@Column(name = "EPC_CHILD_ID")
	public Integer getEpcChildId() {
		return this.epcChildId;
	}

	public void setEpcChildId(Integer epcChildId) {
		this.epcChildId = epcChildId;
	}

	@Column(name = "EP_FILE_NAME", length = 200)
	public String getEpFileName() {
		return this.epFileName;
	}

	public void setEpFileName(String epFileName) {
		this.epFileName = epFileName;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "easybuyProduct")
	public Set<EasybuyOrderDetail> getEasybuyOrderDetails() {
		return this.easybuyOrderDetails;
	}

	public void setEasybuyOrderDetails(
			Set<EasybuyOrderDetail> easybuyOrderDetails) {
		this.easybuyOrderDetails = easybuyOrderDetails;
	}

}