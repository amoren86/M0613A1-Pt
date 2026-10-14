package cat.institutmarianao.service;

import java.util.List;

import cat.institutmarianao.model.Student;
import jakarta.ejb.Local;

@Local
public interface StudentService {

	Student findByPk(String dni) throws Exception;

	List<Student> findAll() throws Exception;

	Student add(Student student) throws Exception;

	void remove(Student student) throws Exception;

	void removeByDni(String dni) throws Exception;
}