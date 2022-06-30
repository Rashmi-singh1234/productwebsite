package com.library.application.dao;

import java.io.Console;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.library.application.entities.Product;

@Component
public interface Productrepo extends CrudRepository<Product, String> {

	@Query("select p.productCode, p.brand,p.image,p.name, p.status, sum(r.rating)/count(p.productCode) as rating from Product as p left join Review as r on p.productCode=r.productCode group by p.productCode  having p.brand like %:brand% and p.name like %:name% and p.productCode=:code and p.status=true ")
	Iterable<Product> findAllByName(@Param("brand") String brand, @Param("name") String name, @Param("code") String productCode);
	
	
	@Query("from Product where status=false ")
	Iterable<Product> statusProduct();
//	@Query("Select u from Product  u where u.brand like %:brand% and u.name like %:name% and u.productCode=:code" )
//	Iterable<Product> findAllByName(@Param("brand") String brand, @Param("name") String name, @Param("code") String productCode);
	
	@Query("select p.productCode, p.brand,p.image,p.name,p.status, sum(r.rating)/count(p.productCode) as rating from Product as p left join Review as r on p.productCode=r.productCode group by p.productCode  having p.brand like %:brand% and p.name like %:name% and p.status=true")
	Iterable<Product> findAllByName(@Param("brand") String brand, @Param("name") String name);
	
//	@Query("Select u from Product  u where u.brand like %:brand% and u.name like %:name%" )
//	Iterable<Product> findAllByName(@Param("brand") String brand, @Param("name") String name);
}
