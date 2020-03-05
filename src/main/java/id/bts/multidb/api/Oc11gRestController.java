package id.bts.multidb.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import id.bts.multidb.localdb.domains.DbaDataFilesDTO;
import id.bts.multidb.localdb.domains.DbaSegmentsDTO;
import id.bts.multidb.localdb.domains.TableSpaceDTO;
import id.bts.multidb.localdb.repositories.DynamicTabSpaceRepo;

@RestController
public class Oc11gRestController {
	
	@Autowired
	@Qualifier("tableSpace_jdbcTemplate")
	private DynamicTabSpaceRepo tableSpaceRepository;
	
	@GetMapping("/used")
	@ResponseStatus(code = HttpStatus.OK)
	public List<TableSpaceDTO> getAllUser() {
		return tableSpaceRepository.getAllTableSpace();
	}
	
	@GetMapping("/totalspace")
	@ResponseStatus(code = HttpStatus.OK)
	public List<DbaDataFilesDTO> getTotalSpaces() {
		return tableSpaceRepository.getTotalSpace();
	}
	
	@GetMapping("/usedspace")
	@ResponseStatus(code = HttpStatus.OK)
	public List<DbaSegmentsDTO> getUsedSpaces() {
		return tableSpaceRepository.getUsedSpace();
	}
}
