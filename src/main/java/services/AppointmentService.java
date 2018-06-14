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

import model.Appointment;
import model.Parent;
import repositories.AppointmentRepository;


@RestController
public class AppointmentService {

	@Autowired
	AppointmentRepository repository;
	
	@DeleteMapping("/api/appt/{apptId}")
	public void deleteAppt(@PathVariable("apptId") int id) {
		repository.deleteById(id);
	}
	
	@PostMapping("/api/appt")
	public Appointment createAppt(@RequestBody Appointment appt) {
		return repository.save(appt);
	}
	
	@GetMapping("/api/appt")
	public List<Appointment> findAllAppt() {
		return (List<Appointment>) repository.findAll();
	}
	
	@PutMapping("/api/appt/{apptId}")
	public Appointment updateAppt(@PathVariable("apptId") int apptId, @RequestBody Appointment newAppt) {
		Optional<Appointment> data = repository.findById(apptId);
		 if(data.isPresent()) {
			 Appointment appt = data.get();
			 appt.setAssignedStudent(newAppt.getAssignedStudent());
			 appt.setStartTime(newAppt.getStartTime());
			 appt.setEndTime(newAppt.getEndTime());
			 appt.setSubject(newAppt.getSubject());
			 appt.setTutor(newAppt.getTutor());
			 appt.setApptType(newAppt.getApptType());
			 repository.save(appt);
			 return appt;
		 }
		 return null;
	}
}
