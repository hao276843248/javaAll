package cn.hao.reserve.entity;

import java.sql.Timestamp;
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
 * Reserve entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "reserve", catalog = "reserve")
public class Reserve implements java.io.Serializable {

	// Fields

	private Integer id;
	private Room room;
	private Timestamp reserveDate;
	private Integer beginTime;
	private Integer endTime;
	private String name;

	// Constructors

	/** default constructor */
	public Reserve() {
	}

	/** full constructor */
	public Reserve(Room room, Timestamp reserveDate, Integer beginTime,
			Integer endTime, String name) {
		this.room = room;
		this.reserveDate = reserveDate;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.name = name;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "roomId", nullable = false)
	public Room getRoom() {
		return this.room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	@Column(name = "reserveDate", nullable = false, length = 19)
	public Timestamp getReserveDate() {
		return this.reserveDate;
	}

	public void setReserveDate(Timestamp reserveDate) {
		this.reserveDate = reserveDate;
	}

	@Column(name = "beginTime", nullable = false)
	public Integer getBeginTime() {
		return this.beginTime;
	}

	public void setBeginTime(Integer beginTime) {
		this.beginTime = beginTime;
	}

	@Column(name = "endTime", nullable = false)
	public Integer getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Integer endTime) {
		this.endTime = endTime;
	}

	@Column(name = "name", nullable = false, length = 20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}