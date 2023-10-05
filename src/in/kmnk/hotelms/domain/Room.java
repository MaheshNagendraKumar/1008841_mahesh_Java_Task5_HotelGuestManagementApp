package in.kmnk.hotelms.domain;

public class Room {
	private int roomNumber;
	private int floor;
	private Guest checkedIn;
	private String roomType; // deluxe or normal
	private Double pricePerDay;

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public Guest getCheckedIn() {
		return checkedIn;
	}

	public void setCheckedIn(Guest checkedIn) {
		this.checkedIn = checkedIn;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public Double getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(Double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	@Override
	public String toString() {
		return "Hotel [roomNumber=" + roomNumber + ", floor=" + floor + ", checkedIn=" + checkedIn + ", roomType="
				+ roomType + ", pricePerDay=" + pricePerDay + "]";
	}

}
