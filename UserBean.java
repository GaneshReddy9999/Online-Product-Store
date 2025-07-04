package Userdao;

import java.io.Serializable;

public class UserBean implements Serializable {
		private String UserName;
		private String Password;
		private String fName;
		private String lName;
		private String Address;
		private long pNo;
		private String mid;
		
		public UserBean() {
		
		}
		public String getUserName() {
			return UserName;
		}
		public void setUserName(String userName) {
			UserName = userName;
		}
		public String getPassword() {
			return Password;
		}
		public void setPassword(String password) {
			Password = password;
		}
		public String getfName() {
			return fName;
		}
		public void setfName(String fName) {
			this.fName = fName;
		}
		public String getlName() {
			return lName;
		}
		public void setlName(String lName) {
			this.lName = lName;
		}
		public String getAddress() {
			return Address;
		}
		public void setAddress(String address) {
			Address = address;
		}
		
		
		public long getpNo() {
			return pNo;
		}
		public void setpNo(long pNo) {
			this.pNo = pNo;
		}
		public String getMid() {
			return mid;
		}
		public void setMid(String mid) {
			this.mid = mid;
		}
		

	}


