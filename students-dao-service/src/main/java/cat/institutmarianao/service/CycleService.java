package cat.institutmarianao.service;

import java.util.List;

import cat.institutmarianao.model.Cycle;
import jakarta.ejb.Local;

@Local
public interface CycleService {

	List<Cycle> findAll() throws Exception;
}
