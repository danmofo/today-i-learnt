package com.dmoffat.til.utils;

import java.util.ArrayList;
import java.util.List;

import com.dmoffat.til.model.Tag;
import com.dmoffat.til.model.Thing;

public class Utilities {

	/**
	 * Spring Data JPA returns an iterable from findAll(), this method
	 * adds them all to a list for ease-of-use.
	 * @param it
	 * @return
	 */
	//todo: make generic
	public static List<Thing> makeThingList(Iterable<Thing> it) {
		List<Thing> l = new ArrayList<Thing>();
		
		for(Thing item : it) {
			l.add(item);
		}

		return l;
	}
	
	public static List<Tag> makeTagList(Iterable<Tag> it) {
		List<Tag> l = new ArrayList<Tag>();
		
		for(Tag item : it) {
			l.add(item);
		}

		return l;
	}
}
