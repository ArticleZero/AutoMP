package com.articlezero.mp;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Location;

public class Mineparty {

	private Location min;
	private Location max;
	private String name;
	private Map<Integer, String> rounds = new HashMap<Integer, String>(); //round 1, diamondblock50%,emeraldblock50%
	
	public Mineparty(String name, Location min, Location max){
		this.setName(name); 
		this.setMin(min);
		this.setMax(max);
	}

	
	/**
	 * @return if the mp has rounds defined
	 */
	public boolean hasRounds(){
		return !(rounds.isEmpty());
	}
	
	/**
	 * @return the rounds <round number, round items>
	 */
	public Map<Integer, String> getRounds(){
		return rounds;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the max
	 */
	public Location getMax() {
		return max;
	}

	/**
	 * @param max the max to set
	 */
	public void setMax(Location max) {
		this.max = max;
	}

	/**
	 * @return the min
	 */
	public Location getMin() {
		return min;
	}

	/**
	 * @param min the min to set
	 */
	public void setMin(Location min) {
		this.min = min;
	}
}
