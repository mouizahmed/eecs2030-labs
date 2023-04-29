package pe2;

import java.util.*;
/* PLEASE DO NOT MODIFY A SINGLE STATEMENT IN THE TEXT BELOW.
READ THE FOLLOWING CAREFULLY AND FILL IN THE GAPS

I hereby declare that all the work that was required to 
solve the following problem including designing the algorithms
and writing the code below, is solely my own and that I received
no help in creating this solution and I have not discussed my solution 
with anybody. I affirm that I have read and understood
the Senate Policy on Academic honesty at 
https://secretariat-policies.info.yorku.ca/policies/academic-honesty-senate-policy-on/
and I am well aware of the seriousness of the matter and the penalties that I will face as a 
result of committing plagiarism in this assignment.

BY FILLING THE GAPS,YOU ARE SIGNING THE ABOVE STATEMENTS.

Full Name: Mouiz Ahmed
Student Number:  218105536
Course Section: Z
*/

/**
 * The hospital class sets up all directors, physician administrators,
 * physicans, patients, and volunteers within the hospital. This is where the
 * employees of the hospital are manipulated.
 * 
 * @author Mouiz Ahmed
 * @version 1.0
 */
public class Hospital {

	// private Director director;
	protected List<PhysicianAdministrator> adminList = new ArrayList<PhysicianAdministrator>();
	protected List<Physician> physList = new ArrayList<Physician>();
	protected List<Patient> patientList = new ArrayList<Patient>();
	protected List<Volunteer> volList = new ArrayList<Volunteer>();

	private int patNum = 0;
	private int volNum = 0;
	private int totalPat = 0;
	private int totalVol = 0;
	private int e = 0; // counter for PhysList
	private int f = 0; // counter for volList

	private Director director;
	private Physician physician;
	private PhysicianAdministrator pa;
	private Patient pat;

	/**
	 * This constructor initializes the instance variable director with the type
	 * Director with the parameter.
	 * 
	 * @param director is of type Director which stores the contents of the director
	 *                 role from the method.
	 */
	public Hospital(Director director) {
		// TODO Auto-generated constructor stub
		this.director = director;
	}

	/**
	 * This method gets the value (address) of the hospital's director that contains
	 * all information related to that particular director it was initialized with
	 * previously.
	 * 
	 * @return This method returns a value of type Director which contains all
	 *         information contained in the variable director.
	 */
	public Director getHospDirector() {

		return this.director;
	}

	/**
	 * This method adds a Physician Administrator to the list of Administrators
	 * within the hospital. The maximum number of Physician Administrators per
	 * hospital is 3.
	 * 
	 * @param admin is of type PhysicianAdministrator which contains all the
	 *              information associated and initialized within it.
	 * @return This method returns a boolean value of true or false depending on if
	 *         the the list of Physician Administrators has surpassed 3 or not.
	 */
	public Boolean addAdministrator(PhysicianAdministrator admin) {

		if (this.adminList.size() < 3) {
			this.adminList.add(admin);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * This method hires a Physician and adds it to a Physician Record within the
	 * hospital.
	 * 
	 * @param physician is of type Physician which contains all the information
	 *                  associated and initialized within it.
	 * @return This method returns a boolean value of true or false depending on if
	 *         there are duplicates or surpasses the maximum number of Physicians
	 *         per hospital of 70.
	 */
	public boolean hirePhysician(Physician physician) {

		if (this.physList.contains(physician) == false) {
			this.physList.add(physician);

			for (int i = 0; i < physList.size(); i++) {
				for (int j = 0; j < adminList.size(); j++) {
					if (adminList.get(j).specialty == physList.get(i).specialty) {
						pa = adminList.get(j);
						break;
					}
				}
			}
			pa.assignPhysician(physician);

			return true;
		} else {
			return false;
		}
	}

	/**
	 * This method removes a physician from the physician records of the hospital.
	 * @param physician of type Physician object is used to specify which physician is to be removed from the physician records (list).
	 * @throws NoSpecialtyException This exception is thrown if there are no physicians available of this specific type after the removal of this physician. If that is the case, it will throw the NoSpecialtyException.
	 */
	public void resignPhysician(Physician physician) throws NoSpecialtyException {

		int counter = 0;
		List<Patient> patTempL = new ArrayList<Patient>();
		List<Volunteer> volTempL = new ArrayList<Volunteer>();

		for (int i = 0; i < physList.size(); i++) {
			if (physList.get(i).getSpecialty() == physician.getSpecialty()) {
				counter += 1;
			}
		}

		if (counter > 1) {
			int g = 0;
			int o = 0;

			for (int i = 0; i < physList.size(); i++) {

				if (physList.get(i) == physician) {
					patTempL.addAll(physList.get(i).patL);
					volTempL.addAll(physList.get(i).volL);
					physList.get(i).removeAll();
					physList.remove(i);
				}

			}

			for (int i = 0; i < physList.size(); i++) {

				while (physList.get(i).patL.size() < 8 && g < patTempL.size()) {
					physList.get(i).patL.add(patTempL.get(g));
					g++;

				}
				while (physList.get(i).volL.size() < 5 && g < volTempL.size()) {
					physList.get(i).volL.add(volTempL.get(g));
					o++;

				}

			}

		} else {
			throw new NoSpecialtyException();
		}

	}

	/**
	 * This method returns a sorted list of all physicians within the hospital records.
	 * @return of type List<Physician> contains a sorted list/record of all physicians within the hospital records.
	 */
	public List<Physician> extractAllPhysicianDetails() {
		Collections.sort(physList, new Comparator<Physician>() {

			@Override
			public int compare(Physician o1, Physician o2) {
				// TODO Auto-generated method stub
				return o1.getName().compareTo(o2.getName());
			}

		});
		return this.physList;
	}
	
	/**
	 * This method returns a sorted list of all patients within the hospital records.
	 * @return of type List<Patient> contains a sorted list/record of all patient records within the hospital.
	 */
	public List<Patient> extractAllPatientDetails() {
		Collections.sort(patientList, new Comparator<Patient>() {

			@Override
			public int compare(Patient o1, Patient o2) {
				// TODO Auto-generated method stub
				return o1.getName().compareTo(o2.getName());
			}

		});
		return this.patientList;
	}

	/**
	 * This method adds a patient to the hospital.
	 * @param patient of type Patient object specifies which patient to add to the records.
	 * @return of type Boolean returns a value of true or false. True if the patient has successfully been added to the records, and false otherwise.
	 * @throws NoSpaceException is thrown when the hospital is at maximum capacity and can no longer take any more patients (patient records list is at max).
	 */
	public Boolean admitPatient(Patient patient) throws NoSpaceException {

		int maxCap = physList.size() * 8;

		// System.out.println("CAP " + maxCap);

		if (patientList.size() > 500 || patientList.size() >= maxCap) {
			throw new NoSpaceException();
		} else if (this.patientList.contains(patient) == false) {
			patientList.add(patient);
			// System.out.println("PATIENT NUM" + patientList.size());
			if (e < physList.size()) {
				if (patNum < 8) {
					physician = physList.get(e);
					physician.assignPatient(patient);
					patNum = patNum + 1;
					totalPat += patNum;
					// System.out.println("PATIENT NUM" + patNum);
					// System.out.println("SPOT " + patientList.size());

				} else {
					patNum = 0;
					e += 1;
					if (e < physList.size()) {
						physician = physList.get(e);
						physician.assignPatient(patient);
						// System.out.println("SPOT " + patientList.size());
					}
					patNum = patNum + 1;
					totalPat += patNum;
				}
			}

			return true;
		} else {
			return false;
		}

	}

	/**
	 * This method removes patients from the records of the hospital due to being discharged.
	 * @param patient of type Patient object specifies which patient to be removed.
	 * @return of Boolean value. Returns true if patient is able to successfully be removed from hospital records and false otherwise.
	 */
	public Boolean dischargePatient(Patient patient) {

		if (this.patientList.contains(patient) == true) {
			for (int i = 0; i < this.patientList.size(); i++) {
				if (this.patientList.get(i) == patient) {
					this.patientList.remove(i);
				}
			}

			for (int i = 0; i < this.physList.size(); i++) {
				for (int j = 0; j < this.physList.get(i).patL.size(); j++) {
					if (this.physList.get(i).patL.get(j) == patient) {
						this.physList.get(i).patL.remove(j);
					}
				}
			}

			return true;
		} else {
			return false;
		}
	}

	/**
	 * This method adds a volunteer to the hospital records list.
	 * @param volunteer of type Volunteer object (has already been initialized) specifies which volunteer to be added to the hospital records.
	 * @return of type Boolean. Returns true if the volunteer has successfully been able to be added to the hospital records, and false otherwise.
	 */
	public Boolean hireVolunteer(Volunteer volunteer) {

		int maxCap = physList.size() * 5;

		// System.out.println("CAP " + maxCap);

		if (volList.size() > 150 || patientList.size() >= maxCap) {
			return false;
		} else if (this.volList.contains(volunteer) == false) {
			volList.add(volunteer);
			// System.out.println("PATIENT NUM" + patientList.size());
			if (f < physList.size()) {
				if (volNum < 5) {

					physList.get(f).assignVolunteerHire(volunteer);
					volNum = volNum + 1;
					totalVol += volNum;
					// System.out.println("PATIENT NUM" + patNum);
					// System.out.println("SPOT " + patientList.size());

				} else {
					volNum = 0;
					f += 1;
					if (f < physList.size()) {

						physList.get(f).assignVolunteerHire(volunteer);
						// System.out.println("SPOT " + patientList.size());
					}
					volNum = volNum + 1;
					totalVol += volNum;
				}
			}

			return true;
		} else {
			return false;
		}
	}

	/**
	 * This method removes a volunteer from the hospital volunteer records.
	 * @param volunteer of type Volunteer object (already initialized) specifies which volunteer to remove from the hospital records.
	 * @return of Boolean type. Returns true if the volunteer has successfully been removed from the hospital records, and false otherwise.
	 * @throws NoVolunteersException is thrown when there are no other available volunteers remaining after the removal of the specified volunteer. There must always be at least 1 volunteer available at all times.
	 */
	public Boolean resignVolunteer(Volunteer volunteer) throws NoVolunteersException {

		if (this.volList.size() == 1) {
			throw new NoVolunteersException();
		} else if (this.volList.contains(volunteer) == true) {
			for (int i = 0; i < this.volList.size(); i++) {
				if (this.volList.get(i) == volunteer) {
					this.volList.remove(i);
				}
			}

			for (int i = 0; i < this.physList.size(); i++) {
				for (int j = 0; j < this.physList.get(i).volL.size(); j++) {
					if (this.physList.get(i).volL.get(j) == volunteer) {
						this.physList.get(i).volL.remove(j);
					}
				}
			}

			return true;
		} else {
			return false;
		}
	}

	/**
	 * This method returns a sorted list/record of all volunteer records within the hospital.
	 * @return of type List<Volunteer> is a sorted list/record of all volunteer records within the hospital.
	 */
	public List<Volunteer> extractAllVolunteerDetails() {

		return this.volList;
	}

}

/**
 * This class contains all people associated within the hospital and creates an outline of all required attributes for its associated subclasses.
 * @author Mouiz Ahmed
 *
 */
abstract class Person {

	protected String first;
	protected String last;
	protected int age;
	protected String gender;
	protected String address;
	protected String specialty;
	protected Physician physician;

	protected static int patientIDs = 999;

	/**
	 * This method sets the patient ID of a new patient starting at 1000. It adds one each time this method is called.
	 * @return of type int contains the patient ID of the last patient added.
	 */
	protected int setPatientID() {
		return this.patientIDs + 1;
	}

}

/**
 * This is a subclass of Person which includes all employees of the hospital.
 * @author Mouiz_Ahmed
 *
 */
class Employee extends Person {

	protected static int employeeIDs = 99;
	protected double salary = 0.0;

	/**
	 * This method sets the employee ID of a new employee starting at 100. It adds one each time this method is called.
	 * @return of type int contains the patient ID of the last patient added.
	 */
	protected int setEmployeeID() {
		return this.employeeIDs + 1;

	}

}

/**
 * This is a subclass of Employee which includes all volunteers of the hospital.
 * @author Mouiz_Ahmed
 *
 */
class Volunteer extends Employee {

	protected int volunteerID;

	/**
	 * This method initializes all attributes of the Volunteer object.
	 * @param first of type String represents the volunteer's first name.
	 * @param last of type String represents the volunteer's last name.
	 * @param age of type int represents the volunteer's age.
	 * @param gender of type String represents the volunteer's gender.
	 * @param address of type String represents the volunteer's address.
	 */
	public Volunteer(String first, String last, int age, String gender, String address) {
		// TODO Auto-generated constructor stub
		this.first = first;
		this.last = last;
		this.age = age;
		this.gender = gender;
		this.address = address;
		Employee.employeeIDs = setEmployeeID();
	}

	/**
	 * This method gets the full name of the volunteer.
	 * @return of type String combines the first and last name of the volunteer separated by a comma.
	 */
	public String getName() {
		String name = first + ", " + last;
		return name;
	}

	/**
	 * This method includes all attributes of a volunteer.
	 * @return of type string combines all attributes of a volunteer into a readable format.
	 */
	public String toString() {

		// Volunteer [[435,[Arnold, Jason, 45, Male, Danforth]]]
		return "Volunteer [[" + Employee.employeeIDs + ",[" + this.getName() + ", " + this.age + ", " + this.gender
				+ ", " + this.address + "]]]";

	}

	/**
	 * This method returns the address of the volunteer.
	 * @return of type String contains the address of the volunteer.
	 */
	public String getAddress() {

		return this.address;
	}

	/**
	 * This method returns the age of the volunteer.
	 * @return of type int contains the age of the volunteer.
	 */
	public int getAge() {

		return this.age;
	}

	/**
	 * This method initializes the address of the volunteer.
	 * @param address of type String is used to initialize the instance variable address of type String.
	 */
	public void setAddress(String address) {

		this.address = address;
	}

	/**
	 * This method initializes the first name of the volunteer.
	 * @param first of type String is used to initialize the instance variable first of type String.
	 */
	public void setFirstName(String first) {

		this.first = first;

	}

	/**
	 * This method initializes the last name of the volunteer.
	 * @param last of type String is used to initialize the instance variable last of type String.
	 */
	public void setLastName(String last) {

		this.last = last;

	}

	/**
	 * This method initializes the gender of the volunteer.
	 * @param gender of type String is used to initialize the instance variable gender of type String.
	 */
	public void setGender(String gender) {

		this.gender = gender;

	}

	/**
	 * This method initializes the age of the volunteer.
	 * @param age of type int is used to initialize the instance variable age of type int.
	 */
	public void setAge(int age) {

		this.age = age;

	}

}

/**
 * This class is a subclass of Employee which contains attributes of all salaried employees.
 * @author Mouiz Ahmed
 *
 */
class SalariedEmployee extends Employee {

}

/**
 * This class is a subclass of SalariedEmployee which contains attributes of all administrators.
 * @author Mouiz Ahmed
 *
 */
class Administrator extends SalariedEmployee {

	protected List<PhysicianAdministrator> list = new ArrayList<PhysicianAdministrator>();
}

/**
 * This class is a subclass of Administrator which contains all Physician Administrators.
 * @author Mouiz Ahmed
 *
 */
class PhysicianAdministrator extends Administrator {
	protected List<Physician> list2 = new ArrayList<Physician>();

	/**
	 * This constructor initializes all attributes of a Physician Administrator.
	 * @param first of type String represents the first name of Physician Administrator.
	 * @param last of type String represents the last name of Physician Administrator.
	 * @param age of type int represents the age of Physician Administrator.
	 * @param gender of type String represents the gender of Physician Administrator.
	 * @param address of type String represents the address of Physician Administrator.
	 */
	public PhysicianAdministrator(String first, String last, int age, String gender, String address) {
		// TODO Auto-generated constructor stub
		this.first = first;
		this.last = last;
		this.age = age;
		this.gender = gender;
		this.address = address;
		Employee.employeeIDs = setEmployeeID();
	}

	/**
	 * This method adds a physician under this instance of Physician Administrator.
	 * @param physician of type Physician object is used to specify which physician is to be assigned.
	 */
	public void assignPhysician(Physician physician) {

		if (specialty == physician.specialty) {
			list2.add(physician);
			// Collections.sort(list2);
		}

	}

	/**
	 * This method initializes the specialty of the Physician Admin. 
	 * @param specialty of type String represents the specialty type of the Physician Admin.
	 * @throws IllegalArumentException is thrown when a type other than Immunology, Neurology or Dermatology is entered.
	 */
	public void setAdminSpecialtyType(String specialty) {

		if (specialty == "Immunology" || specialty == "Neurology" || specialty == "Dermatology") {
			this.specialty = specialty;
		} else {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * This method returns the specialty type of the Physician Admin.
	 * @return of type String represents the specialty type of the Physician Admin.
	 */
	public String getAdminSpecialtyType() {

		return this.specialty;
	}

	/**
	 * This method combines the first and last name separated by a comma of the Physician Admin.
	 * @return of type String contains the full name of the of the Physician Admin separated by a comma.
	 */
	public String getName() {

		String name = this.first + ", " + this.last;
		return name;
	}

	/**
	 * This method returns the gender of the Physician Admin.
	 * @return of type String represents the gender of the Physician Admin.
	 */
	public String getGender() {

		return this.gender;
	}

	/**
	 * This method returns the age of the Physician Admin.
	 * @return of type int represents the age of the Physician Admin.
	 */
	protected int getAge() {

		return this.age;
	}

	/**
	 * This method returns the address of the Physician Admin.
	 * @return of type String represents the address of the Physician Admin.
	 */
	protected String getAddress() {

		return this.address;
	}

	/**
	 * 
	 * @return
	 */
	protected int getEmployeeID() {

		return Employee.employeeIDs;
	}

	/**
	 * 
	 * @param salary
	 */
	protected void setSalary(double salary) {

		this.salary = salary;

	}

	/**
	 * 
	 * @return
	 */
	public double getSalary() {

		return this.salary;
	}

	/**
	 * 
	 */
	public String toString() {

		// PysicianAdministrator [[[109,[Elizabeth, Smith, 53, Female, Lawrence Avenue
		// East]], 4521.0], Immunology]
		return "PysicianAdministrator [[[" + Employee.employeeIDs + ",[" + this.getName() + ", " + this.age + ", "
				+ this.gender + ", " + this.address + "]], " + this.salary + "], " + this.specialty + "]";

	}

	/**
	 * 
	 * @return
	 */
	public List<Physician> extractPhysician() {
		Collections.sort(list2, new Comparator<Physician>() {

			@Override
			public int compare(Physician o1, Physician o2) {
				// TODO Auto-generated method stub
				return o1.getName().compareTo(o2.getName());
			}

		});
		return list2;
	}

}

/**
 * 
 * @author Mouiz_Ahmed
 *
 */
class Director extends Administrator {

	/**
	 * 
	 * @param first
	 * @param last
	 * @param age
	 * @param gender
	 * @param address
	 */
	public Director(String first, String last, int age, String gender, String address) {
		this.first = first;
		this.last = last;
		this.age = age;
		this.gender = gender;
		this.address = address;
		Employee.employeeIDs = setEmployeeID(); // THIS CALLS IT TWICE. Dihfdfkljghrdfk

	}

	/**
	 * 
	 * @param admin1
	 * @return
	 */
	public Boolean assignAdministrator(PhysicianAdministrator admin1) {

		if (this.list.size() <= 2) {
			this.list.add(admin1);

			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * @return
	 */
	public List<PhysicianAdministrator> extractPhysicianAdmins() {

		return this.list;
	}

}

/**
 * 
 * @author Mouiz_Ahmed
 *
 */
class Physician extends SalariedEmployee implements Comparator<Physician> {

	List<Patient> patL = new ArrayList<Patient>();
	List<Volunteer> volL = new ArrayList<Volunteer>();

	/**
	 * 
	 * @param first
	 * @param last
	 * @param age
	 * @param gender
	 * @param address
	 */
	public Physician(String first, String last, int age, String gender, String address) {
		// TODO Auto-generated constructor stub
		this.first = first;
		this.last = last;
		this.age = age;
		this.gender = gender;
		this.address = address;
		Employee.employeeIDs = setEmployeeID();
	}

	/**
	 * 
	 * @param volunteer
	 */
	public void assignVolunteerHire(Volunteer volunteer) {

		volL.add(volunteer);

	}

	/**
	 * 
	 */
	public void removeAll() {

		patL.removeAll(patL);
		volL.removeAll(volL);

	}

	/**
	 * 
	 * @return
	 */
	public String getName() {

		String name = this.first + ", " + this.last;
		return name;
	}

	/**
	 * 
	 * @return
	 */
	public String getGender() {

		return this.gender;
	}

	/**
	 * 
	 * @return
	 */
	public int getAge() {

		return this.age;
	}

	/**
	 * 
	 * @return
	 */
	public String getAddress() {

		return this.address;
	}

	/**
	 * 
	 * @return
	 */
	public int getEmployeeID() {

		return Employee.employeeIDs;
	}

	/**
	 * 
	 */
	public String toString() {

		// Physician [[[137,[Ryan, Mark, 35, Male, Canlish Road]], 0.0]]
		return "Physician [[[" + Employee.employeeIDs + ",[" + this.getName() + ", " + this.age + ", " + this.gender
				+ ", " + this.address + "]], " + this.salary + "]]";

	}

	/**
	 * 
	 * @param salary
	 */
	public void setSalary(double salary) {

		this.salary = salary;

	}

	/**
	 * 
	 * @param first
	 */
	public void setFirstName(String first) {

		this.first = first;

	}

	/**
	 * 
	 * @param specialty
	 */
	public void setSpecialty(String specialty) {

		if (specialty == "Immunology" || specialty == "Neurology" || specialty == "Dermatology") {
			this.specialty = specialty;
		} else {
			throw new IllegalArgumentException();
		}

	}

	/**
	 * 
	 * @return
	 */
	public Object getSpecialty() {

		return this.specialty;
	}

	/**
	 * 
	 * @param last
	 */
	public void setLastName(String last) {

		this.last = last;

	}

	/**
	 * 
	 * @param address
	 */
	public void setAddress(String address) {

		this.address = address;

	}

	/**
	 * 
	 * @param age
	 */
	public void setAge(int age) {

		this.age = age;

	}

	/**
	 * 
	 * @param gender
	 */
	public void setGender(String gender) {

		this.gender = gender;
	}

	/**
	 * 
	 * @param patient
	 */
	public void assignPatient(Patient patient) {
		patL.add(patient);
		// Collections.sort(patL, Physician.);
	}

	/**
	 * 
	 * @return
	 */
	public List<Patient> extractPatientDetail() {
		Collections.sort(patL, new Comparator<Patient>() {

			@Override
			public int compare(Patient o1, Patient o2) {
				// TODO Auto-generated method stub
				return o1.getName().compareTo(o2.getName());
			}

		});
		return this.patL;
	}

	/**
	 * 
	 * @return
	 */
	public List<Volunteer> extractValunterDetail() {

		return this.volL;
	}

	/**
	 * 
	 * @param volunteer
	 * @return
	 */
	public Boolean assignVolunteer(Employee volunteer) {

		if (this.volL.contains(volunteer) == false && this.volL.size() < 5) {
			this.volL.add((Volunteer) volunteer);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * @return
	 */
	public Boolean hasMaxVolunteers() {

		if (this.volL.size() == 5) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * @return
	 */
	public Boolean hasMaximumpatient() {

		if (this.patL.size() == 8) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int compare(Physician o1, Physician o2) {
		// TODO Auto-generated method stub
		return o1.getName().compareTo(o2.getName());
	}

}

/**
 * 
 * @author Mouiz_Ahmed
 *
 */
class Patient extends Person implements Comparator<Patient> {

	/**
	 * 
	 * @param first
	 * @param last
	 * @param age
	 * @param gender
	 * @param address
	 */
	public Patient(String first, String last, int age, String gender, String address) {
		// TODO Auto-generated constructor stub
		this.first = first;
		this.last = last;
		this.age = age;
		this.gender = gender;
		this.address = address;
		Person.patientIDs = setPatientID();
	}

	/**
	 * 
	 * @return
	 */
	public String getName() {
		String name = first + ", " + last;
		return name;
	}

	/**
	 * 
	 */
	public String toString() {

		// Patient [1000, [Nicolas, Jason, 25, Male, Belfield]]
		return "Patient [" + patientIDs + ", [" + this.getName() + ", " + this.age + ", " + this.gender + ", "
				+ this.address + "]]";
	}

	/**
	 * 
	 * @return
	 */
	public String getAddress() {

		return this.address;
	}

	/**
	 * 
	 * @return
	 */
	public int getAge() {

		return this.age;
	}

	/**
	 * 
	 * @param address
	 */
	public void setAddress(String address) {

		this.address = address;
	}

	/**
	 * 
	 * @param first
	 */
	public void setFirstName(String first) {

		this.first = first;
	}

	/**
	 * 
	 * @param last
	 */
	public void setLastName(String last) {

		this.last = last;
	}

	/**
	 * 
	 * @param age
	 */
	public void setAge(int age) {

		this.age = age;
	}

	/**
	 * 
	 * @param gender
	 */
	public void setGender(String gender) {

		this.gender = gender;
	}

	/**
	 * 
	 * @return
	 */
	public String getGender() {

		return this.gender;
	}

	/**
	 * 
	 * @return
	 */
	public Integer getPatientID() {

		return Person.patientIDs;
	}

	/**
	 * 
	 * @return
	 */
	public Physician getAssignedPhysician() {

		return this.physician;
	}

	/**
	 * 
	 * @return
	 */
	public Boolean clearPatientRecord() {

		if (this.physician == null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * @param physician
	 */
	public void setAssignedPhysician(Physician physician) {

		this.physician = physician;

	}

	@Override
	public int compare(Patient o1, Patient o2) {
		// TODO Auto-generated method stub
		return o1.getName().compareTo(o2.getName());
	}

}

/**
 * 
 * @author Mouiz_Ahmed
 *
 */
class NoSpecialtyException extends Exception {
	public NoSpecialtyException() {

	}
}

/**
 * 
 * @author Mouiz_Ahmed
 *
 */
class NoSpaceException extends Exception {
	public NoSpaceException() {

	}
}

/**
 * 
 * @author Mouiz_Ahmed
 *
 */
class NoVolunteersException extends Exception {
	public NoVolunteersException() {

	}
}
