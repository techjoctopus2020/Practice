package com.Joctopus.Hib_Batch.Mappings.OneToMany.Main;

import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Joctopus.Hib_Batch.Mappings.OneToMany.Entity.Cart;
import com.Joctopus.Hib_Batch.Mappings.OneToMany.Entity.Items;
import com.Joctopus.Hib_Batch.Utils.HibernateUtils;

public class OneToManyTest {

	public static void main(String[] args) {

		// Get the session object

		Session session = HibernateUtils.getSession();

		Transaction tx = session.beginTransaction();

		Cart cart = new Cart();

		cart.setName("FruitesCart");

		Items item = new Items("I10", 10, 1, cart);
		Items item1 = new Items("I20", 20, 2, cart);
		Items item2 = new Items("I30", 30, 2, cart);

		HashSet<Items> itemSet = new HashSet<Items>();
		itemSet.add(item);
		itemSet.add(item1);
		itemSet.add(item2);

		cart.setTotal(110);
		cart.setItemSet(itemSet);
		
		
		Cart cart1 = new Cart();

		cart1.setName("VegCart");

		Items item3 = new Items("brinjal", 10, 1, cart1);
		Items item4 = new Items("carrot", 20, 2, cart1);
		Items item5 = new Items("onion", 30, 2, cart1);

		HashSet<Items> itemSet1 = new HashSet<Items>();
		itemSet1.add(item3);
		itemSet1.add(item4);
		itemSet1.add(item5);

		cart1.setTotal(110);
		cart1.setItemSet(itemSet1);

		session.save(cart);
		session.save(cart1);

		tx.commit();

	}

}
