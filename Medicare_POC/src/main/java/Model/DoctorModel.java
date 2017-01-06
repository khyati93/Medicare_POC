package Model;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="doctors")
public class DoctorModel {

	@Id
	private int id;
	
	private String name;
	private String specialisation;
	private String email;
	private int experience;
	private int contactnum;
	private int timeslot;
	public DoctorModel(){}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpecialisation() {
		return specialisation;
	}
	public void setSpecialisation(String specialisation) {
		this.specialisation = specialisation;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public int getContactnum() {
		return contactnum;
	}
	public void setContactnum(int contactnum) {
		this.contactnum = contactnum;
	}
	public int getTimeslot() {
		return timeslot;
	}
	public void setTimeslot(int timeslot) {
		this.timeslot = timeslot;
	}
	public DoctorModel(int id, String name, String spec, String email, int experience, int contactnum, int timeslot) {
		super();
		this.id = id;
		this.name = name;
		this.specialisation = specialisation;
		this.email = email;
		this.experience = experience;
		this.contactnum = contactnum;
		this.timeslot = timeslot;
	}
}