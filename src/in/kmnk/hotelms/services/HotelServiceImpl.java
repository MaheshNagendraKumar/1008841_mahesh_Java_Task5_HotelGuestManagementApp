package in.kmnk.hotelms.services;

import in.kmnk.hotelms.domain.Guest;
import in.kmnk.hotelms.domain.Hotel;
import in.kmnk.hotelms.domain.Room;

public class HotelServiceImpl implements IHotelServices {
	
	
	Guest[] guests;
	Room[] rooms;
	Hotel[] hotel;

	int guests_count;
	int rooms_count;
	int hotel_count;

	
	public HotelServiceImpl(Guest[] guests, Room[] rooms, Hotel[] hotel, int guests_count, int rooms_count,
			int hotel_count) {
		this.guests = guests;
		this.rooms = rooms;
		this.hotel = hotel;
		this.guests_count = guests_count;
		this.rooms_count = rooms_count;
		this.hotel_count = hotel_count;
	}

	public Guest findGuestCheckedInRoom(int roomId) {

		for (Room room : rooms) {
			if (room.getRoomNumber() == roomId) {
				if (room.getCheckedIn() != null) {
					return room.getCheckedIn();
				}
			}
		}
		return null;
	}

	public int guestsCount() {
		int length = 0;
		for (Guest guest : guests) {
			if (guest != null) {
				length++;
			}
		}
		return length;
	}

	// add prices of rooms where guest is staying
	public double earningToday() {
		double totalEarnings = 0;
		for (Room room : rooms) {
			if (room.getCheckedIn() != null) {
				totalEarnings += room.getPricePerDay();
			}
		}
		return totalEarnings;
	}

	public Guest[] findAllGuests() {
		return guests;
	}
	
	public Room[] findAllRooms() {
		return rooms;
	}

	public void addGuests(Guest guest) {
		guests[guests_count] = guest;
		System.out.println("Guest added successfully");
		guests_count++;
	}

	public void addRooms(Room room) {
		rooms[rooms_count] = room;
		System.out.println("Room details added successfully");
		rooms_count++;
	}

	public Guest getGuestById(long gid) {
		for (Guest guest : guests) {
			if (guest != null) {
				if (guest.getGid() == gid) {
					return guest;
				}
			}
		}
		return null;
	}

	public void updateRoomCheckedIn(int roomId, long gid) {
		Guest guest = getGuestById(gid);
		for (Room room : rooms) {
			if (room.getRoomNumber() == roomId && guest != null) {
				if (room.getCheckedIn() == null) {
					System.out.println("Before guest not alloted to room");
					System.out.println(room);
					room.setCheckedIn(guest);
					System.out.println("After guest alloted room");
					System.out.println(room);
				}
			}
		}
	}


}
