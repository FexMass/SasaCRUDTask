package secondVersionCRUD.DAO;

import secondVersionCRUD.Model.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

public interface EntityDAO {

    Set<Entity> getAllEntities();

    Entity extractEntityFromResultSet(ResultSet rs) throws SQLException;

    boolean insertEntity(Entity entity);

    boolean updateEntity(Entity entity);

    boolean deleteEntity(String id);
}
