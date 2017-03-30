package com.Springs.Website.Model;

public class UsersInfo {

	private String Firstname;
	private String Lastname;
	private String Email;
	private String Username;
	private String Password;
	private long Phonenumber;
	private String Maidenname;
	public String Uname;
	private static UsersInfo usersinfo = null;

	private UsersInfo() {

	}

	public static UsersInfo getinstance() {

		if (usersinfo == null) {
			usersinfo = new UsersInfo();
		}
		return usersinfo;
	}

	@Override
	public String toString() {
		return "UsersInfo [Firstname=" + Firstname + ", Lastname=" + Lastname + ", Email=" + Email + ", Username="
				+ Username + ", Password=" + Password + ", Phonenumber=" + Phonenumber + ", Maidenname=" + Maidenname
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Email == null) ? 0 : Email.hashCode());
		result = prime * result + ((Firstname == null) ? 0 : Firstname.hashCode());
		result = prime * result + ((Lastname == null) ? 0 : Lastname.hashCode());
		result = prime * result + ((Maidenname == null) ? 0 : Maidenname.hashCode());
		result = prime * result + ((Password == null) ? 0 : Password.hashCode());
		result = prime * result + (int) (Phonenumber ^ (Phonenumber >>> 32));
		result = prime * result + ((Username == null) ? 0 : Username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsersInfo other = (UsersInfo) obj;
		if (Email == null) {
			if (other.Email != null)
				return false;
		} else if (!Email.equals(other.Email))
			return false;
		if (Firstname == null) {
			if (other.Firstname != null)
				return false;
		} else if (!Firstname.equals(other.Firstname))
			return false;
		if (Lastname == null) {
			if (other.Lastname != null)
				return false;
		} else if (!Lastname.equals(other.Lastname))
			return false;
		if (Maidenname == null) {
			if (other.Maidenname != null)
				return false;
		} else if (!Maidenname.equals(other.Maidenname))
			return false;
		if (Password == null) {
			if (other.Password != null)
				return false;
		} else if (!Password.equals(other.Password))
			return false;
		if (Phonenumber != other.Phonenumber)
			return false;
		if (Username == null) {
			if (other.Username != null)
				return false;
		} else if (!Username.equals(other.Username))
			return false;
		return true;
	}

	public String getFirstname() {
		return Firstname;
	}

	public void setFirstname(String firstname) {
		Firstname = firstname;
	}

	public String getLastname() {
		return Lastname;
	}

	public void setLastname(String lastname) {
		Lastname = lastname;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
		Uname = username;
	}

	public String getUname() {
		return Uname;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public long getPhonenumber() {
		return Phonenumber;
	}

	public void setPhonenumber(long phonenumber) {
		Phonenumber = phonenumber;
	}

	public String getMaidenname() {
		return Maidenname;
	}

	public void setMaidenname(String maidenname) {
		Maidenname = maidenname;
	}

}