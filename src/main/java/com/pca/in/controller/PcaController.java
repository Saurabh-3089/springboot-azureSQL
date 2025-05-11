package com.pca.in.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.pca.in.entity.PCA;
import com.pca.in.entity.PcaInfo;
import com.pca.in.service.PcaService;

@Controller
@RequestMapping("/product/catalog")
public class PcaController {
	
	@Autowired
	PcaService productService;
	
	@GetMapping("/")
	public ModelAndView home() {
		ModelAndView mView = new ModelAndView();
		mView.setViewName("index");
		return mView;
	}
	
	@GetMapping("/loadAddProduct")
	public ModelAndView loadAddProductPage() {
		ModelAndView mView = new ModelAndView();
		mView.setViewName("addProduct");
		return mView;
	}
	
	@GetMapping("/loadListProducts")
	public ModelAndView loadListProductsPage() {
		ModelAndView mView = new ModelAndView();
		mView.setViewName("listProducts");
		return mView;
	}
	
	@PostMapping("/api/v1/create/product")
	public ResponseEntity<String> addProduct(@RequestBody PCA pc) {
		System.out.println("Entered Add Product Controller: " + pc.toString());

		String message = productService.createPC(pc);
		System.out.println("Return response - "+message);
		return ResponseEntity.ok(message);
	}
	
	@GetMapping("/api/v1/products")
	public ResponseEntity<ArrayList<PCA>> getProductList(){
		System.out.println("Entered List Products Controller: ");
		ArrayList<PCA> productLists = productService.getPC();
		System.out.println("productLists - "+productLists);
		return ResponseEntity.ok(productLists);
	}
	
	@GetMapping("/api/v1/product/{pid}")
	public PCA getProductByID(@PathVariable int pid) {
		return productService.getPcID(pid);
	}
	
	@PutMapping("/api/v1/update/product/{pid}")
	public PCA updateProductById(@PathVariable int pid, @RequestBody PcaInfo pc) throws Exception {
		return productService.updatePC(pc, pid);
	}
	
	@DeleteMapping("/api/v1/delete/product/{pid}")
	public ResponseEntity<String> deleteProductById(int pid){
		productService.deleteProduct(pid);
		return new ResponseEntity<String>("Product is deleted successfully", HttpStatus.OK);
	}
	

}
