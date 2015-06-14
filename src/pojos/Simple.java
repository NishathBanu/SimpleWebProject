package pojos;

import java.io.Serializable;

public class Simple implements Serializable {
	
	private Integer id;
	private String message;
	private String firstName;
	private String lastName;
	private String instId;
	private String dob;
	private String sessEx;
	
	
	public String getSessEx() {
		return sessEx;
	}

	public void setSessEx(String sessEx) {
		this.sessEx = sessEx;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Simple() {
		// TODO Auto-generated constructor stub
		super();
	}

	public Simple(Integer id, String message) {
		super();
		this.id = id;
		this.message = message;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getInstId() {
		return instId;
	}

	public void setInstId(String instId) {
		this.instId = instId;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

}
