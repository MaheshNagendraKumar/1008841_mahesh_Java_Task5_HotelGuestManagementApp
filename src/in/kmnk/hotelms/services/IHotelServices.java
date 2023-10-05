package in.kmnk.hotelms.services;

import in.kmnk.hotelms.domain.Guest;
import in.kmnk.hotelms.domain.Room;

public interface IHotelServices {

	public Guest findGuestCheckedInRoom(int roomId);

	public int guestsCount();

	// add prices of rooms where guest is staying
	public double earningToday();

	public Guest[] findAllGuests();
	
	public Room[] findAllRooms();

	public void addGuests(Guest guest);

	public void addRooms(Room room);

	public Guest getGuestById(long gid);

	public void updateRoomCheckedIn(int roomId, long gid);

}
