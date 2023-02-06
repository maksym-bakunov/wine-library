package mate.team2.winelibrary.service;

import java.util.Optional;
import mate.team2.winelibrary.model.PaymentType;

public interface PaymentTypeService {
   PaymentType findById(Integer id);
}
