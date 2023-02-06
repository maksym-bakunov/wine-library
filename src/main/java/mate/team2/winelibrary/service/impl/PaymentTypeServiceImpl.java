package mate.team2.winelibrary.service.impl;

import mate.team2.winelibrary.exception.AppEntityNotFoundException;
import mate.team2.winelibrary.model.PaymentType;
import mate.team2.winelibrary.repository.PaymentTypeRepository;
import mate.team2.winelibrary.service.PaymentTypeService;
import org.springframework.stereotype.Service;

@Service
public class PaymentTypeServiceImpl implements PaymentTypeService {
    private final PaymentTypeRepository paymentTypeRepository;

    public PaymentTypeServiceImpl(PaymentTypeRepository paymentTypeRepository) {
        this.paymentTypeRepository = paymentTypeRepository;
    }

    @Override
    public PaymentType findById(Integer id) {
        return paymentTypeRepository.findById(id)
                .orElseThrow(() -> new AppEntityNotFoundException(id));
    }
}
