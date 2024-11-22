# UserDAO Class

The **UserDAO** (Data Access Object) class is responsible for managing database operations related to the `User` entity. It provides methods for performing CRUD (Create, Read, Update, Delete) operations on user data, such as inserting new users, fetching user details, updating user information, and deleting users. The class uses JDBC (Java Database Connectivity) to interact with a relational database.

## Methods

### 1. **insert(User user)**
Inserts a new user into the database.

**Parameters**:  
- `user` (User): The user object containing user details (name, email, password, phone number).

### 2. **fetchAll()**
Retrieves all users from the database.

**Returns**:  
- `List<User>`: A list of `User` objects representing all users in the database.

### 3. **fetchSpecificId(int id)**
Fetches a user from the database based on their ID.

**Parameters**:  
- `id` (int): The unique ID of the user.

**Returns**:  
- `User`: The user object with the specified ID, or `null` if no user is found.

### 4. **update(User user)**
Updates the details of an existing user in the database.

**Parameters**:  
- `user` (User): The user object containing updated details.

### 5. **delete(int id)**
Deletes a user from the database based on their ID.

**Parameters**:  
- `id` (int): The unique ID of the user to be deleted.

## Requirements

- **Java**: 8 or later
- **JDBC**: For database connectivity
- **Database**: MySQL (or any relational database)

## Setup

1. Clone this repository:
   ```bash
   git clone https://github.com/Mohamed-Jameer/User-DAO.git
