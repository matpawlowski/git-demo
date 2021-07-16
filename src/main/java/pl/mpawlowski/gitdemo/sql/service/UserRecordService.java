package pl.mpawlowski.gitdemo.sql.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mpawlowski.gitdemo.sql.model.UserRecord;

import javax.persistence.EntityExistsException;
import javax.persistence.OptimisticLockException;

@Service
public class UserRecordService {

    @Autowired
    private SessionFactory sessionFactory;

    public void InsertLoginOrIncrementCounter(String login){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        UserRecord userRecord = session.get(UserRecord.class,login);
        if(userRecord==null)
        try {
            UserRecord newUserRecord = new UserRecord(login);
            session.persist(newUserRecord);
            transaction.commit();
        }
        catch(EntityExistsException e){
            userRecord = session.get(UserRecord.class,login);
        }finally {
            session.close();
        }
        if(userRecord != null) {
            while (true) {
                try {
                    session = sessionFactory.openSession();
                    userRecord = session.get(UserRecord.class,login);
                    transaction = session.beginTransaction();
                    userRecord.incrementRequestCount();
                    session.save(userRecord);
                    transaction.commit();
                    break;
                } catch (OptimisticLockException e){
                    e.printStackTrace();
                }finally{
                    session.close();
                }
            }
        }
    }
}
