package com.bl.birdsantuary;

public class ViewLayer {

	public void print() {
		BirdSantuaryRepository birdSantuaryRepository = BirdSantuaryRepository.getInstance();
		for (Object items : birdSantuaryRepository.getAllBird()) {
			System.out.println(items);
		}
	}

	public void printFlyable() {
		BirdSantuaryRepository birdSantuaryRepository = BirdSantuaryRepository.getInstance();
		for (Bird item : birdSantuaryRepository.getAllBird()) {
			if (item.canFly) {
				item.fly();
			}
		}
	}

	public void printSwimmable() {
		BirdSantuaryRepository birdSantuaryRepository = BirdSantuaryRepository.getInstance();
		for (Bird item : birdSantuaryRepository.getAllBird()) {
			if (item.canSwim) {
				item.swim();
			}

		}
	}

	public void printEatable() {
		BirdSantuaryRepository birdSantuaryRepository = BirdSantuaryRepository.getInstance();
		for (Bird item : birdSantuaryRepository.getAllBird()) {
			item.eat();
		}
	}

	public void printcountBird() {
		BirdSantuaryRepository birdSantuaryRepository = BirdSantuaryRepository.getInstance();
		int count = 0;
		for (Bird item : birdSantuaryRepository.getAllBird()) {
			count += 1;

		}
		System.out.println("total no of birds : " + count);
		System.out.println("____________________________");

	}

}
 