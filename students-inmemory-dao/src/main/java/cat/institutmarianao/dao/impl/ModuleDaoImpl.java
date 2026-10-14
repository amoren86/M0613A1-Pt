package cat.institutmarianao.dao.impl;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import cat.institutmarianao.dao.ModuleDao;
import cat.institutmarianao.model.Cycle;
import cat.institutmarianao.model.Module;
import jakarta.annotation.security.DeclareRoles;
import jakarta.annotation.security.PermitAll;
import jakarta.ejb.Stateless;

@DeclareRoles({ "admin" })
@Stateless
public class ModuleDaoImpl implements ModuleDao {

	private static final int MODULE_CODE = 0;
	private static final int MODULE_CYCLE_CODE = 1;
	private static final int MODULE_NAME = 2;

	private static final String[][] modulesData = { { "0369", "ASIX", "Implantació de sistemes operatius" },
			{ "0370", "ASIX", "Planificació i administració de xarxes" }, { "0371", "ASIX", "Fonaments de maquinari" },
			{ "0372", "ASIX", "Gestió de bases de dades" },
			{ "0373", "ASIX", "Llenguatges de marques i sistemes de gestió d'informació" },
			{ "0374", "ASIX", "Administració de sistemes operatius" },
			{ "0375", "ASIX", "Serveis de xarxa i Internet" }, { "0376", "ASIX", "Implantació d'aplicacions web" },
			{ "0377", "ASIX", "Administració de sistemes gestors de bases de dades" },
			{ "0378", "ASIX", "Seguretat i alta disponibilitat" }, { "0179", "ASIX", "Anglès professional" },
			{ "1665", "ASIX", "Digitalització aplicada als sectors productius" },
			{ "1708", "ASIX", "Sostenibilitat aplicada al sistema productiu" },
			{ "1709", "ASIX", "Itinerari personal per a l'ocupabilitat I" },
			{ "1710", "ASIX", "Itinerari personal per a l'ocupabilitat II" },
			{ "0379", "ASIX", "Projecte intermodular de desenvolupament d'aplicacions multiplataforma" },

			{ "0373", "DAM", "Llenguatges de marques i sistemes de gestió d'informació" },
			{ "0483", "DAM", "Sistemes informàtics" }, { "0484", "DAM", "Bases de dades" },
			{ "0485", "DAM", "Programació" }, { "0486", "DAM", "Accés a dades" },
			{ "0487", "DAM", "Entorns de desenvolupament" }, { "0488", "DAM", "Desenvolupament d'interfícies" },
			{ "0489", "DAM", "Programació multimèdia i dispositius mòbils" },
			{ "0490", "DAM", "Programació de serveis i processos" },
			{ "0491", "DAM", "Sistemes de gestió empresarial" }, { "0179", "DAM", "Anglès professional" },
			{ "1665", "DAM", "Digitalització aplicada als sectors productius" },
			{ "1708", "DAM", "Sostenibilitat aplicada al sistema productiu" },
			{ "1709", "DAM", "Itinerari personal per a l'ocupabilitat I" },
			{ "1710", "DAM", "Itinerari personal per a l'ocupabilitat II" },
			{ "0492", "DAM", "Projecte intermodular de desenvolupament d'aplicacions multiplataforma" },

			{ "0373", "DAW", "Llenguatges de marques i sistemes de gestió d'informació" },
			{ "0483", "DAW", "Sistemes informàtics" }, { "0484", "DAW", "Bases de dades" },
			{ "0485", "DAW", "Programació" }, { "0487", "DAW", "Entorns de desenvolupament" },
			{ "0612", "DAW", "Desenvolupament web en entorn client" },
			{ "0613", "DAW", "Desenvolupament web en entorn servidor" },
			{ "0614", "DAW", "Desplegament d'aplicacions web" }, { "0615", "DAW", "Disseny d'interfícies web" },
			{ "0179", "DAW", "Anglès professional" },
			{ "1665", "DAW", "Digitalització aplicada als sectors productius" },
			{ "1708", "DAW", "Sostenibilitat aplicada al sistema productiu" },
			{ "1709", "DAW", "Itinerari personal per a l'ocupabilitat I" },
			{ "1710", "DAW", "Itinerari personal per a l'ocupabilitat II" },
			{ "0492", "DAW", "Projecte intermodular de desenvolupament d'aplicacions multiplataforma" } };

	protected Map<String, Map<String, Module>> modules = new ConcurrentHashMap<>();

	public ModuleDaoImpl() {
		for (String[] element : modulesData) {
			try {
				Module module = new Module();
				module.setCode(element[MODULE_CODE]);

				Cycle cycle = new CycleDaoImpl().findAll().stream()
						.filter(c -> c.getCode().equals(element[MODULE_CYCLE_CODE])).findFirst()
						.orElseThrow(() -> new RuntimeException("Cycle not found"));

				module.setCycleCode(cycle.getCode());
				module.setName(element[MODULE_NAME]);

				if (!modules.containsKey(module.getCycleCode())) {
					modules.put(module.getCycleCode(), new java.util.HashMap<>());
				}
				modules.get(module.getCycleCode()).put(module.getCode(), module);
			} catch (Exception e) {
				// DO NOTHING, SIMPLY IGNORE THE MODULE IF THE CYCLE IS NOT FOUND
			}
		}

	}

	@PermitAll
	@Override
	public Module findByPk(String moduleCode, String cycleCode) throws Exception {
		return modules.get(cycleCode).get(moduleCode);
	}

	@PermitAll
	@Override
	public List<Module> findAllByCycleCode(String cycleCode) throws Exception {
		return modules.get(cycleCode).values().stream().sorted(Comparator.comparing(Module::getCode))
				.collect(Collectors.toList());
	}

}
