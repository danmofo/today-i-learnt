package com.dmoffat.til.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

/**
 * A Thing can be anything, from a fun fact, to a life lesson.
 * 
 * @author danielmoffat
 *
 */
@Table(name = "thing")
@Entity
public class Thing implements Serializable {

	private static final long serialVersionUID = 2124605890978766184L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// Prevent this value from being included in the INSERT statement
	@Column(name = "added", insertable = false)
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime added;

	@NotEmpty
	private String text = "";

	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "thing_tag", joinColumns = @JoinColumn(name = "thing_id"), inverseJoinColumns = @JoinColumn(name = "tag_id"))
	private List<Tag> tags;

	public Thing() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DateTime getAdded() {
		return added;
	}

	public void setAdded(DateTime added) {
		this.added = added;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Thing [id=");
		builder.append(id);
		builder.append(", added=");
		builder.append(DateTimeFormat.forStyle("MM").print(added));
		builder.append(", text=");
		builder.append(text);
		builder.append(", tags=");
		builder.append(tags != null ? tags : "none");
		builder.append("]");
		return builder.toString();
	}

}
