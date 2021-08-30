package com.bl.birdsantuary;  //data layer

//import java.util.List;
//import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class BirdSantuaryRepository {
	
	private static BirdSantuaryRepository instance;
	
	private Set<Bird> birdList = new HashSet();
	
	private BirdSantuaryRepository() {
		
	}
	
	static synchronized BirdSantuaryRepository getInstance() {
		if(instance == null) {
			instance = new BirdSantuaryRepository();
		}
		return instance;
	}
	
	public void add(Bird bird) {
		birdList.add(bird);
	}
	
	public void remove(Bird bird) {
		birdList.remove(bird);
	}
	
	public Bird getBird(String name) {
		for (Bird bird : birdList) {
			if (bird.name.equals(name)) {
				return bird;
			}
		}
		return null;
	}
	
	public Set<Bird> getAllBird() {
		return birdList;
	}
	
	
}
