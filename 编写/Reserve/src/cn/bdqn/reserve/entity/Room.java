package cn.bdqn.reserve.entity;

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
 * Room entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "room", catalog = "reserve")
public class Room implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Set<Reserve> reserves = new HashSet<Reserve>(0);

	// Constructors

	/** default constructor */
	public Room() {
	}

	/** minimal constructor */
	public Room(String name) {
		this.name = name;
	}

	/** full constructor */
	public Room(String name, Set<Reserve> reserves) {
		this.name = name;
		this.reserves = reserves;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name", nullable = false, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "room")
	public Set<Reserve> getReserves() {
		return this.reserves;
	}

	public void setReserves(Set<Reserve> reserves) {
		this.reserves = reserves;
	}

}