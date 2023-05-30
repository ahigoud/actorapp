package com.pentagon.app;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		try {
			SessionFactory factory = new Configuration().configure().buildSessionFactory();

			int ch = 0;
			Scanner sc1 = new Scanner(System.in);
			Scanner sc2 = new Scanner(System.in);
			while (ch != 5) {
				System.out.println("press 1 to create actor");
				System.out.println("press 2 to list actor");
				System.out.println("press 3 to update actor");
				System.out.println("press 4 to delete actor");
				System.out.println("press 5 to exit ........");
				ch = sc1.nextInt();
				switch (ch) {
				case 1:
					System.out.println("Creating actor..........");
					System.out.println("enter the actor name : ");
					String name = sc2.nextLine();
					System.out.println("enter the actor gender : ");
					String gender = sc2.nextLine();
					System.out.println("enter the actor dob : ");
					String dob = sc2.nextLine();
					System.out.println("enter the actor famous dialogue : ");
					String fd = sc2.nextLine();
					Actor a1 = new Actor(name, gender, dob, fd);
					Session s = factory.openSession();
					s.beginTransaction();
					Long i = (Long) s.save(a1);
					s.getTransaction().commit();
					s.close();
					
					break;
					
					
				case 2:
					System.out.println("listing actor..........");
					Session s3=factory.openSession();
					s3.beginTransaction();
					List<Actor> actors=s3.createQuery("from Actor").getResultList();
					for(Actor x:actors)
						System.out.println("name  =   "+x.getName()+"    gender  =  "+x.getGender()+"  dob=  "+x.getDob()+"  fd=  "+x.getFd());
					
					s3.getTransaction().commit();
					s3.close();
					
					break;
					
					
				case 3:
					System.out.println("updating actor..........");
					System.out.println("enter the id of the actor");
					Long id=sc1.nextLong();
					Session s2=factory.openSession();
					s2.beginTransaction();
					Actor a2=s2.get(Actor.class, id);
					System.out.println("enter the change of dialogue");
					String dia=sc2.nextLine();
					a2.setFd(dia);
					System.out.println("enter the change of dob");
					String d=sc2.nextLine();
					a2.setDob(d);
					System.out.println("enter the change of name");
					String nm=sc2.nextLine();
					a2.setName(nm);
					System.out.println("enter the change of gender");
					String gen=sc2.nextLine();
					a2.setGender(gen);
					s2.getTransaction().commit();
					s2.close();
					
					break;
				case 4:
					System.out.println("deleting actor..........");
					System.out.println("enter the id of the actor");
					Long id1=sc1.nextLong();
					Session s4=factory.openSession();
					s4.beginTransaction();
					Actor a3=s4.get(Actor.class, id1);
					s4.delete(a3);
					s4.getTransaction().commit();
					s4.close();
					break;
				case 5:
					System.out.println("tata bye bye..........");
					break;
				}
				factory.close();

			}

			
		} catch (Throwable t) {
			t.printStackTrace();
		}

	}
}
