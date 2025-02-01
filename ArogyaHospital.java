import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class ArogyaPatient {
    private long patientId;
    private String name;
    private int age;
    private String gender;
    private String aadharNumber;
    private String contactNumber;
    private String city;
    private String address;
    private String dateOfAdmission;
    private String guardianName;
    private String guardianAddress;
    private String guardianContactNumber;
    private boolean recovered;

    public ArogyaPatient(long patientId, String name, int age, String gender, String aadharNumber, String contactNumber,
            String city, String address, String dateOfAdmission, String guardianName, String guardianAddress,
            String guardianContactNumber) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.aadharNumber = aadharNumber;
        this.contactNumber = contactNumber;
        this.city = city;
        this.address = address;
        this.dateOfAdmission = dateOfAdmission;
        this.guardianName = guardianName;
        this.guardianAddress = guardianAddress;
        this.guardianContactNumber = guardianContactNumber;
        this.recovered = false;
    }

    public long getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getAadharNumber() {
        return aadharNumber;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public String getDateOfAdmission() {
        return dateOfAdmission;
    }

    public String getGuardianName() {
        return guardianName;
    }

    public String getGuardianAddress() {
        return guardianAddress;
    }

    public String getGuardianContactNumber() {
        return guardianContactNumber;
    }

    public boolean isRecovered() {
        return recovered;
    }

    public void setRecovered(boolean recovered) {
        this.recovered = recovered;
    }
}

public class ArogyaHospital {
    private Scanner sc;
    private ArrayList<ArogyaPatient> patientList;
    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public ArogyaHospital() {
        sc = new Scanner(System.in);
        patientList = new ArrayList<>();
    }

    public void addPatient() {
        System.out.print("Enter Patient ID: ");
        long id = sc.nextLong();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Gender: ");
        String gender = sc.nextLine();

        String aadharNumber;
        while (true) {
            System.out.print("Enter Aadhar Number : ");
            aadharNumber = sc.nextLine();
            if (aadharNumber.matches("\\d{12}"))
                break;
            System.out.println("Invalid Aadhar! Must be exactly 12 digits.");
        }

        String contactNumber;
        while (true) {
            System.out.print("Enter Contact Number : ");
            contactNumber = sc.nextLine();
            if (contactNumber.matches("\\d{10}"))
                break;
            System.out.println("Invalid Contact! Must be exactly 10 digits.");
        }

        System.out.print("Enter City: ");
        String city = sc.nextLine();

        System.out.print("Enter Address: ");
        String address = sc.nextLine();

        String dateOfAdmission = LocalDate.now().format(dateFormatter);
        System.out.println("Date of Admission: " + dateOfAdmission);

        System.out.print("Enter Guardian Name: ");
        String guardianName = sc.nextLine();

        System.out.print("Enter Guardian Address: ");
        String guardianAddress = sc.nextLine();

        String guardianContactNumber;
        while (true) {
            System.out.print("Enter Guardian Contact Number: ");
            guardianContactNumber = sc.nextLine();
            if (guardianContactNumber.matches("\\d{10}"))
                break;
            System.out.println("Invalid Contact! Must be exactly 10 digits.");
        }

        patientList.add(new ArogyaPatient(id, name, age, gender, aadharNumber, contactNumber,
                city, address, dateOfAdmission, guardianName, guardianAddress, guardianContactNumber));
        System.out.println("Patient added successfully!");
    }

    public void viewAllPatients() {
        for (ArogyaPatient patient : patientList) {
            System.out.println("Patient ID: " + patient.getPatientId() + ", Name: " + patient.getName());
        }
    }

    public void searchById() {
        System.out.print("Enter Patient ID: ");
        long id = sc.nextLong();
        for (ArogyaPatient patient : patientList) {
            if (patient.getPatientId() == id) {
                System.out.println("\n---------- Patient Details ----------");
                System.out.println("Patient ID:        " + patient.getPatientId());
                System.out.println("Name:              " + patient.getName());
                System.out.println("Age:               " + patient.getAge());
                System.out.println("Gender:            " + patient.getGender());
                System.out.println("Aadhar Number:     " + patient.getAadharNumber());
                System.out.println("Contact Number:    " + patient.getContactNumber());
                System.out.println("City:              " + patient.getCity());
                System.out.println("Address:           " + patient.getAddress());
                System.out.println("Date of Admission: " + patient.getDateOfAdmission());
                System.out.println("Guardian Name:     " + patient.getGuardianName());
                System.out.println("Guardian Address:  " + patient.getGuardianAddress());
                System.out.println("Guardian Contact:  " + patient.getGuardianContactNumber());
                System.out.println("Recovery Status:   " + (patient.isRecovered() ? "Recovered" : "Under Treatment"));
                System.out.println("-------------------------------------");
                return;
            }
        }
        System.out.println("Patient not found with ID: " + id);
    }

    public void searchByCity() {
        System.out.print("Enter City: ");
        sc.nextLine();
        String city = sc.nextLine();
        System.out.println("Patients from " + city + ":");
        for (ArogyaPatient patient : patientList) {
            if (patient.getCity().equalsIgnoreCase(city)) {
                System.out.println("- " + patient.getName() + " (ID: " + patient.getPatientId() + ")");
            }
        }
    }

    public void searchByAgeGroup() {
        System.out.print("Enter Age Range (Min Max): ");
        int min = sc.nextInt();
        int max = sc.nextInt();
        System.out.println("Patients between " + min + " and " + max + " years:");
        for (ArogyaPatient patient : patientList) {
            if (patient.getAge() >= min && patient.getAge() <= max) {
                System.out.println("- " + patient.getName() + " (Age: " + patient.getAge() + ", ID: "
                        + patient.getPatientId() + ")");
            }
        }
    }

    public void viewRecoveredPatients() {
        System.out.println("\nList of Recovered Patients:");
        boolean found = false;
        for (ArogyaPatient patient : patientList) {
            if (patient.isRecovered()) {
                System.out.println("- " + patient.getName() + " (ID: " + patient.getPatientId() + ")");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No recovered patients found.");
        }
    }

    public void viewNotRecoveredPatients() {
        System.out.println("\nList of Patients Under Treatment:");
        boolean found = false;
        for (ArogyaPatient patient : patientList) {
            if (!patient.isRecovered()) {
                System.out.println("- " + patient.getName() + " (ID: " + patient.getPatientId() + ")");
                found = true;
            }
        }
        if (!found) {
            System.out.println("All patients have recovered.");
        }
    }

    public void markRecovery() {
        System.out.print("Enter Patient ID to mark recovery: ");
        long id = sc.nextLong();
        for (ArogyaPatient patient : patientList) {
            if (patient.getPatientId() == id) {
                patient.setRecovered(true);
                System.out.println("Patient " + patient.getName() + " marked as recovered");
                return;
            }
        }
        System.out.println("Patient not found with ID: " + id);
    }

    public void deletePatient() {
        System.out.print("Enter Patient ID to delete: ");
        long id = sc.nextLong();
        if (patientList.removeIf(patient -> patient.getPatientId() == id)) {
            System.out.println("Patient record deleted successfully");
        } else {
            System.out.println("No patient found with ID: " + id);
        }
    }

    public void viewOptions() {

        while (true) {
            System.out.println("\n===========================================================");
            System.out.println("        AROGYA HOSPITAL MANAGEMENT SYSTEM");
            System.out.println("===========================================================");
            System.out.println("1. Add New Patient");
            System.out.println("2. View All Patients");
            System.out.println("3. Search Patient by ID");
            System.out.println("4. Search Patients by City");
            System.out.println("5. Search Patients by Age Group");
            System.out.println("6. View Recovered Patients");
            System.out.println("7. View Not Recovered Patients");
            System.out.println("8. Mark Patient Recovery");
            System.out.println("9. Delete Patient Record");
            System.out.println("0. Exit");
            System.out.println("===========================================================");
            System.out.print("Enter your choice: ");
            int option = sc.nextInt();
            System.out.println("===========================================================");
            switch (option) {
                case 1:
                    addPatient();
                    break;
                case 2:
                    viewAllPatients();
                    break;
                case 3:
                    searchById();
                    break;
                case 4:
                    searchByCity();
                    break;
                case 5:
                    searchByAgeGroup();
                    break;
                case 6:
                    viewRecoveredPatients();
                    break;
                case 7:
                    viewNotRecoveredPatients();
                    break;
                case 8:
                    markRecovery();
                    break;
                case 9:
                    deletePatient();
                    break;
                case 0:
                    System.out.println("Thank you for using Arogya Hospital System Application. Have a nice day!");
                    return;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        new ArogyaHospital().viewOptions();
    }
}
