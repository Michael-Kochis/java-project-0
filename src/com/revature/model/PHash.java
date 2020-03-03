package com.revature.model;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PHash {
	private String pwHash;
	
	public PHash() {
		super();
		this.pwHash = new String();
	}
	
	public PHash(String s) {
		this();
		this.setHash(s); 
	}
	
	/** Only for use when loading values from persistent storage. */
	private void setHash(String s) {
		this.pwHash = s;
	}
	
	public boolean checkPassword(String s) {
		return (passwordEncoder().matches(s, this.pwHash));
	}
	
	public void setPassword(String s) {
		String bcrypt = null;
		
		bcrypt = passwordEncoder().encode(s);
		setHash(bcrypt); 
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}	@Override
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pwHash == null) ? 0 : pwHash.hashCode());
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
		PHash other = (PHash) obj;
		if (pwHash == null) {
			if (other.pwHash != null)
				return false;
		} else if (!pwHash.equals(other.pwHash))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PHash [salt, pwHash= Nope, you don't ever get to see the salt or hash values.]";
	}
}
