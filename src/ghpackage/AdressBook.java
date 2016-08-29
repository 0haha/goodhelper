package ghpackage;

public class AdressBook {
	  private String  usrId;
	  private Integer AdressBookId;
	  private Integer communityId;
	  private String  name;
	  private String  studentId;
	  private String  PhoneNumber;
	  private String  email;
	  private String  qq;
	  private String  adress;
	  private String  weixin;
	  private int   menber_list_order;
	  public AdressBook(){
		  
	  }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsrId() {
		return usrId;
	}

	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}

	public Integer getAdressBookId() {
		return AdressBookId;
	}
	public void setAdressBookId(Integer adressBookId) {
		AdressBookId = adressBookId;
	}
	public Integer getCommunityId() {
		return communityId;
	}
	public void setCommunityId(Integer communityId) {
		this.communityId = communityId;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getWeixin() {
		return weixin;
	}
	public void setWeixin(String weixin) {
		this.weixin = weixin;
	}

	public int getMenber_list_order() {
		return menber_list_order;
	}

	public void setMenber_list_order(int menber_list_order) {
		this.menber_list_order = menber_list_order;
	}
	  
	}
