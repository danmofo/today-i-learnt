package com.dmoffat.til.utils;

import java.util.ArrayList;
import java.util.List;

import com.dmoffat.til.model.Thing;

public class Utilities {

	/**
	 * Spring Data JPA returns an iterable from findAll(), this method
	 * adds them all to a list for ease-of-use.
	 * @param it
	 * @return
	 */
	public static List<Thing> makeList(Iterable<Thing> it) {
		List<Thing> l = new ArrayList<Thing>();
		
		for(Thing item : it) {
			l.add(item);
		}

		return l;
	}
}
