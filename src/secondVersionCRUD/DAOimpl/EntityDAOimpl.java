package secondVersionCRUD.DAOimpl;

import secondVersionCRUD.DAO.EntityDAO;
import secondVersionCRUD.Model.Entity;

import java.sql.*;
import java.util.LinkedHashSet;
import java.util.Set;

public class EntityDAOimpl implements EntityDAO {

    private Connection connection;

    public EntityDAOimpl(Connection connection) {
        this.connection = connection;
    }


    @Override
    public Set<Entity> getAllEntities() {

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM contacts ORDER BY id ASC");

            Set<Entity> entities = new LinkedHashSet<>();

            while (rs.next()) {
                Entity entity = extractEntityFromResultSet(rs);
                entities.add(entity);
            }

            return entities;

        } catch (SQLException ex) {
            throw new RuntimeException("Selecting statement error!", ex);
        }
    }

    @Override
    public boolean insertEntity(Entity entity) {
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement("INSERT INTO contacts(ime, prezime, email, broj_telefona, grad, drzava) VALUES (?,?,?,?,?,?)");
            ps.setString(1, entity.getIme());
            ps.setString(2, entity.getPrezime());
            ps.setString(3, entity.getEmail());
            ps.setString(4, entity.getBrojTelefona());
            ps.setString(5, entity.getGrad());
            ps.setString(6, entity.getDrzava());

            ps.execute();

            return true;


        } catch (SQLException ex) {
            System.out.printf("Insert failed! %s", ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean updateEntity(Entity entity) {
        PreparedStatement ps;
        try {

            ps = connection.prepareStatement("UPDATE contacts set ime = ?, prezime = ?, email = ?, broj_telefona = ?, grad = ?, drzava = ? WHERE id = ?");

            ps.setString(1, entity.getIme());
            ps.setString(2, entity.getPrezime());
            ps.setString(3, entity.getEmail());
            ps.setString(4, entity.getBrojTelefona());
            ps.setString(5, entity.getGrad());
            ps.setString(6, entity.getDrzava());
            ps.setInt(7, entity.getId());

            ps.execute();

            return true;

        } catch (SQLException ex) {
            System.out.printf("Update failed! %s", ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean deleteEntity(String id) {
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("DELETE FROM contacts WHERE id=" + id);
            return true;
        } catch (SQLException ex) {
            System.out.printf("Delete failed! %s", ex.getMessage());
        }
        return false;
    }

    @Override
    public Entity extractEntityFromResultSet(ResultSet rs) throws SQLException {
        Entity entity = new Entity();

        entity.setId(rs.getInt("id"));
        entity.setIme(rs.getString("ime"));
        entity.setPrezime(rs.getString("prezime"));
        entity.setEmail(rs.getString("email"));
        entity.setBrojTelefona(rs.getString("broj_telefona"));
        entity.setGrad(rs.getString("grad"));
        entity.setDrzava(rs.getString("drzava"));

        return entity;
    }
}
