package java_main;

import java.util.ArrayList;
import java.util.List;

public class AppointmentService {
		List<Appointment> appointments = new ArrayList<>();
		
	    public void addAppointment(Appointment appointment) {
	        if (appointment == null) {
	            throw new IllegalArgumentException("Appointment cannot be null");
	        }

	        if (findAppointment(appointment.getAppointmentId()) != null) {
	            throw new IllegalArgumentException("Appointment ID already exists");
	        }

	        appointments.add(appointment);
	    }
	    public void deleteAppointment(String appointmentId) {
	    	Appointment appointment = findAppointment(appointmentId);

	        if (appointment == null) {
	            throw new IllegalArgumentException("Appointment not found");
	        }

	        appointments.remove(appointment);
	    }
	    public Appointment findAppointment(String appointmentId) {
	        for (Appointment appointment : appointments) {
	            if (appointment.getAppointmentId().equals(appointmentId)) {
	                return appointment;
	            }
	        }

	        return null;
	    }
}