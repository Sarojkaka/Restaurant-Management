
public class Customer {
	private Integer cusId;
	private String cusFirstName;
	private String cusLastName;
	private Integer cusPhone;
	
	public Customer(Integer cusId, String cusFirstName, String cusLastName, Integer cusPhone) {
		super();
		this.cusId = cusId;
		this.cusFirstName = cusFirstName;
		this.cusLastName = cusLastName;
		this.cusPhone = cusPhone;
	}

	public Customer(String firstname, String lastname, Integer phone) {
		this.cusFirstName = firstname;
		this.cusLastName = lastname;
		this.cusPhone = phone;
	}

	public Customer(Integer custId) {
		this.cusId = custId;
	}

	public Integer getCusId() {
		return cusId;
	}

	public void setCusId(Integer cusId) {
		this.cusId = cusId;
	}

	public String getCusFirstName() {
		return cusFirstName;
	}

	public void setCusFirstName(String cusFirstName) {
		this.cusFirstName = cusFirstName;
	}

	public String getCusLastName() {
		return cusLastName;
	}

	public void setCusLastName(String cusLastName) {
		this.cusLastName = cusLastName;
	}

	public Integer getCusPhone() {
		return cusPhone;
	}

	public void setCusPhone(Integer cusPhone) {
		this.cusPhone = cusPhone;
	}
	

	@Override
	public String toString() {
		return "Customer [cusId=" + cusId + ", cusFirstName=" + cusFirstName + ", cusLastName=" + cusLastName
				+ ", cusPhone=" + cusPhone + "]";
	}
}

