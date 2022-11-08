package giorgibarbakadze.example.bloodbank;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Donor {
    @PrimaryKey (autoGenerate = true)
    public int DId;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo (name = "phone")
    public int phone;

    @ColumnInfo (name = "address")
    public String address;

    @ColumnInfo (name = "blood_type")
    public String bloodType;

    @ColumnInfo (name = "last_donation")
    public String lastDonation;

    @ColumnInfo (name = "frequency")
    public String frequency;

    @ColumnInfo (name = "has_health_problems")
    public int hasHealthProblems;

    @ColumnInfo (name = "health_problem")
    public String healthProblem;

    public int getDId() {
        return DId;
    }

    public void setDId(int DId) {
        this.DId = DId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getLastDonation() {
        return lastDonation;
    }

    public void setLastDonation(String lastDonation) {
        this.lastDonation = lastDonation;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public int getHasHealthProblems() {
        return hasHealthProblems;
    }

    public void setHasHealthProblems(int hasHealthProblems) {
        this.hasHealthProblems = hasHealthProblems;
    }

    public String getHealthProblem() {
        return healthProblem;
    }

    public void setHealthProblem(String healthProblem) {
        this.healthProblem = healthProblem;
    }
}
