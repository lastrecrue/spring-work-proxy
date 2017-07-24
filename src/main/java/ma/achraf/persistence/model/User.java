package ma.achraf.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	public User() {

	}

	public User(String name) {
		this.name = name;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Long id;

	@Column
	private String name;

}
