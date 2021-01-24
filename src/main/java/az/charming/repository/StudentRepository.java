package az.charming.repository;

import az.charming.connect.MySQLConnect;
import az.charming.entity.StudentEntity;
import com.mysql.cj.xdevapi.PreparableStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {

    public void insert(StudentEntity student) {

        try (Connection connection = MySQLConnect.connect()) {
            PreparedStatement preparableStatement = connection.prepareStatement("insert into student(name,surname,age,scholarship) values(?,?,?,?)");
            preparableStatement.setString(1, student.getName());
            preparableStatement.setString(2, student.getSurname());
            preparableStatement.setInt(3, student.getAge());
            preparableStatement.setBigDecimal(4, student.getScholarship());
            preparableStatement.execute();
        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }


    public void update(StudentEntity student) {

        try (Connection connection = MySQLConnect.connect()) {
            PreparedStatement preparableStatement = connection.prepareStatement(" update student" +
                    "set name=?,surname=?,age=?,scholarship=?");
            preparableStatement.setString(1, student.getName());
            preparableStatement.setString(2, student.getSurname());
            preparableStatement.setInt(3, student.getAge());
            preparableStatement.setBigDecimal(4, student.getScholarship());
            preparableStatement.execute();
        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }

    public void delete(Integer id) {
        try (Connection connection = MySQLConnect.connect()) {
            System.out.println(connection.getClass().getName());
            PreparedStatement preparedStatement = connection.prepareStatement("delete from student where id=?");
            System.out.println(preparedStatement.getClass().getName());
            preparedStatement.setInt(1,id);
            preparedStatement.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

      public List <StudentEntity> getAll() {
        List<StudentEntity> list = new ArrayList<>();
        try (Connection connection = MySQLConnect.connect()) {
            PreparedStatement stmt = connection.prepareStatement("select * from student");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) list.add(fromResultSet(rs));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    private StudentEntity fromResultSet(ResultSet rs) throws Exception{
        StudentEntity s=new StudentEntity();
        s.setId(rs.getInt("id"));
        s.setName(rs.getString("name"));
        s.setSurname(rs.getString("surname"));
        s.setAge(rs.getInt("age"));
        s.setScholarship(rs.getBigDecimal("scholarship"));
        return s;
    }

    public  StudentEntity  findById (int  id){
        try(Connection connection= MySQLConnect.connect()){
           PreparedStatement preparedStatement=connection.prepareStatement("select * from student where id=?");
           preparedStatement.setInt(1,id);
           ResultSet rs =preparedStatement.executeQuery();
           if(rs.next()) return fromResultSet(rs);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return  null;
    }





}

