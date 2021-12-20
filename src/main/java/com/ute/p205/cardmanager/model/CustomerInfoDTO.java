package com.ute.p205.cardmanager.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CustomerInfoDTO {
      private String firstName;
      private String lastName;
      private String address;
      private String passPortOrID;
      private String valiDate;
      private String expiryDate;
      private String phoneNumber;
      private String email;
     
     public CustomerInfoDTO (CustomerInfo customerInfo){
          firstName = customerInfo.getFirstName();
          lastName = customerInfo.getLastName();
          address = customerInfo.getAddress();
          passPortOrID = customerInfo.getPassPortOrID();
          valiDate = customerInfo.getValiDate();
          expiryDate = customerInfo.getExpiryDate();
          phoneNumber = customerInfo.getPhoneNumber();
          email = customerInfo.getEmail();
     }

    @Override
    public String toString() {
        return "CustomerInfoDTO{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", passPortOrID='" + passPortOrID + '\'' +
                ", valiDate='" + valiDate + '\'' +
                ", expiryDate='" + expiryDate + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
