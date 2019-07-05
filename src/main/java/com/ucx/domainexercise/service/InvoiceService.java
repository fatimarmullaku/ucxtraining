package com.ucx.domainexercise.service;

import com.ucx.domainexercise.entity.Costumer;
import com.ucx.domainexercise.entity.Invoice;
import com.ucx.domainexercise.entity.LineItem;
import com.ucx.shop.storage.DuplicateFoundException;

import java.util.List;

/**
 * This Interface defines operations related to Invoice.
 */
public interface InvoiceService {

    Invoice create(List<LineItem> lineItemList, Costumer costumer) throws DuplicateFoundException;
    Invoice print(Integer id);
}
