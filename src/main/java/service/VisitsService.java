package service;

import dao.impl.VisitsDaoImpl;

public class VisitsService {
    public static boolean insert(String username){
        VisitsDaoImpl visitsDao=new VisitsDaoImpl();
        return visitsDao.insertUpdate(username);
    }
    public static int getVisits(){
        VisitsDaoImpl visitsDao=new VisitsDaoImpl();
        return visitsDao.count();
    }
}
