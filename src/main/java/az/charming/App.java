package az.charming;

import az.charming.connect.MySQLConnect;
import az.charming.entity.StudentEntity;
import az.charming.repository.StudentRepository;

import java.math.BigDecimal;

/**
 * Hello world!
 *
 */
public class App 
{

    private static StudentRepository studentRepository = new StudentRepository();

    public static void main(String[] args) {


        StudentEntity ss= new StudentEntity();
        ss.setName("Araz");
        ss.setSurname("Mahmudov");
        ss.setAge(45);
        ss.setScholarship(BigDecimal.valueOf(100));
        studentRepository.insert(ss);

        System.out.println(studentRepository.getAll());



}}
