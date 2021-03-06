package spring.masterclass.sages.common.web;

import org.javamoney.moneta.FastMoney;
import org.mapstruct.Mapper;
import spring.masterclass.sages.payments.LocalMoney;

@Mapper(componentModel = "spring")
public interface FastMoneyMapper {

    default FastMoney toFastMoney(String price) {
        if (price == null) {
            return LocalMoney.of(0);
        }
        return FastMoney.parse(price);
    }

    default String toPrice(FastMoney price) {
        if (price == null) {
            return "";
        }
        return price.toString();
    }

}