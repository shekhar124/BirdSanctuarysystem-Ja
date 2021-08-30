package com.bl.birdsantuary;

import java.util.EnumSet;
import java.util.Scanner;

import com.bl.birdsantuary.Bird.Color;

//control layer
public class Main {
	
	public static void main(String[] args) {
		Main main = new Main();
		main.userMenu();
		System.out.println("GOOD BYE!!");
	}
	
	void userMenu() {
		Scanner scan = new Scanner(System.in);
		int option = 0;
		final int EXIT_VALUE = 10;
		while(option != EXIT_VALUE) {
			System.out.println("Enter your options");
			System.out.println("1. add \n2. remove \n3. print birds \n4. print swimable"
					+ "\n5. print flyable \n6. print eatable \n7. edit bird \n"+EXIT_VALUE+". EXIT");
			option = scan.nextInt();
			ViewLayer viewLayer = new ViewLayer();
			
			switch (option) {
				case 1:	
					addTempBird();
					addBird();
					break;
				case 2:
					removeBird();
					break;
				case 3:
					viewLayer.print();
					break;
				case 4:
					viewLayer.printSwimmable();
					break;
				case 5:
					viewLayer.printFlyable();
					break;
				case 6:
					viewLayer.printEatable();
					break;
				case 7:
					editBird();
					break;
			}
		}
	}
	
	private void removeBird() {
		Scanner scan = new Scanner(System.in);
		System.out.println("enter the bird name which you want to remove");
		String birdname = scan.nextLine();
		birdname = scan.next();
		BirdSantuaryRepository birdSantuaryRepository = BirdSantuaryRepository.getInstance();
		Bird removeBird = birdSantuaryRepository.getBird(birdname);
		birdSantuaryRepository.remove(removeBird);
	}

	private void addTempBird() {
		
		Bird duck = new Bird();
		duck.id = "D-001";
		duck.name = "duck";
		duck.color = Bird.Color.WHITE;
		duck.canFly = false;
		duck.canSwim = true;
		
		BirdSantuaryRepository.getInstance().add(duck);
		
		Bird penguin = new Bird();
		
		penguin.id = "pg-001";
		penguin.name = "penguin";
		penguin.color = Bird.Color.WHITE;
		penguin.canFly = false;
		penguin.canSwim = true;

		BirdSantuaryRepository.getInstance().add(penguin);
	}
	
	private void addBird(){
		Scanner scan = new Scanner(System.in);
		Bird bird = new Bird();
		System.out.println("Enter bird id");
		String id = scan.next();
		bird.id = id;
		System.out.println("Enter bird color");
		int count = 0;
		for (Bird.Color color: EnumSet.allOf(Bird.Color.class)) {
			System.out.println(count + "." + color);
			count++;
		}
		int colorchoice = scan.nextInt();
		int count1 = 1;
		for (Bird.Color color: EnumSet.allOf(Bird.Color.class)) {
			if(colorchoice == count1) {
				bird.color = color;
				break;
			}
			count1++;
		}
		System.out.println("enter Bird name");
		String name = scan.next();
		bird.name = name;
		System.out.println("can bird fly?");
		boolean canFly = scan.nextBoolean();
		bird.canFly = canFly;
		System.out.println("can bird swim?");
		boolean canSwim = scan.nextBoolean();
		bird.canSwim = canSwim;
		
		BirdSantuaryRepository birdSantuaryRepository = BirdSantuaryRepository.getInstance();
		
		birdSantuaryRepository.add(bird);
	}
	
	private void editBird() {
		System.out.println("Enter the bird name which you want to edit");
		Scanner scan = new Scanner(System.in);
		String editName = scan.next();
		
		Bird editBird = BirdSantuaryRepository.getInstance().getBird(editName);
		
		int choice = 0;
		while(choice != 4) {
			System.out.println("Enter your editing choice");
			System.out.println("1. Edit bird name \n2. Edit id \n3. Edit color \n4. exit");
			choice = scan.nextInt();
			switch (choice) {
			case 1: 
				System.out.println("Enter new name");
				String newName = scan.next();
				editBird.name = newName;
				break;
			case 2:
				System.out.println("Enter new ID");
				String newId = scan.next();
				editBird.id = newId ;
				break;
			case 3:
				System.out.println("Enter new color");
				int count = 1;
				for (Bird.Color color: EnumSet.allOf(Bird.Color.class)) {
					System.out.println(count + "." + color);
					count++;
				}
				int colorchoice = scan.nextInt();
				int count1 = 1;
				for (Bird.Color color: EnumSet.allOf(Bird.Color.class)) {
					if(colorchoice == count1) {
						editBird.color = color;
						break;
					}
					count1++;
				}
				break;
			
			}
		}
	}
}
