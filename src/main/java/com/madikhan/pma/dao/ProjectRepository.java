package com.madikhan.pma.dao;



import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.madikhan.pma.dto.ChartData;
import com.madikhan.pma.entities.Project;

public interface ProjectRepository extends CrudRepository<Project, Long> {


	@Override
	public List<Project> findAll();
	
	@Query(nativeQuery=true, value="SELECT stage AS label, COUNT(*) AS value "
			+ "FROM project "
			+ "GROUP BY stage")
	public List<ChartData> getProjectStatus();
}
