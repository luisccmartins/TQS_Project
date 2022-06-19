package com.uatqs.expressdelivery.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.uatqs.expressdelivery.model.Order;
import com.uatqs.expressdelivery.model.Rider;
import com.uatqs.expressdelivery.model.Store;
import com.uatqs.expressdelivery.repository.OrderRepository;
import com.uatqs.expressdelivery.repository.RiderRepository;
import com.uatqs.expressdelivery.repository.StoreRepository;

@ExtendWith(MockitoExtension.class)
public class ExpressDeliveryServiceTest {

    @InjectMocks
    private ExpressDeliveryService expressDeliveryService;
    
    @Mock(lenient = true)
    private RiderRepository riderRepository;

    @Mock(lenient = true)
    private OrderRepository deliveryRepository;

    @Mock(lenient = true)
    private StoreRepository storeRepository;

    Rider rider, wrongRider;
    Store store;
    Order order1, order2;

    @BeforeEach
    public void setUp(){
        rider = new Rider("Pedro Porro", 990210312, 22, "pedroporrito@expressdelivery.com", "pedro");
        riderRepository.save(rider);
        wrongRider = new Rider("Wrong Rider", 980111222, 10, "wrongRider@expressdelivery.com", "wrong");

    }
    
    @Test
    public void getWrongRider() throws Exception {
        Rider rider = riderRepository.findByEmail("wrongRider@expressdelivery.com");
        assertEquals(null, rider);
        verify(riderRepository,times(1)).findByEmail("wrongRider@expressdelivery.com");
    }

    @Test
    public void getRider() throws Exception {
        Rider rider = riderRepository.findByEmail("pedroporrito@expressdelivery.com");
        assertEquals(null, rider);
        verify(riderRepository,times(1)).findByEmail("pedroporrito@expressdelivery.com");
    }

    
}
