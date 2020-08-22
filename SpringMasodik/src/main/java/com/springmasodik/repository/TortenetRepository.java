package com.springmasodik.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.springmasodik.domain.Tortenet;

public interface TortenetRepository extends CrudRepository<Tortenet, Long>{

	/*A crudrepo findAll functionja egy Iterable típust ad vissza, de nekünk List kell, ezért a reponkban felül tudjuk írni, hogy mivel térjen vissza, mivel 
	 * az list rangsorban alatta található, konrétabb megfogalmazás*/
	List<Tortenet> findAll();

}
