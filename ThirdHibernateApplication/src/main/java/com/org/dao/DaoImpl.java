package com.org.dao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import com.org.entity.Student;
import java.util.List;
import jakarta.persistence.Query;

import jakarta.persistence.Persistence;
public class DaoImpl implements Dao {
	EntityManagerFactory ef=  Persistence.createEntityManagerFactory("test1");
	public void retrieveStudentUsingSqlQuery(int id) {
	EntityManager em=ef.createEntityManager();
	///EntityTransaction t1=em.getTransaction();

	//EntityTransaction t2=em.getTransaction();
	try {
	
		Query q1=em.createNativeQuery("select * from student_tbl1 where id>=?",Student.class);
		
		q1.setParameter(1,id);
		System.out.println("result through the Sql query");
		List<Student> ls_sql=q1.getResultList();
		for(Student ls1:ls_sql) {
			System.out.println(ls1);
		}
		
		System.out.println("result througth jpql: ");
		Query q2=em.createQuery("from Student s where s.id>=?1",Student .class);
		q2.setParameter(1,1);
		List<Student> ls_jpql=q1.getResultList();
		for(Student ls2:ls_jpql) {
			System.out.println(ls2);
		}
	
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	finally {
		em.close();
	}
	
		
	}

}
