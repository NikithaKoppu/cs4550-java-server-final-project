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

import model.Student;
import repositories.StudentRepository;

@RestController
public class StudentService {
	@Autowired
	StudentRepository repository;
	
	@DeleteMapping("/api/student/{userId}")
	public void deleteUser(@PathVariable("userId") int id) {
		repository.deleteById(id);
	}
	
	@PostMapping("/api/student")
	public Student createUser(@RequestBody Student student) {
		return repository.save(student);
	}
	
	@PostMapping("/api/register")
	public Student register(@RequestBody Student student) {
	Student data = findUserByUsername(student.getUsername());
		if(data == null) {
			createUser(student);
			return student;
		}
		else {
		    return null;
		}
	}
 	
	@PostMapping("/api/login")
	public Student login(@RequestBody Student student) {
		Optional<Student> data = repository.findUserByCredentials(student.getUsername(), student.getPassword());
		 if(data.isPresent()) {
			 return data.get();
		 }
		 else {
		 return null;
		 }
	}
	
	@GetMapping("/api/register/{username}")
	public Student findUserByUsername(@PathVariable("username") String username) {
		Optional<Student> data = repository.findUserByUsername(username);
		 if(data.isPresent()) {
			 return data.get();
		 }
		 else {
		 return null;
		 }
	}
	
	@GetMapping("/api/student")
	public List<Student> findAllUsers() {
		return (List<Student>) repository.findAll();
	}
	
	@GetMapping("/api/student/{userId}")
	public Student findUserById(@PathVariable("userId") int userId) {
		 Optional<Student> data = repository.findById(userId);
		 if(data.isPresent()) {
			 return data.get();
		 }
		 return null;
	}
	
	@PutMapping("/api/student/{userId}")
	public Student updateUser(@PathVariable("userId") int userId, @RequestBody Student newUser) {
		Optional<Student> data = repository.findById(userId);
		 if(data.isPresent()) {
			 Student user = data.get();
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
