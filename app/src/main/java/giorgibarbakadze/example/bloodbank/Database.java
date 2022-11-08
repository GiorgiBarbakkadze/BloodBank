package giorgibarbakadze.example.bloodbank;


import androidx.room.RoomDatabase;

@androidx.room.Database(entities = {Donor.class}, version = 1)
public abstract class Database extends RoomDatabase {
    public abstract DonorDao donorDao();
}
