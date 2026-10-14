package cat.institutmarianao.dao.impl;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import cat.institutmarianao.dao.CycleDao;
import cat.institutmarianao.model.Cycle;
import jakarta.annotation.security.DeclareRoles;
import jakarta.annotation.security.PermitAll;
import jakarta.ejb.Stateless;

@DeclareRoles({ "admin" })
@Stateless
public class CycleDaoImpl implements CycleDao {

	private static final int CYCLE_CODE = 0;
	private static final int CYCLE_NAME = 1;

	private String[][] cyclesData = { { "ASIX", "Administració de Sistemes Informàtics en Xarxa" },
			{ "DAW", "Desenvolupament d'Aplicacions Web" },
			{ "DAM", "Desenvolupament d'Aplicacions Multiplataforma" } };

	protected List<Cycle> cycles = new CopyOnWriteArrayList<>();

	public CycleDaoImpl() {
		for (String[] element : cyclesData) {
			Cycle cycle = new Cycle();
			cycle.setCode(element[CYCLE_CODE]);
			cycle.setName(element[CYCLE_NAME]);
			cycles.add(cycle);
		}
	}

	@PermitAll
	@Override
	public List<Cycle> findAll() throws Exception {
		return cycles;
	}
}
