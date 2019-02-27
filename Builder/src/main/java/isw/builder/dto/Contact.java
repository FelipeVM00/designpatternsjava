package isw.builder.dto;

import isw.builder.IBuilder;

public class Contact {
	private String name;
    private Phone phone;
    private Address address;

    public Contact() {
    }

    public Contact(String name, Phone phone,Address address) {
        this.name = name;
        this.phone = phone;
    }
    
    public Contact(String name, Phone phone) {
        this.name = name;
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Contact{" + "name=" + name + ", phone=" + phone + '}';
    }
    
    public static class ContactBuilder implements IBuilder<Contact>{
    	private String name;
        private Phone phone;
        private Address adress;

        public ContactBuilder() {
        }
        
        public ContactBuilder setName(String name) {
        	this.name = name;
        	return this;
        }
        
        public ContactBuilder setPhone(String phoneNumber, String ext, String phoneType) {
        	this.phone = new Phone(phoneNumber, ext, phoneType);
        	return this;
        }
        
        public ContactBuilder setAddress(String address, String city, String country, String cp) {
        	adress = new Address(address, city, country, cp);
        	return this;
        }
        
        @Override
        public Contact build() {
        	return new Contact(name, phone, adress);
        }
    }
    
}
