/*
 * @author : Charul Singhvi
 * @date : 08-03-2021
 * @ZooManagement is the main class for zoo management system.
 * @Zone : Sub class of Zoo Management {Mammal, Bird, Reptile}
 * @Cage : Sub class of zone {Lion, Crocodile, Peacock}
 * @Animal : Sub class of Cage {Allocated a cage, unique name, age, weight, getSound()}
 * 
 * //Zone per animal characteristics : Mammal, Bird, Reptile
//Lion, Crocodile, Peacock
//Zone : Category, number of cages,  hasPark, hasCanteen
//Cage : type of animals, limit of animals, capacity
//Animal : Allocated a cage, unique name, age, weight, getSound()

 */

import java.util.Scanner;

public class ZooManagement{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		try{
			System.out.println(	"Enter 1 to add cage to zone.\n"
							+	"Enter 2 to add animal to cage.\n"
							+	"Enter 3 to remove animal from cage.\n"
							+	"Enter 4 to view list of cages in zone.\n"
							+	"Enter 5 to end the process!");
			Zone zone = new Zone(2);
			while(true){
				
				System.out.println("Enter choice :");
				int Userchoice = sc.nextInt();
	
				if (Userchoice == 1){
					System.out.println("Enter Capacity of cage : ");
					int capacity = sc.nextInt();
					System.out.println("Enter type of cage : ");
					String type = sc.next();
					if (zone.addCage(capacity, type) == true){
						System.out.println("Cage added successfully.");
					}
				}
				
				else if (Userchoice == 2){
					System.out.println("Enter type of animal (Lion, Peacock, Crocodile):");
					String typeOfAnimal = sc.next();
					System.out.println("Enter age");
					int age = sc.nextInt();
					System.out.println("Enter weight");
					int weight = sc.nextInt();
					if ("Lion".equalsIgnoreCase(typeOfAnimal)){
						System.out.println("Enter true if animal is carnivorous , false otherwise.");
						Boolean carnivorous = sc.nextBoolean();
						try{
							if (zone.addAnimalToZone(typeOfAnimal,"Lion", age, weight, carnivorous) == true){
							System.out.println("Animal added successfully.");
							}
						}
						catch(Exception e){
							System.out.println(e.getMessage());
						}
					}
					
				
					else if ("Peacock".equalsIgnoreCase(typeOfAnimal)){
						System.out.println("Enter flight of bird :");
						float flight = sc.nextFloat();
						try {
							if (zone.addAnimalToZone(typeOfAnimal,"Peacock", age, weight, flight) == true){
								System.out.println("Animal added successfully.");
							}
						} catch (Exception e) {
							 System.out.println(e.getMessage());
						}
					}
				
					else if ("Crocodile".equalsIgnoreCase(typeOfAnimal)){
						System.out.println("Enter length of animal :");
						float length = sc.nextFloat();
						try {
							if (zone.addAnimalToZone(typeOfAnimal,"Crocodile", age, weight, length) == true){
								System.out.println("Animal added successfully.");
							}
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
					}
				
					else{
						System.out.println("Invalid input");
					}
				}
				else if (Userchoice == 3){
					System.out.println("Enter type of animal :");
					String typeOfAnimal = sc.next();
					System.out.println("Enter id :");
					int id = sc.nextInt();
					try {
						zone.removeAnimalFromZone(typeOfAnimal, id);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
				else if (Userchoice == 4){
					zone.displayList();
				}
				else if (Userchoice == 5){
					System.out.println("Thanks for connecting.");
					break;
				}
				else{
					System.out.println("Invalid input");
				}
			}
		}
		catch(Exception e){
			System.out.println("Please provide valid inputs!");
		}
		
		sc.close();
	}
}