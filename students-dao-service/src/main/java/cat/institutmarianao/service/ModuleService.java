package cat.institutmarianao.service;

import java.util.List;

import cat.institutmarianao.model.Module;
import jakarta.ejb.Local;

@Local
public interface ModuleService {

	Module findByPk(String moduleCode, String cycleCode) throws Exception;

	List<Module> findAllByCycleCode(String cycleCode) throws Exception;
}
