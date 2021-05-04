package spring.masterclass.sages.orders;

import lombok.Data;
import spring.masterclass.sages.common.web.IdTransferObject;

import java.util.List;

@Data
public class OrderTransferObject {

    private List<IdTransferObject> products;

}