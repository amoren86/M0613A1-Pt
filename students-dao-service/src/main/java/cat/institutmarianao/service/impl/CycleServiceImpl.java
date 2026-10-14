package cat.institutmarianao.service.impl;

import java.util.List;

import cat.institutmarianao.dao.CycleDao;
import cat.institutmarianao.model.Cycle;
import cat.institutmarianao.service.CycleService;
import jakarta.annotation.security.DeclareRoles;
import jakarta.annotation.security.PermitAll;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

@DeclareRoles({ "admin" })
@Stateless
public class CycleServiceImpl implements CycleService {

	@EJB
	private CycleDao cycleDao;

	@PermitAll
	@Override
	public List<Cycle> findAll() throws Exception {
		return cycleDao.findAll();
	}
}
