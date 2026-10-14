package cat.institutmarianao.service.impl;

import java.util.List;

import cat.institutmarianao.dao.StudentDao;
import cat.institutmarianao.model.Student;
import cat.institutmarianao.service.StudentService;
import jakarta.annotation.security.DeclareRoles;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

@DeclareRoles({ "admin" })
@Stateless
public class StudentServiceImpl implements StudentService {

	@EJB
	private StudentDao studentDao;

	@PermitAll
	@Override
	public Student findByPk(String dni) throws Exception {
		return studentDao.findByPk(dni);
	}

	@PermitAll
	@Override
	public List<Student> findAll() throws Exception {
		return studentDao.findAll();
	}

	@RolesAllowed({ "admin" })
	@Override
	public Student add(Student student) throws Exception {
		return studentDao.add(student);
	}

	@RolesAllowed({ "admin" })
	@Override
	public void remove(Student student) throws Exception {
		studentDao.remove(student);
	}

	@RolesAllowed({ "admin" })
	@Override
	public void removeByDni(String dni) throws Exception {
		studentDao.removeByDni(dni);
	}

}
