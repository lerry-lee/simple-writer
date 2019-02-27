package service;

import dao.impl.VisitsDaoImpl;

public class VisitsService {
    public static boolean insert(String usersign){
        VisitsDaoImpl visitsDao=new VisitsDaoImpl();
        return visitsDao.insertUpdate(usersign);
    }
    public static int getVisits(){
        VisitsDaoImpl visitsDao=new VisitsDaoImpl();
        return visitsDao.count();
    }
}
