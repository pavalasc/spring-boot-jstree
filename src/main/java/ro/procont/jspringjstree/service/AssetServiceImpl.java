package ro.procont.jspringjstree.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.procont.jspringjstree.model.Asset;
import ro.procont.jspringjstree.repos.AssetRepository;

@Service
public class AssetServiceImpl implements AssetService{
	
	@Autowired
	private AssetRepository assetRepository;

	@Override
	public List<Asset> findAll() {
		// TODO Auto-generated method stub
		return assetRepository.findAll();
	}

}