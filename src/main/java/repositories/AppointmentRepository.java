package repositories;

import org.springframework.data.repository.CrudRepository;

import model.Appointment;

public interface AppointmentRepository extends CrudRepository<Appointment, Integer>{

}
