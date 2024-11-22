package jdbc;

import java.util.*;

public class Main {
   public static void main(String[] args) {
	   UserDAO userDAO = new UserDAOImpl();
	   User user = new User();

	   // 1. Create a new user
       User newUser = new User( "Virat", "Virat@gmail.com", "1as", 99231,"BTM");
      userDAO.addUser(newUser);
       
       

//       // 2. Get a user by ID
//       User userGet = userDAO.getUserById(2);  
//      if (userGet != null) {
//           System.out.println("User: " +userGet.getName() + ", " + userGet.getEmail());
//     }

	   
	   
	   
      // 3. Get all users
//       List<User> users = userDAO.getAllUsers();
//      System.out.println("All Users:");
//   for (User u : users) {
//      System.out.println(u.getId() +" "+u.getName() + " - " + u.getEmail()+" "+ u.getPassword() +" "+u.getPassword());
//    }
	   
	   
//
//       // 4. Update a user
//       if (user != null) {
//    	   user.setId(1);
//           user.setName("John Smith");
//          user.setEmail("john.smith@example.com");
//           user.setPassword("newpassword456");
//           user.setPhoneNo(987654321);
//           userDAO.updateUser(user);
//     }
//	   
	   
//
//       // 5. Delete a user
    //userDAO.deleteUser(1);  // Assuming ID 1 exists
   }
}
