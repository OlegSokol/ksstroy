package ua.ksstroy.hibermodel;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "groups", catalog = "ksstroy")
public class GroupsModel implements Serializable{

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	@Column(name = "name", nullable = false)
	private String name;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "zones")
	private List<ZoneModel> setZoneMod = new ArrayList<ZoneModel>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ZoneModel> getSetZoneMod() {
		return setZoneMod;
	}

	public void setSetZoneMod(List<ZoneModel> setZoneMod) {
		this.setZoneMod = setZoneMod;
	}

}