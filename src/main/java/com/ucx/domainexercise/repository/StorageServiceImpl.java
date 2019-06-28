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
//            throw new RuntimeException("Cannot find Object, ID is missing");
            throw new IllegalArgumentException("Cannot find Object, ID is missing");
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
    public T update(T t) throws NotFoundException{
        int index = -1;
        if(t == null){
            throw new IllegalArgumentException("Element cannot be null");
        }
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getID().equals(t.getID())){
                index = i;
                break;
            }
        }
        if(index == -1){
            throw new NotFoundException("Element couldn't be found");
        }

        list.set(index, t);
        return find(t.getID());
    }

    @Override
    public void remove(T t) throws NotFoundException{
        if (t == null) {
            throw new IllegalArgumentException("Element cannot be null");
        }
        t.setRecordStatus(RecordStatus.INACTIVE);
        update(t);
    }

    @Override
    public T save(T t) throws DuplicateFoundException{
        if (t == null){
            throw new IllegalArgumentException("Element cannot be null");
        }
        if(find(t.getID()) != null){
            throw new DuplicateFoundException("Element already exists");
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
