package pokramovich.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pokramovich.domain.dao.AddressDao;
import pokramovich.domain.pojo.Address;

/**
 * Created by Pokramovich on 26.08.2016.
 */
@Service
public class AddressServiceImpl implements AddressService {
    private final  AddressDao addressDao;

    @Autowired
    public AddressServiceImpl(AddressDao addressDao) {
        this.addressDao = addressDao;
    }

    @Override
    @Transactional
    public Address saveAddress(Address address) {
        return addressDao.save(address);
    }
}
