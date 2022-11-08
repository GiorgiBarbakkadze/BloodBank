package giorgibarbakadze.example.bloodbank;

import androidx.room.Dao;
import androidx.room.Insert;

@Dao
public interface DonorDao {

    @Insert
    void insert(Donor donor);
}
