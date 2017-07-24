package ma.achraf.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	public User(String name) {
		this.name = name;
	}

	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String name;

}
