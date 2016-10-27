package com.dmoffat.til.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * A Thing can be anything, from a fun fact, to a life lesson.
 * 
 * @author danielmoffat
 *
 */
@Table(name = "thing")
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Thing implements Serializable {

	private static final long serialVersionUID = 2124605890978766184L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// Prevent this value from being included in the INSERT statement
	@Column(name = "added", insertable = false)
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime added;
	
	@Column(name="updated")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@LastModifiedDate
	private DateTime updated;

	@NotEmpty
	private String text = "";

	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name = "thing_tag", joinColumns = @JoinColumn(name = "thing_id"), inverseJoinColumns = @JoinColumn(name = "tag_id"))
	private List<Tag> tags;

	public Thing() {

	}
//	
//	
//	@PreUpdate
//	private void onUpdate() {
//		System.out.println("Pre update!");
//		updated = DateTime.now();
//	}

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
	
	public DateTime getUpdated() {
		return updated;
	}

	public void setUpdated(DateTime updated) {
		this.updated = updated;
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
		builder.append(", updated=");
		builder.append(DateTimeFormat.forStyle("MM").print(updated));
		builder.append(", text=");
		builder.append(text);
		builder.append("]");
		return builder.toString();
	}

}
