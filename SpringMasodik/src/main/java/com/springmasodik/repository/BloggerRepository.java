package com.springmasodik.repository;

import org.springframework.data.repository.CrudRepository;
import com.springmasodik.domain.Blogger;


/*Az osztályt és az id adattípusát kell megadni*/
public interface BloggerRepository extends CrudRepository<Blogger, Long> {

}
