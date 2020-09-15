package ro.procont.jspringjstree.service.impl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.procont.jspringjstree.model.Asset;
import ro.procont.jspringjstree.repos.AssetRepository;
import ro.procont.jspringjstree.service.AssetService;

@Service
public class AssetServiceImpl implements AssetService{
	
	@Autowired
	private AssetRepository assetRepository;

	@Override
	public List<Asset> findAll() {
		// TODO Auto-generated method stub
		return assetRepository.findAll();
	}

	@Override
	public Asset findById(int id) {
		// TODO Auto-generated method stub
		return assetRepository.findById(id).get();
	}

	@Override
	public void save(@Valid Asset asset) {
		assetRepository.save(asset);
		
	}

}
