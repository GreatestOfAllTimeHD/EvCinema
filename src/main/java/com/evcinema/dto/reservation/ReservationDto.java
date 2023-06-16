package com.evcinema.dto.reservation;

import lombok.Data;

//@Getter @Setter @ToString
//@AllArgsConstructor @NoArgsConstructor

@Data //getter setter tostring 합친것
public class ReservationDto {
	String siteNumber;
	String customerNumber;
	String bulidingNumber;
	String addField;
	
	String orderIdx;
	String ecsIdx;
	String mSerialNumber;
	String id;
	String uuId;
	String siteId;
	String paymentId;
	
	/*
	 * public ReservationDto(String roomNumber, String customerNumber) {
	 * this.roomNumber = roomNumber; this.customerNumber = customerNumber;
	 * this.bulidingNumber = bulidingNumber; }
	 * 
	 * public String getBulidingNumber() { return bulidingNumber; } public void
	 * setBulidingNumber(String bulidingNumber) { this.bulidingNumber =
	 * bulidingNumber; } public String getRoomNumber() { return roomNumber; } public
	 * void setRoomNumber(String roomNumber) { this.roomNumber = roomNumber; }
	 * public String getCustomerNumber() { return customerNumber; } public void
	 * setCustomerNumber(String customerNumber) { this.customerNumber =
	 * customerNumber; }
	 * 
	 * @Override public String toString() { return "ReservationDto [roomNumber=" +
	 * roomNumber + ", customerNumber=" + customerNumber + "]"; }
	 */
	
}
