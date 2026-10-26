package java_main;

import java.util.Date; 

public class Appointment {
	private final String appointmentId;
	private Date appointmentDate;
	private String appointmentDesc;
	
	// This section ensures that the Id, Date, and description are all within an appropriate length
	public Appointment(String appointmentId, Date appointmentDate, String appointmentDesc) {
		if(appointmentId == null || appointmentId.length()>10) {
			throw new IllegalArgumentException("Invalid id");
		}
		if(appointmentDate == null || appointmentDate.before(new Date())) {
			throw new IllegalArgumentException("Invalid date");
		}
		if(appointmentDesc == null || appointmentDesc.length()>50) {
			throw new IllegalArgumentException("Invalid description");
		}
		this.appointmentId = appointmentId;
		this.appointmentDate = appointmentDate;
		this.appointmentDesc = appointmentDesc;
	}
	public String getAppointmentId() {
		return appointmentId;
	}
	public Date getAppointmentDate() {
		return appointmentDate;
	}
	public String getAppointmentDesc() {
		return appointmentDesc;
	}
	
	public void setAppointmentDate(Date appointmentDate) {
        if (appointmentDate == null || appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Invalid date");
        }

        this.appointmentDate = appointmentDate;
    }
	
	public void setAppointmentDesc(String appointmentDesc) {
        if (appointmentDesc == null || appointmentDesc.length() > 50) {
            throw new IllegalArgumentException("Invalid description");
        }

        this.appointmentDesc = appointmentDesc;
    }
}
	
