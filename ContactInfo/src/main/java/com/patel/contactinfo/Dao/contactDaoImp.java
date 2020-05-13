package com.patel.contactinfo.Dao;




import com.patel.contactinfo.Dao.contactDao;
import com.patel.contactinfo.model.Contact;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author DELL
 */
public class contactDaoImp implements contactDao{

    private  JdbcTemplate jdbctemplate;
    
    public contactDaoImp(DataSource ds){
        this.jdbctemplate = new JdbcTemplate(ds);
    }
    
    @Override
    public int save(Contact c) {
        String sql = "INSERT INTO contact (name,email,address,phone) VALUES (?,?,?,?)";
        return jdbctemplate.update(sql,c.getName(),c.getEmail(),c.getAddress(),c.getPhone());
    }

    @Override
    public int update(Contact c) {
        String sql = "UPDATE contact SET name=?, email=?, address=?, phone=? WHERE contact_id=?";
        return jdbctemplate.update(sql,c.getName(),c.getEmail(),c.getAddress(),c.getPhone(),c.getId());
    }

    @Override
    public Contact getContact(final int id) {
        String sql = "SELECT * FROM contact WHERE contact_id="+id;
        ResultSetExtractor<Contact> extractor = new ResultSetExtractor<Contact>() {
            @Override
            public Contact extractData(ResultSet rs) throws SQLException, DataAccessException {
                if(rs.next()){
                    String name = rs.getString("name");
                    String email = rs.getString("email");
                    String address = rs.getString("address");
                    String phone = rs.getString("phone");
                    return new Contact(id,name,email,address,phone);
                }
                return null;
            }
        };
        return jdbctemplate.query(sql,extractor);
    }

    @Override
    public int delete(int id) {
        String sql = "DELETE FROM contact WHERE contact_id="+id;
        return jdbctemplate.update(sql);
    }

    @Override
    public List<Contact> list() {
       String sql = "SELECT * FROM contact";
        RowMapper<Contact> row = new RowMapper<Contact>() {
           @Override
           public Contact mapRow(ResultSet rs, int rawNum) throws SQLException {
                    int id = rs.getInt("contact_id");
                    String name = rs.getString("name");
                    String email = rs.getString("email");
                    String address = rs.getString("address");
                    String phone = rs.getString("phone");
                    return new Contact(id,name,email,address,phone);
           }
       };
        return jdbctemplate.query(sql, row);
    }
    
}
