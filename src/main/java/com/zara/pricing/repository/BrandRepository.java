package com.zara.pricing.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zara.pricing.model.Brand;

@Repository
public interface BrandRepository extends CrudRepository<Brand, Long>{

}
