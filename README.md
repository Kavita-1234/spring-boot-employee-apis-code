This is spring boot project for employee management.
It provides Restful APIs to perform CRUD operation and filtering.
###Create new employee
**URL:** http://localhost:8080/emp-data/create-emp
**Method:** POST
**RequestBody:** JSON
```json
{
  "name": "Jhon Doe",
  "role": "Developer",
  "salary": 45000
}
``` 
**Description:** This api is used to save new employee details in database.Employee details like: name, role, salary.

###Get employee details
**URL:** http://localhost:8080/emp-data/get-emp
**Method:** GET
**Description:** This api is used to return all employees detail.

###Update employee
**URL:** http://localhost:8080/emp-data/update-emp/1
**Method:** PUT
**Description:** This api is used to update employee detail by id.

###Delete employee
**URL:** http://localhost:8080/emp-data/delete-emp/1
**Method:** DELETE
**Description:** This api is used to delete employee details by id.

###Get salary by Stream API filter 
**URL:** http://localhost:8080/emp-data/stream-filter-salary?minSalary=40000&maxSalary=70000
**Method:** GET
**Description:** This api return all employee whoes salaries fall **within the given range.**
-Pass 'minSalary' and 'maxSalary' as query parameter.
-Stream Api filter used.

###Get name by Stream API filter
**URL:** http://localhost:8080/emp-data/stream-filter-name?name=K
**Method:** GET
**Description:** This api return all employee details whoes name **start with the given character.**
Example:
-If pass 'name=k' it will return all employee details whoes name start with **k**.
-Stream Api filter used.

###Get name by Jpa repository filter
**URL:** http://localhost:8080/emp-data/jpa-repo-name?name=K
**Method:** GET
**Description:** This api return all employee details whoes name **start with the given character.**
Example:
-If pass 'name=V' it will return all employee details whoes name start with **V**.
-Jpa Repository used to apply filter.

###Get salary by jpa repository filter
**URL:** http://localhost:8080/emp-data/jpa-repo-salary?minSalary=35000&maxSalary=50000
**Method:** GET
**Description:** This api return all employee salaries fall **within the given range.**
-Pass 'minSalary' and 'maxSalary' as query parameter.
-Jpa Repository used to apply filter.


