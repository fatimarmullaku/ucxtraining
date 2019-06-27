package com.ucx.domainexercise.service;

import com.ucx.domainexercise.domain.Costumer;
import com.ucx.domainexercise.domain.Invoice;
import com.ucx.domainexercise.domain.LineItem;
import com.ucx.domainexercise.repository.DuplicateFoundException;

import java.util.List;

public interface InvoiceService {

    Invoice generateInvoice(List<LineItem> lineItemList, Costumer costumer) throws DuplicateFoundException;
    Invoice printInvoice(Integer id);
}
