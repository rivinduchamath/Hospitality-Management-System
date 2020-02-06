package lk.ijse.deppo.hotelManagement.business.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.deppo.hotelManagement.business.custom.BanquetBO;
import lk.ijse.deppo.hotelManagement.dao.DAOFactory;
import lk.ijse.deppo.hotelManagement.dao.DAOTypes;
import lk.ijse.deppo.hotelManagement.dao.custom.BanquetDAO;
import lk.ijse.deppo.hotelManagement.dto.BanqetDTO;
import lk.ijse.deppo.hotelManagement.entity.Banquet;
import lk.ijse.deppo.hotelManagement.util.BanquetTM;

import java.util.ArrayList;
import java.util.List;

public class BanquetBOImpl implements BanquetBO {
    BanquetDAO banquetDAO =
            DAOFactory.getInstance().getDAO
                    (DAOTypes.BANQUET);

}
