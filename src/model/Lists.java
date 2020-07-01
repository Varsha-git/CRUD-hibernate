package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Lists")
public class Lists {
	@Id
	@Column(name = "LISTID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_list")
	@SequenceGenerator(name = "seq_list", sequenceName = "seq_list", allocationSize = 1, initialValue = 1)
	private int listId;
	@Column(name = "LISTTYPE")
	private String listType;
	@Column(name = "LISTDESCRIPTION")
	private String listDescription;

	public int getListId() {
		return listId;
	}

	public void setListId(int listid2) {
		this.listId = listid2;
	}

	public String getListType() {
		return listType;
	}

	public void setListType(String listType) {
		this.listType = listType;
	}

	public String getListDescription() {
		return listDescription;
	}

	public void setListDescription(String listDescription) {
		this.listDescription = listDescription;
	}
}