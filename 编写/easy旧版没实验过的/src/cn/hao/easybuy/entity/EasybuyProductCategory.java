package cn.hao.easybuy.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * EasybuyProductCategory entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "easybuy_product_category", catalog = "easy")
public class EasybuyProductCategory implements java.io.Serializable {

	// Fields

	private Integer epcId;
	private String epcName;
	private Integer epcParentId;
	private Set<EasybuyProduct> easybuyProducts = new HashSet<EasybuyProduct>(0);

	// Constructors

	/** default constructor */
	public EasybuyProductCategory() {
	}

	/** minimal constructor */
	public EasybuyProductCategory(String epcName, Integer epcParentId) {
		this.epcName = epcName;
		this.epcParentId = epcParentId;
	}

	/** full constructor */
	public EasybuyProductCategory(String epcName, Integer epcParentId,
			Set<EasybuyProduct> easybuyProducts) {
		this.epcName = epcName;
		this.epcParentId = epcParentId;
		this.easybuyProducts = easybuyProducts;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "EPC_ID", unique = true, nullable = false)
	public Integer getEpcId() {
		return this.epcId;
	}

	public void setEpcId(Integer epcId) {
		this.epcId = epcId;
	}

	@Column(name = "EPC_NAME", nullable = false, length = 20)
	public String getEpcName() {
		return this.epcName;
	}

	public void setEpcName(String epcName) {
		this.epcName = epcName;
	}

	@Column(name = "EPC_PARENT_ID", nullable = false)
	public Integer getEpcParentId() {
		return this.epcParentId;
	}

	public void setEpcParentId(Integer epcParentId) {
		this.epcParentId = epcParentId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "easybuyProductCategory")
	public Set<EasybuyProduct> getEasybuyProducts() {
		return this.easybuyProducts;
	}

	public void setEasybuyProducts(Set<EasybuyProduct> easybuyProducts) {
		this.easybuyProducts = easybuyProducts;
	}

}