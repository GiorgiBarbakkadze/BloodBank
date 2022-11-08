package giorgibarbakadze.example.bloodbank;

import android.content.Context;
import androidx.room.Room;

public class DatabaseClient {
    private Context context;
    private static DatabaseClient databaseClient;
    private Database database;

    public DatabaseClient(Context context) {
        this.context = context;
        database = Room.databaseBuilder(context, Database.class, "donors").build();
    }

    public static synchronized DatabaseClient getInstance(Context context) {
        if (databaseClient == null) {
            databaseClient = new DatabaseClient(context);
        }

        return databaseClient;
    }

    public Database getAppDB() {
        return database;
    }
}
