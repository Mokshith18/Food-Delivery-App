package com.food.daoimpl;

import java.util.ArrayList;

import com.food.model.OrderHistory;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//UserDAOImpl user1 = new UserDAOImpl();
//		(int userId, String userName, String password, String email, long phone, String address,
//		String role,LocalTime dateTime, LocalDate lastlogindate)
		
//		User u = new User(1,"Mokshith","Mok@2001","mokshithmd6@gmail.com",7619254597L,"ckm","customer",LocalTime.now(),LocalDate.now());
//		user1.addUser(u);
		
//		User user = user1.getUser(1);
//		System.out.println(user);
//		
//		//user1.updateUser(u);
//		
//		user1.deleteUser(1);
//		
//		User user11 = user1.getUser(1);
//		System.out.println(user11);
		
//		List<User> list = user1.getAllUser();
//		for(User li:list) {
//			System.out.println(li);
//		}
		
		
		//MenuDAOImpl menu = new MenuDAOImpl();
//		int menuId, int restaurantId, String itemName, String description, float price, float rating,
//		boolean isAvailable, String imagePath
		//Menu m = new Menu(3,1,"Veg Pizza","Hot, cheesy pizza loaded with your favorite veggies",299f,4f,true,"menu\\menu5.jpg");
		//menu.addMenu(m);
//		Menu mm = menu.getMenu(3);
//		System.out.println(mm);
//		menu.updateMenu(m);
//		menu.deleteMenu(3);
		
		//RestaurantDAOImpl res = new RestaurantDAOImpl();
		
		
		
//		List<Menu> list = menu.getAllMenusByRestaurant(1);
//		for(Menu li:list) {
//			System.out.println(li);
//		}
		
		
		
		
		
//		Restaurant rest = new Restaurant(2,"KFC", "Chikpete, Bengaluru",7894565681L , 4.4f, "chicken", true,"10" , 4, "lib");
//		res.addRestaurant(rest);
	//	System.out.println(res.getRestaurant(1));
		
		//res.updateRestaurant(rest);
		//res.deleteRestaurant(2);
		//OrderDAOImpl o = new OrderDAOImpl();
//		Order or = new Order(2, 3, 1, null, 238f, "declined", "online");
//		o.addOrder(or);
		//System.out.println(o.getOrder(1));
		//o.updateOrder(or);
		//o.deleteOrder(5);
		
		
		
//		List<Order> list = o.getAllOrder(3);
//		for(Order oo :list) {
//			System.out.println(oo);
//		}
//		OrderItemDAOImpl or = new OrderItemDAOImpl();
//		
//		OrderItem order = new OrderItem(1, 1, 4, 3, 230f);
		
		//or.addOrderItem(order);
		//System.out.println(or.getOrderItem(1));
		//or.updateOrderItem(order);
//		List<OrderItem> list = or.getAllOrderItemByOrder(1);
//		for(OrderItem ord:list) {
//			System.out.println(ord);
//		}
		
		//or.deleteOrderItem(1);
		
		//OrderHistoryDAOImpl oimp = new OrderHistoryDAOImpl();
		//OrderHistory order = new OrderHistory(1, 2, 1, null, 30f, "Delivered");
		//oimp.addOrderHistory(order);
		
		//System.out.println(oimp.getOrderHistory(1));
		
		//oimp.updateOrderHistory(order);
//		List<OrderHistory> list = oimp.getAllOrderHistory(2);
//		for(OrderHistory o:list) {
//			System.out.println(o);
//		}
		//oimp.deleteOrderHistory(1);
		//RestaurantDAOImpl res = new RestaurantDAOImpl();
//		List<Restaurant> r = res.getAllRestaurant();
//		for(Restaurant rr:r) {
//			System.out.println(rr);
//		}
//		Restaurant r= new Restaurant(2, "Burger King", "Nandini layout,Bengaluru", 9779636356L, 3.5f, "Burger", true,null, 7, null);
//		res.addRestaurant(r);		
		OrderHistoryDAOImpl ohd = new OrderHistoryDAOImpl();
		ArrayList<OrderHistory> oh = ohd.getAllOrderHistory(5); 
		
			for(int i=0;i<oh.size();i++){
				System.out.println(oh.get(i).getOrderDate());
				System.out.println(oh.get(i).getStatus());
		
			}
		
		
			}

}
