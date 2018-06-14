package services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import model.Parent;
import repositories.ParentRepository;

@RestController
public class ParentService {
	@Autowired
	ParentRepository repository;
	
	@DeleteMapping("/api/parent/{userId}")
	public void deleteUser(@PathVariable("userId") int id) {
		repository.deleteById(id);
	}
	
	@PostMapping("/api/parent")
	public Parent createUser(@RequestBody Parent parent) {
		return repository.save(parent);
	}
	
	@PostMapping("/api/register")
	public Parent register(@RequestBody Parent parent) {
	Parent data = findUserByUsername(parent.getUsername());
		if(data == null) {
			createUser(parent);
			return parent;
		}
		else {
		    return null;
		}
	}
 	
	@PostMapping("/api/login")
	public Parent login(@RequestBody Parent parent) {
		Optional<Parent> data = repository.findUserByCredentials(parent.getUsername(), parent.getPassword());
		 if(data.isPresent()) {
			 return data.get();
		 }
		 else {
		 return null;
		 }
	}
	
	@GetMapping("/api/register/{username}")
	public Parent findUserByUsername(@PathVariable("username") String username) {
		Optional<Parent> data = repository.findUserByUsername(username);
		 if(data.isPresent()) {
			 return data.get();
		 }
		 else {
		 return null;
		 }
	}
	
	@GetMapping("/api/parent")
	public List<Parent> findAllUsers() {
		return (List<Parent>) repository.findAll();
	}
	
	@GetMapping("/api/parent/{userId}")
	public Parent findUserById(@PathVariable("userId") int userId) {
		 Optional<Parent> data = repository.findById(userId);
		 if(data.isPresent()) {
			 return data.get();
		 }
		 return null;
	}
	
	@PutMapping("/api/parent/{userId}")
	public Parent updateUser(@PathVariable("userId") int userId, @RequestBody Parent newUser) {
		Optional<Parent> data = repository.findById(userId);
		 if(data.isPresent()) {
			 Parent user = data.get();
			 user.setUsername(newUser.getUsername());
			 user.setPassword(newUser.getPassword());
			 user.setFirstName(newUser.getFirstName());
			 user.setLastName(newUser.getLastName());
			 user.setLocation(newUser.getAddress());
			 repository.save(user);
			 return user;
		 }
		 return null;
	}
}
