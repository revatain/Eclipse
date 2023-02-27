package study;

public class ManagerDTO {
	private String manager_id;
	private String manager_pw;
	private String manager_name;
	private String manager_tel;
	private String manager_email;
	
	//생성자 오버로딩
	ManagerDTO(String manager_id, String manager_pw, String manager_name, String manager_tel, String manager_email)
	{
		this.manager_id=manager_id;
		this.manager_pw=manager_pw;
		this.manager_name=manager_name;
		this.manager_tel=manager_tel;
		this.manager_email=manager_email;
	}
		
	
	
	public String getManager_id() {
		return manager_id;
	}
	public void setManager_id(String manager_id) {
		this.manager_id = manager_id;
	}
	public String getManager_pw() {
		return manager_pw;
	}
	public void setManager_pw(String manager_pw) {
		this.manager_pw = manager_pw;
	}
	public String getManager_name() {
		return manager_name;
	}
	public void setManager_name(String manager_name) {
		this.manager_name = manager_name;
	}
	public String getManager_tel() {
		return manager_tel;
	}
	public void setManager_tel(String manager_tel) {
		this.manager_tel = manager_tel;
	}
	public String getManager_email() {
		return manager_email;
	}
	public void setManager_email(String manager_email) {
		this.manager_email = manager_email;
	}
	
	
	
	

}
