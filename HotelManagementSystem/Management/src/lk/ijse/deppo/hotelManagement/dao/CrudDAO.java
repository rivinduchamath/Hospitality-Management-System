package lk.ijse.deppo.hotelManagement.dao;

import lk.ijse.deppo.hotelManagement.entity.Reservation;
import lk.ijse.deppo.hotelManagement.entity.SuperEntity;

import java.util.List;

public interface CrudDAO<T extends SuperEntity,ID> extends SuperDAO {

    T find(ID key) throws Exception;

    List<Reservation> findAll() throws Exception;

     boolean save(T entity) throws Exception;

    boolean update(T entity) throws Exception;

    boolean delete(ID key) throws Exception;
    boolean delete2(ID key) throws Exception;

}
