package com.pca.in.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pca.in.entity.PCA;

@Repository
public interface PcaRepository extends JpaRepository<PCA,Integer> {

}
