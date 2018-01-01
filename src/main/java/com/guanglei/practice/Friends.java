package com.guanglei.practice;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

public class Friends {
	public static <K,V extends Comparable<? super V>> 
	    List<Entry<K, V>> entriesSortedByValues(Map<K,V> map) {
	
		List<Entry<K,V>> sortedEntries = new ArrayList<Entry<K,V>>(map.entrySet());
	
		Collections.sort(sortedEntries, 
		    new Comparator<Entry<K,V>>() {
		        public int compare(Entry<K,V> e1, Entry<K,V> e2) {
		            return e2.getValue().compareTo(e1.getValue());
		        }
		    }
		);
		return sortedEntries;
	}
	
	
	public static void main( String[] args ) throws IOException{
		List<String> lines = FileUtils.readLines(new File("friends.txt"), "UTF-8");
		Students peter=new Students();
		peter.setName("Peter");
		for(String a: lines){
			if(a.contains("Peter"))
				peter.setFriend(StringUtils.substringAfter(a, "Peter "));
			for(String b:peter.getFriend()) {
				if(StringUtils.startsWith(a, b)) {
					peter.setSecFriend(StringUtils.substringAfter(a, b+" "));
				}
			}
		}
		System.out.println(peter);
		
		List<String> course = FileUtils.readLines(new File("course.txt"), "UTF-8");
		HashMap<String,Integer> map=new HashMap<String,Integer>();
		
		for(String a: course) {
			for(String b:peter.getFriend()) {
				if(StringUtils.startsWith(a, b)) {
					Integer i = map.get(StringUtils.substringAfter(a, b+" "));
					if(i==null)
						map.put(StringUtils.substringAfter(a, b+" "), 1);
					else
						map.put(StringUtils.substringAfter(a, b+" "), i+1);
				}	
			}	
		}
		
		System.out.println(entriesSortedByValues(map));
	}
}
