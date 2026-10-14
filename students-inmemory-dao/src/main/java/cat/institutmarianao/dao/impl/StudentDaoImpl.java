package cat.institutmarianao.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import cat.institutmarianao.dao.StudentDao;
import cat.institutmarianao.model.Student;
import jakarta.annotation.security.DeclareRoles;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ejb.Stateless;

@DeclareRoles({ "admin" })
@Stateless
public class StudentDaoImpl implements StudentDao {

	private Map<String, Student> students = new ConcurrentHashMap<>();

	@PermitAll
	@Override
	public Student findByPk(String dni) throws Exception {
		return students.get(dni);
	}

	@PermitAll
	@Override
	public List<Student> findAll() throws Exception {
		return new ArrayList<>(students.values());
	}

	@RolesAllowed({ "admin" })
	@Override
	public Student add(Student student) throws Exception {
		students.put(student.getDni(), student);
		return student;
	}

	@RolesAllowed({ "admin" })
	@Override
	public void remove(Student student) throws Exception {
		removeByDni(student.getDni());
	}

	@RolesAllowed({ "admin" })
	@Override
	public void removeByDni(String dni) throws Exception {
		students.remove(dni);
	}

}
