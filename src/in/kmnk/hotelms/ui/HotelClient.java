package in.kmnk.hotelms.ui;

import java.util.Scanner;

import in.kmnk.hotelms.domain.Guest;
import in.kmnk.hotelms.domain.Hotel;
import in.kmnk.hotelms.domain.Room;
import in.kmnk.hotelms.services.HotelServiceImpl;
import in.kmnk.hotelms.services.IHotelServices;


public class HotelClient {

	Guest[] guests = new Guest[20];
	Room[] rooms = new Room[20];
	Hotel[] hotel = new Hotel[5];

	int guests_count = 0;
	int rooms_count = 0;
	int hotel_count = 0;

	IHotelServices service = new HotelServiceImpl(guests, rooms, hotel, guests_count, rooms_count, hotel_count);

	public static void main(String[] args) {
		
		
		HotelClient hotelClient = new HotelClient();

		Scanner sc = new Scanner(System.in);

		int option = 0;


		while (option != 8) {
			System.out.println("1) addRooms\n" 
					+ "2) addGuests\n" 
					+ "3) earningToday\n" 
					+ "4) findAllGuests\n"
					+ "5) findGuestCheckedInRoom\n"
					+ "6) guestsCount\n"
					+ "7) updateRoomCheckedIn\n"
					+ "8) Exit\n");

			option = sc.nextInt();

			switch (option) {
			case 1:
				
				System.out.println("Enter room number");
				int roomId = sc.nextInt();
				System.out.println("Enter floor number");
				int floorId = sc.nextInt();
				System.out.println("Enter room type deluxe or normar");
				String roomtype = sc.next();
				System.out.println("Enter price per day for that room");
				double pricePerDay = sc.nextDouble();

				Room room = new Room();
				room.setRoomNumber(roomId);
				room.setFloor(floorId);
				room.setRoomType(roomtype);
				room.setPricePerDay(pricePerDay);
				room.setCheckedIn(null);

				hotelClient.service.addRooms(room);
				
				break;

			case 2:
				
				System.out.println("Enter guest id");
				long gid = sc.nextLong();
				System.out.println("Enter guest first name");
				String gfirstname = sc.next();
				System.out.println("Enter guest last name");
				String glastname = sc.next();
				System.out.println("Enter guest email id");
				String gemailId = sc.next();

				Guest guest = new Guest();
				guest.setGid(gid);
				guest.setGfirstName(gfirstname);
				guest.setGlastName(glastname);
				guest.setGemailId(gemailId);

				hotelClient.service.addGuests(guest);
				
				break;				

			case 3:
				double earningToday = hotelClient.service.earningToday();
				System.out.println("Total ernings today: " + earningToday);
				break;

			case 4:
				Guest[] findAllGuests = hotelClient.service.findAllGuests();
				boolean flag = true;
				for (Guest guestFind : findAllGuests) {
					if (guestFind != null) {
						System.out.println(guestFind);
						flag = false;
					}
				}
				if (flag) {
					System.out.println("Present no guest are there in the hotel");
				}
				break;

			case 5:
				System.out.println("Enter room id to check which guest is staying");
				roomId = sc.nextInt();

				Guest findGuestCheckedInRoom = hotelClient.service.findGuestCheckedInRoom(roomId);
				if (findGuestCheckedInRoom != null) {
					System.out.println(findGuestCheckedInRoom);
				} else {
					System.out.println("In the given room id no one is staying present");
				}
				break;

			case 6:
				int guestsCount = hotelClient.service.guestsCount();
				System.out.println("present guests in the hotel are: " + guestsCount);
				break;
				

			case 7:
				System.out.println("Enter guest id for alloting room");
				gid = sc.nextLong();
				System.out.println("Enter room id to allote which room");
				roomId = sc.nextInt();
				
				hotelClient.service.updateRoomCheckedIn(roomId, gid);
				break;
			}
		}
		sc.close();
		System.out.println("Thank you");
		

	}

}
