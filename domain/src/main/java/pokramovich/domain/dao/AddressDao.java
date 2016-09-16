package pokramovich.domain.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pokramovich.domain.pojo.Address;

/**
 * Created by Pokramovich on 26.08.2016.
 */
@Repository
public interface AddressDao extends CrudRepository<Address, Integer> {
}
