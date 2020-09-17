package ro.procont.jspringjstree.service;

import java.util.List;

import javax.validation.Valid;

import ro.procont.jspringjstree.model.Asset;


public interface AssetService {
	
	List<Asset> findAll();

	Asset findById(int id);

	void save(@Valid Asset asset);

	void delete(Asset asset);

}
