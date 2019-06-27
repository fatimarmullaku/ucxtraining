package com.ucx.domainexercise.repository;

import com.ucx.domainexercise.domain.*;

import java.util.ArrayList;
import java.util.List;

public class StorageServiceImpl<T extends BaseModel<U>, U> implements StorageService<T, U> {

    //    List<LineItem> listOfItmes = new ArrayList<>();
//    Costumer costumer = new Costumer("Filani");
    private final List<T> list = new ArrayList<>();

    @Override
    public T find(U id) {
        if (id == null) {
            throw new RuntimeException("Cannot find Object, ID is missing");
        }
        T t = null;

        for (T element :
                list) {
            if (element.getID().equals(id)) {
                t = element;
                break;
            }
        }

        return t;
    }

    @Override
    public void update(T t) {
        int index = -1;
        if(t == null){
            throw new RuntimeException("Element cannot be null");
        }
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getID().equals(t.getID())){
                index = i;
                break;
            }
        }
        if(index == -1){
            throw new RuntimeException("Element couldn't be found");
        }

        list.set(index, t);
    }

    @Override
    public void remove(T t) {
        if (t == null) {
            throw new RuntimeException("Element cannot be null");

        }
        list.remove(t);
    }

    @Override
    public T save(T t) {
        if (t == null){
            throw new RuntimeException("Element cannot be null");
        }
        if(find(t.getID()) != null){
            throw new RuntimeException("Element already exists");
        }
            list.add(t);
            return t;
    }


//    @Override
//    public LineItem buy(Product product) {
//        List<LineItem> returnList = new ArrayList<>();
//        Costumer costumer = new Costumer("Filani");
//
//        Invoice invoice = new Invoice(1, costumer, returnList);
//
//        return new LineItem(invoice, product, 0, 0);
//    }
//
//    @Override
//    public Invoice generateInvoice(List<LineItem> list, Costumer costumer) {
//        List<LineItem> returnList = new ArrayList<>();
//
//        return null;
//    }


}
