package com.pca.in.service;

import java.util.ArrayList;
import java.util.List;

import com.pca.in.entity.PCA;
import com.pca.in.entity.PcaInfo;


public interface PcaService {

	//create,getproducts, getproductbyname, delete, update
	
	public String createPC(PCA pc);
	public ArrayList<PCA> getPC();
	public PCA getPcID(int pid);
	public PCA updatePC(PcaInfo pc, int pid) throws Exception;
	public void deleteProduct(int pid);
} 
