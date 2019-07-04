package com.ucx.domainexercise.service;

import com.ucx.domainexercise.entity.Costumer;
import com.ucx.shop.storage.DuplicateFoundException;
import com.ucx.shop.storage.RecordStatus;
import org.junit.Test;
import static org.junit.Assert.*;

public class CostumerServiceUnitTestSuite {

    private CostumerService costumerService = CostumerServiceImpl.getInstance();

    @Test
    public void testCreate(){
        try {
            Costumer costumer = costumerService.create(new Costumer(1, "Filani", RecordStatus.ACTIVE));
            assertNotNull(costumer);
            assertEquals(Integer.valueOf(1), costumer.getId());
        } catch (DuplicateFoundException e) {
            e.printStackTrace();
        }
    }
}
