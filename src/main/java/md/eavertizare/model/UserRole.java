package md.eavertizare.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_roles")
public class UserRole {

	@Id
	@GeneratedValue//(strategy = GenerationType.IDENTITY)
	@Column(name = "user_role_id")
	private int id;

	@Column(name = "username")
	private String username;

	@Column(name = "role")
	private String role;

	public UserRole() {
	}

	public UserRole(String username, String role) {
		super();
		this.username = username;
		this.role = role;
	}

	public UserRole(int id, String username, String role) {
		super();
		this.id = id;
		this.username = username;
		this.role = role;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserRole [id=" + id + ", username=" + username + ", role=" + role + "]";
	}

}
