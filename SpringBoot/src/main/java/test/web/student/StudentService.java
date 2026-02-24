package test.web.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    public List<Student> getById(Integer id){
        return studentDao.getById(id);
    }

    public Integer setByStudent(Student student){
         return studentDao.setByStudent(student);
    }

    public Integer updateByStudent(Student student){
        return studentDao.updateByStudent(student);
    }

    public Integer deleteById(Integer id){
        return studentDao.deleteById(id);
    }
}
