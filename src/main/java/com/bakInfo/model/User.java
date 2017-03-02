package com.bakInfo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.domain.Persistable;

@Entity
@Table(name="user")
public class User  	implements Persistable<String>, Serializable {
	private static final long serialVersionUID = 1L;


	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="user_email")
	private String userEmail;

	@Column(name="user_enabled")
	private Boolean userEnabled;

	@Column(name="user_password")
	private String userPassword;
	
	@Column(name="admin_enabled")
	private boolean adminEnabled;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public User(String userEmail, Boolean userEnabled, String userPassword, boolean adminEnabled) {
		super();
		this.userEmail = userEmail;
		this.userEnabled = userEnabled;
		this.userPassword = userPassword;
		this.adminEnabled = adminEnabled;
	}


	public User(Long id, String userEmail, Boolean userEnabled, String userPassword, boolean adminEnabled) {
		super();
		this.id = id;
		this.userEmail = userEmail;
		this.userEnabled = userEnabled;
		this.userPassword = userPassword;
		this.adminEnabled = adminEnabled;
	}




	@Override
	public String getId() {
		return String.valueOf(id);
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getUserEmail() {
		return this.userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Boolean getUserEnabled() {
		return this.userEnabled;
	}

	public void setUserEnabled(Boolean userEnabled) {
		this.userEnabled = userEnabled;
	}

	

	public String getUserPassword() {
	    return this.userPassword;
	}
	
	public void setUserPassword(String userPassword) {
	    this.userPassword = userPassword;
	}



	public boolean getAdminEnabled() {
		return adminEnabled;
	}



	public void setAdminEnabled(boolean adminEnabled) {
		this.adminEnabled = adminEnabled;
	}



	@Override
	public boolean isNew() {
		return id==null;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (adminEnabled ? 1231 : 1237);
		result = prime * result + ((userEmail == null) ? 0 : userEmail.hashCode());
		result = prime * result + ((userEnabled == null) ? 0 : userEnabled.hashCode());
		result = prime * result + ((userPassword == null) ? 0 : userPassword.hashCode());
		return result;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (adminEnabled != other.adminEnabled)
			return false;
		if (userEmail == null) {
			if (other.userEmail != null)
				return false;
		} else if (!userEmail.equals(other.userEmail))
			return false;
		if (userEnabled == null) {
			if (other.userEnabled != null)
				return false;
		} else if (!userEnabled.equals(other.userEnabled))
			return false;
		if (userPassword == null) {
			if (other.userPassword != null)
				return false;
		} else if (!userPassword.equals(other.userPassword))
			return false;
		return true;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("User [userEmail=%s, userEnabled=%s, userPassword=%s, adminEnabled=%s]", userEmail,
				userEnabled, userPassword, adminEnabled);
	}


	
}