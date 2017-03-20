package cn.bdqn.student.entity;

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
 * Education entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "education", catalog = "student")
public class Education implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Set<Student> students = new HashSet<Student>(0);

	// Constructors

	/** default constructor */
	public Education() {
	}

	/** minimal constructor */
	public Education(String name) {
		this.name = name;
	}

	/** full constructor */
	public Education(String name, Set<Student> students) {
		this.name = name;
		this.students = students;
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

	@Column(name = "name", nullable = false, length = 20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "education")
	public Set<Student> getStudents() {
		return this.students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

}