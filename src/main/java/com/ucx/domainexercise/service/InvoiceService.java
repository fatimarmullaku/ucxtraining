package com.ucx.domainexercise.service;

import com.ucx.domainexercise.entity.Costumer;
import com.ucx.domainexercise.entity.Invoice;
import com.ucx.domainexercise.entity.LineItem;
import com.ucx.domainexercise.repository.DuplicateFoundException;

import java.util.List;

public interface InvoiceService {

    Invoice createInvoice(List<LineItem> lineItemList, Costumer costumer) throws DuplicateFoundException;
    Invoice printInvoice(Integer id);
}
