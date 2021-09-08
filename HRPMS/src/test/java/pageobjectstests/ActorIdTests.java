package pageobjectstests;

import databaseUtilities.DbUtilities;
import org.testng.annotations.Test;
import pageobjects.ActorId;

import java.sql.SQLException;

public class ActorIdTests extends DbUtilities {
    ActorId actorID = null;

    @Test
    public void test() throws SQLException {
        actorID.connectPostgresql();
    }
}
