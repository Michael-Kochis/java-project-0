package com.revature.model;

public class Address implements Comparable {
	long bankUID;
	String street1;
	String street2;
	String city;
	String state;
	long   zip;

	public Address() {
		super();
	}

	public Address(long bankUID, String street1, String city, String state, long zip) {
		super();
		this.bankUID = bankUID;
		this.street1 = street1;
		this.street2 = "";
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	public Address(long bankUID, String street1, String street2, String city, String state, long zip) {
		super();
		this.bankUID = bankUID;
		this.street1 = street1;
		this.street2 = street2;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	public long getBankUID() {
		return bankUID;
	}

	public void setBankUID(long bankUID) {
		this.bankUID = bankUID;
	}

	public String getStreet1() {
		return street1;
	}

	public void setStreet1(String street1) {
		this.street1 = street1;
	}

	public String getStreet2() {
		return street2;
	}

	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public long getZip() {
		return zip;
	}

	public void setZip(long zip) {
		this.zip = zip;
	}

	@Override
	public int compareTo(Object o) {
		Address other = ((Address) o);
		if (this.zip == other.zip) {
			if (this.state.equalsIgnoreCase(other.state)) {
				if (this.city.equalsIgnoreCase(other.city)) {
					if (this.street1.equalsIgnoreCase(other.street1)) {
						return this.street2.compareToIgnoreCase(other.street2);
					} else {
						return this.street1.compareToIgnoreCase(other.street1);
					}
				} else {
					return this.city.compareTo(other.city);
				}
			} else {
				return this.state.compareTo(other.state);
			}
		} else {
			return (int)(this.zip - other.zip);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((street1 == null) ? 0 : street1.hashCode());
		result = prime * result + ((street2 == null) ? 0 : street2.hashCode());
		result = prime * result + (int) (zip ^ (zip >>> 32));
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
		Address other = (Address) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (street1 == null) {
			if (other.street1 != null)
				return false;
		} else if (!street1.equals(other.street1))
			return false;
		if (street2 == null) {
			if (other.street2 != null)
				return false;
		} else if (!street2.equals(other.street2))
			return false;
		if (zip != other.zip)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Address [street1=" + street1 + ", street2=" + street2 + ", city=" + city + ", state=" + state + ", zip="
				+ zip + "]";
	}

}
