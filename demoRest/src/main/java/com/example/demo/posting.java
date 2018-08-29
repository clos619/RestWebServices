package com.example.demo;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;





@RestController
public class posting {


	private posting post;
	private Name name;
	NameService ns = new NameService();



	
	@RequestMapping("/name/")
	public @ResponseBody ArrayList<Name> getAllNames() {
		
		
		return ns.getName();
		
	}
	@RequestMapping(value = "/name/{id}", method = RequestMethod.GET)
	public ResponseEntity<Name> getName(@PathVariable("id")Long id) {
		Name fetchedName = ns.findById(id);
		if (fetchedName == null) {
			return new ResponseEntity<Name>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Name>(fetchedName, HttpStatus.OK);
	}

//	@RequestMapping(value="/name/",method=RequestMethod.POST)
//	@ResponseBody
//	public Name addName(@PathVariable("id")String id,@RequestBody Name name) {
//		
//		
//		
//		return new Name(8, "GODZILLA");
//	}
	 @RequestMapping(value = "/name/", method = RequestMethod.POST)
	    public ResponseEntity<?> createName(@RequestBody Name name, UriComponentsBuilder ucBuilder) {
	       
	 
	       
	        ns.saveUser(name);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/name/{id}").buildAndExpand(name.getId()).toUri());
	        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	    }
	 @RequestMapping(value = "/name/{id}", method = RequestMethod.PUT)
		public ResponseEntity<?> updateName(@PathVariable("id")long id, @RequestBody Name name) {
		
		 Name realname = ns.findById(id);
		 
		 realname.setId(name.getId());
			realname.setFirstName(name.getFirstName());
			realname.setLastName(name.getLastName());
			realname.setHobbies(name.getHobbies());
			

			ns.updateUser(realname);
			return new ResponseEntity<Name>(realname, HttpStatus.OK);
		 
		}
		



@RequestMapping(value = "/name/{id}", method = RequestMethod.PATCH)
public ResponseEntity<Name> patchName(@PathVariable("id")Long id, @RequestBody Name name) {
	Name patchedName = ns.patchName(id, name);
	
	if (patchedName == null) {
		return new ResponseEntity<Name>(HttpStatus.NOT_FOUND);
	}
	
	return new ResponseEntity<Name>(patchedName, HttpStatus.OK);
}
	

}
