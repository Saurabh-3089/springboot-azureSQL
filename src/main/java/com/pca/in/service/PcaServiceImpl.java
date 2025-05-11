package com.pca.in.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pca.in.entity.PCA;
import com.pca.in.entity.PcaInfo;
import com.pca.in.repository.PcaRepository;

@Service
public class PcaServiceImpl implements PcaService {
	
	@Autowired
	PcaRepository repo;
	
	public String createPC(PCA pc) {
		System.out.println("Entered PCA Service create Product");
		PCA productInfo = repo.save(pc);
		System.out.println("PCA saved -"+productInfo);
		if(productInfo != null) {
			return "Product - "+pc.getProductName()+" added successfully";
		}
		return "Failed to add Product - "+pc.getProductName();
	}
	
	public ArrayList<PCA> getPC() {
		return (ArrayList<PCA>) repo.findAll();
	}

	
	public PCA getPcID(int id) {
		return repo.findById(id).orElse(null);
	}

	
	public PCA updatePC(PcaInfo pc, int id) throws Exception {
		PCA oldProduct = repo.findById(id).orElse(null);
		Optional<PCA> searchedProduct = Optional.ofNullable(oldProduct);
		if(searchedProduct.isPresent()) {
			PCA fetchedProduct = searchedProduct.get();
			fetchedProduct.setPid(pc.getPid());
			fetchedProduct.setPrice(pc.getPrice());
			fetchedProduct.setQty(pc.getQty());
			fetchedProduct.setDescription(pc.getDescription());
			repo.save(fetchedProduct);
			return fetchedProduct;
		}else {
			throw new Exception("Product not found");
		}
			
	}

	@Override
	public void deleteProduct(int pid) {
		repo.deleteById(pid);
	}
}
