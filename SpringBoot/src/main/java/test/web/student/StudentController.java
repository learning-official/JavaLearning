package test.web.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController{

    @Autowired
    private StudentService studentService;

    @GetMapping("/jdbc/{id}")
    public ResponseEntity<?> query(@PathVariable Integer id){
        try{
            List<Student> student = studentService.getById(id);
            if (!student.isEmpty()){
                return ResponseEntity.status(200).body(student.getFirst());
            }else{
                return ResponseEntity.status(404).body("Student ID : " + id + " Not Found");
            }
        }catch (Exception e){
            return ResponseEntity.status(500).body("Internal Service Error");
        }
    }

    @PostMapping("/jdbc")
    public ResponseEntity<String> insert(@RequestBody Student student){
        try{
            studentService.setByStudent(student);
            return ResponseEntity.status(201).body("INSERT Passed");
        }catch (Exception e){
            if (e.getMessage().contains("Duplicate entry")){
                return ResponseEntity.status(400).body("Error : Student id " + student.getId() + " already exits.");
            }else{
                return ResponseEntity.status(500).body("Internal Server Error");
            }
        }
    }

    @PutMapping("/jdbc")
    public ResponseEntity<String> update(@RequestBody Student student){
        try{
            int length = studentService.updateByStudent(student);
            if (length > 0){
                return ResponseEntity.ok("UPDATE Passed");
            }else{
                return ResponseEntity.status(404).body("UPDATE Failed");
            }
        }catch (Exception e){
            if (e.getMessage().contains("Duplicate entry")){
                return ResponseEntity.status(400).body("Error : Student id " + student.getId() + " already exits.");
            }else{
                return ResponseEntity.status(500).body("Internal Server Error");
            }
        }
    }

    @DeleteMapping("jdbc/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){
        try{
            int length = studentService.deleteById(id);
            if (length > 0){
                return ResponseEntity.status(200).body("DELETE Passed");
            }else{
                return ResponseEntity.status(404).body("DELETE Failed");
            }
        }catch (Exception e){
            return ResponseEntity.status(500).body("Internal Server Error");
        }
    }

    // Transcational！！！！！！！！
    // Transcational！！！！！！！！
    // Transcational！！！！！！！！
    // Transcational！！！！！！！！
    // Transcational！！！！！！！！
    // Transcational！！！！！！！！
}
