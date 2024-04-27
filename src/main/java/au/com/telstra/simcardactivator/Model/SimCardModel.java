package au.com.telstra.simcardactivator.Model;

public class SimCardModel {

	private String iccid;
	
	private String customerEmail;

	public SimCardModel() {}
	
	public SimCardModel(String iccid, String customerEmail) {
		super();
		this.iccid = iccid;
		this.customerEmail = customerEmail;
	}
	
	
	public String getIccid() {
		return iccid;
	}

	public void setIccid(String iccid) {
		this.iccid = iccid;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	@Override
	public String toString() {
		return "SimCardModel [iccid=" + iccid + ", customerEmail=" + customerEmail + "]";
	}

	
	
}
