package com.sidhu.SpringJDBCPostgresql.repo;

import com.sidhu.SpringJDBCPostgresql.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {

    private JdbcTemplate jdbc;

    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void save(Student s){
//        System.out.println("Save");
        String sql = "INSERT INTO public.\"Student\" (id, name, marks) VALUES (?,?,?)";
        int rowsAffected = jdbc.update(sql, s.getId(),s.getName(),s.getMarks());
        System.out.println(rowsAffected);
    }


    public List<Student> findAll() {
//        List<Student> students = new ArrayList<Student>();
//        return students;

        String sql = "SELECT * FROM public.\"Student\"";

        RowMapper<Student> mapper = new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {

                Student s = new Student();
                s.setId(rs.getInt("ID"));
                s.setName(rs.getString("Name"));
                s.setMarks(rs.getInt("Marks"));

                return s;
            }
        };
        return jdbc.query(sql,mapper);
    }

}
