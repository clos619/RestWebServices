package com.example.demo;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;




//@Repository
public class NameService {
	@Autowired
	private Name name;

	private NameService ns;
	ArrayList<Name> namo = new ArrayList<Name>();
	
	
	
	
	
		
		public ArrayList<Name>getName(){
		
			namo.add(new Name(1, "Carlos","Henderson","Gaming"));
			namo.add(new Name(2, "solarc","Mad","Warmongering"));
			namo.add(new Name(3, "jumanji","Game","Changing the world"));
			namo.add(new Name(4, "christmas","Nick","Giving gifts"));
			namo.add(new Name(5, "winter","Summer","Fall"));
			namo.add(new Name(6, "snow","fall","falling"));
			namo.add(new Name(7, "surfing","Jones","riding waves"));
			return namo;
		}
	
	
	
	
	public Name findById(long id) {
			for(Name thename : namo){
				if(thename.getId()==id){
					return thename;
				}
			}
		return null;
		
	}
	public Name findByName(Name name2) {
		for(Name uhname : namo){
			if(uhname.getFirstName().equals(name2)){
				return uhname;
			}
			if(uhname.getLastName().equals(name2)) {
				return uhname;
			}
		}
		return null;
	}
	
	public Name saveUser(Name name) {
	
		name.setId(name.getId());
		namo.add(name);
		
		return name;
	}


	public void updateUser(Name name) {
	
		int index = namo.indexOf(name);
		namo.set(index, name);
		
		
		
	
	}




	public Name patchName(Long id, Name name) {
		// TODO Auto-generated method stub

		//for(Name name1 : namo) {
		Name fetchedName = this.findById(id);

		if(name.getFirstName()!=null) {
		fetchedName.setFirstName(name.getFirstName());
		}
		if(name.getLastName()!=null) {
		fetchedName.setLastName(name.getLastName());
		}
		if(name.getHobbies()!=null) {
		fetchedName.setHobbies(name.getHobbies());
		}
		
		return fetchedName;
		
	}




		
	
	

//	
////	public List<Name> names = Arrays.asList(
////			new Name("john"),
////			new Name("jacob"),
////			new Name("San"),
////			new Name("pokemon"),
////			new Name("jace"),
////			new Name("macob"),
////			new Name("lan"),
////			new Name("dokemon"));
	
	
	
	

//	public List<Name> getAllNames(){
//		return names;
//	}

}


