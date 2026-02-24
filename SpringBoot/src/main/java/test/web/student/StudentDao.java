package test.web.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class StudentDao{

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<Student> getById(Integer id){

        String sql = "SELECT id, name FROM student WHERE id = :id";
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);

         return namedParameterJdbcTemplate.query(sql, map, new StudentRowMapper());
    }

    public Integer setByStudent(Student student){

        String sql = "INSERT INTO student(id, name) VALUES (:id, :name)";
        Map<String, Object> map = new HashMap<>();
        map.put("id", student.getId());
        map.put("name", student.getName());

        return namedParameterJdbcTemplate.update(sql, map);
    }

    public Integer updateByStudent(Student student){

        String sql = "UPDATE student SET name = :name WHERE id = :id";

        Map<String, Object> map = new HashMap<>();
        map.put("id", student.getId());
        map.put("name", student.getName());

        return namedParameterJdbcTemplate.update(sql, map);
    }

    public Integer deleteById(Integer id){

        String sql = "DELETE FROM student WHERE id = :id";

        Map<String, Object> map = new HashMap<>();
        map.put("id", id);

        return namedParameterJdbcTemplate.update(sql, map);
    }
}
