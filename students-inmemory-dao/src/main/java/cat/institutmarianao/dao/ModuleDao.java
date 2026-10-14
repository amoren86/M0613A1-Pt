package cat.institutmarianao.dao;

import java.util.List;

import cat.institutmarianao.model.Module;
import jakarta.ejb.Local;

@Local
public interface ModuleDao {

	Module findByPk(String moduleCode, String cycleCode) throws Exception;

	List<Module> findAllByCycleCode(String cycleCode) throws Exception;
}
