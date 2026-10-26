package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java_main.AppointmentService;
import java_main.Appointment;

class AppointmentServiceTest {

	@Test
	void testAddAppointment() {
		Date appointmentDate = new Date(System.currentTimeMillis() + 20000);
		
		AppointmentService service = new AppointmentService();
		Appointment appointment = new Appointment("1", appointmentDate, "This is an example description.");
			
		service.addAppointment(appointment);
			
		assertNotNull(service.findAppointment("1"));
			
		assertEquals("1", service.findAppointment("1").getAppointmentId());
		assertEquals(appointmentDate, service.findAppointment("1").getAppointmentDate());
		assertEquals("This is an example description.", service.findAppointment("1").getAppointmentDesc());
	}
	
	@Test
	void testDeleteAppointment() {
		Date appointmentDate = new Date(System.currentTimeMillis() + 20000);
		
		AppointmentService service = new AppointmentService();
		Appointment appointment = new Appointment("1", appointmentDate, "This is an example description.");
			
		service.addAppointment(appointment);
		service.deleteAppointment("1");			
		assertNull(service.findAppointment("1"));
	}
	@Test
	void testDuplicateAppointment() {
		Date appointmentDate = new Date(System.currentTimeMillis() + 20000);
		
		AppointmentService service = new AppointmentService();
		Appointment appointment = new Appointment("1", appointmentDate, "This is an example description.");
		Appointment dupplicateAppointment = new Appointment("1", appointmentDate, "This is an example description.");
			
		service.addAppointment(appointment);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.addAppointment(dupplicateAppointment);
		});
	}
}