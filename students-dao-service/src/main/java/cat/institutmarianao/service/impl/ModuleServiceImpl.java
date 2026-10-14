package cat.institutmarianao.service.impl;

import java.util.List;

import cat.institutmarianao.dao.ModuleDao;
import cat.institutmarianao.model.Module;
import cat.institutmarianao.service.ModuleService;
import jakarta.annotation.security.DeclareRoles;
import jakarta.annotation.security.PermitAll;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

@DeclareRoles({ "admin" })
@Stateless
public class ModuleServiceImpl implements ModuleService {

	@EJB
	private ModuleDao moduleDao;

	@PermitAll
	@Override
	public Module findByPk(String moduleCode, String cycleCode) throws Exception {
		return moduleDao.findByPk(moduleCode, cycleCode);
	}

	@PermitAll
	@Override
	public List<Module> findAllByCycleCode(String cycleCode) throws Exception {
		return moduleDao.findAllByCycleCode(cycleCode);
	}

}
