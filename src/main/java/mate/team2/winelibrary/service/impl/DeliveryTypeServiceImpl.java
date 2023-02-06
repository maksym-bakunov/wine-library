package mate.team2.winelibrary.service.impl;

import mate.team2.winelibrary.exception.AppEntityNotFoundException;
import mate.team2.winelibrary.model.DeliveryType;
import mate.team2.winelibrary.repository.DeliveryTypeRepository;
import mate.team2.winelibrary.service.DeliveryTypeService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeliveryTypeServiceImpl implements DeliveryTypeService {
    DeliveryTypeRepository deliveryTypeRepository;

    public DeliveryTypeServiceImpl(DeliveryTypeRepository deliveryTypeRepository) {
        this.deliveryTypeRepository = deliveryTypeRepository;
    }

    @Override
    public DeliveryType findById(Integer id) {
        return deliveryTypeRepository.findById(id)
                .orElseThrow(() -> new AppEntityNotFoundException(id));
    }
}
