This is spring boot project for employee management.
It provides Restful APIs to perform CRUD operation and filtering.
###Create new employee
**Endpoint:** emp-data/create-emp
**Method:** POST
**RequestBody:** JSON
```json
{
  "name": "Jhon Doe",
  "role": "Developer",
  "salary": 45000
}
``` 
**Description:** Creates a new employee record and saves it to the database.

###Get employee details
**Endpoint:** emp-data/get-emp
**Method:** GET
**Response:**
```json
[
  {
    "id": 1,
    "name": "John Doe",
    "role": "Developer",
    "salary": 45000
  },
  {
    "id": 2,
    "name": "Alice",
    "role": "Manager",
    "salary": 60000
  }
]
```
**Description:** Return a list of all employees from the database.

###Update employee
**Endpoint:** emp-data/update-emp/1
**Method:** PUT
**Request Body:**
```json
{
  "name": "Alice Smith",
  "role": "Manager",
  "salary": 70000
}
```
**Description:** Updates an existing employee’s details by ID.

###Delete employee
**Endpoint:** emp-data/delete-emp/1
**Method:** DELETE
**Response:** 
```json
{
  "message": "Employee with ID 1 deleted successfully"
}
```
**Description:** Delete an employee record by ID.

###Get salary by Stream API filter 
**Endpoint:** emp-data/stream-filter-salary?minSalary=40000&maxSalary=70000
**Method:** GET
**Response:**
```json
[
  {
    "id": 2,
    "name": "Alice",
    "role": "Manager",
    "salary": 60000
  }
]
```
**Example:**'minSalary=20000' and 'maxSalary=70000'.
**Description:** Fetches employees whose salaries fall within the given range using Stream API.

###Get name by Stream API filter
**Endpoint:** emp-data/stream-filter-name?name=K
**Method:** GET
**Response:** 
```json
[
  {
    "id": 3,
    "name": "Kavita",
    "role": "Tester",
    "salary": 35000
  }
]
```
**Example:** If pass 'name=K' it will return all employee details whoes name start with **K**.
**Description:** Fetches employees whose names start with the given character using Stream API.


###Get name by Jpa repository filter
**Endpoint:** emp-data/jpa-repo-name?name=V
**Method:** GET
**Response:**
```json
[
  {
    "id": 4,
    "name": "Vikram",
    "role": "Developer",
    "salary": 50000
  }
]
```

**Description:** Fetches employees whose names start with the given character using JPA Repository.
**Example:**
-If pass 'name=V' it will return all employee details whoes name start with **V**.

###Get salary by jpa repository filter
**Endpoint:** emp-data/jpa-repo-salary?minSalary=35000&maxSalary=50000
**Method:** GET
**Response:**
```json
[
  {
    "id": 5,
    "name": "Ravi",
    "role": "HR",
    "salary": 40000
  }
]
```
**Description:** Fetches employees whose salaries fall within the given range using JPA Repository.
-Pass 'minSalary' and 'maxSalary' as query parameter.
**Example:** 'minSalary=5000' and 'maxSalary=40000'.


