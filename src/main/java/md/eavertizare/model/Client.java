package md.eavertizare.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "clients")
public class Client {

	@Id
	@GeneratedValue // (strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "firstName")
	private String firstName;

	@Column(name = "lastName")
	private String lastName;

	@Column(name = "phoneNumber")
	private int phoneNumber;

	@Column(name = "email")
	private String email;

	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(name = "expirationDate")
	private Date expirationDate;

	@Column(name = "message")
	private String message;

	@Column(name = "isSent")
	private boolean sent;

	// @ManyToOne(cascade=CascadeType.ALL)
	@ManyToOne()
	@JoinColumn(name = "idCompany")
	private Company company;

	public Client() {

	}

	public Client(int id, String firstName, String lastName, int phoneNumber, String email, Date expirationDate,
			String message, boolean isSent) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.expirationDate = expirationDate;
		this.message = message;
		this.sent = isSent;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSent() {
		return sent;
	}

	public void setSent(boolean isSent) {
		this.sent = isSent;
	}

	public String forDropDownMenu() {
		return "" + firstName + " " + lastName + "";
	}

	@Override
	public String toString() {
		DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
		// return "Client [id=" + id + ", firstName=" + firstName + ",
		// lastName=" + lastName + ", phoneNumber="
		// + phoneNumber + ", email=" + email + ", expirationDate=" +
		// expirationDate + ", message=" + message
		// + ", sent=" + sent + "]";
		//
		return "" + firstName + "  " + lastName + "  " + phoneNumber + "  " + email + "  " 
		+ df1.format(expirationDate) + "";

	}

}
