package launch;

import util.DBManager;

import java.sql.Connection;

public final class Lab1 {
    public static void main(String[] args) {
        final DBManager dbManager = DBManager.getInstance();
        final Connection connection = dbManager.getConnection(false);
        dbManager.deleteDatabase();
        dbManager.initializeDatabase();
    }
}
