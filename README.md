# Medical center application

# Instruction for creating needed database in PostgreSQL
1. Install PostgreSQL like in this <a href="https://youtu.be/5hzZtqCNQKk?t=1352">link</a>.
2. During the instalation set password following : "q12we3".
3. Get logged to PostgreSQL using following commands:

        psql --username postgres

    Password to type (if you set it like its written above):
  
        q12we3
  
5. Create database using following commands:

        CREATE DATABASE medical_center;
    And after it:
        
        GRANT ALL PRIVILAGES ON DATABASE "medical_center" TO postgres;
    Okey, you created database, to see it type:
    
        \l
    To connect to it type: 
    
        \c medical_center
    To see tables and relations in database type "\d" ("\dt" to see only tables):
    
        \d
    To see more details about some table type "/d <name_of_table>", for example:
    
        \d patient
    To see records in table just use "SELECT * FROM <name_of_table>";" like in oridnary sql, for example:
    
        SELECT * FROM patient;


# Instruction for using project
1. Install PostgreSQL if you don't have it and create database like in intruction above.
2. Git clone this project and open it up with IntelliJ IDEA.
3. Turn on the application with MedicalCenterApplication class.
4. Download and install Postman if you don't have it.
5. Test it with the following examples below taking into account the remarks in these using Postman.

<h1>Conceptual database model</h1>

![image](https://user-images.githubusercontent.com/39047457/145110428-11888134-5e8a-4a61-a65f-2f7c1befffe8.png)


  <h1>Patient</h1>
	
- Viewing all patients:
  
  Method GET on url: 
  
      localhost:80/api/patients
	
- Viewing single patients:
	Method GET on url:
  
      localhost:80/api/patients/{id}
	
- Adding patients:
	Method POST on url:
  
      localhost:80/api/patients
	
	Patient example in JSON format:
  
      {
            "name": "Marek",
            "surname": "Frankowski",
            "pesel": "3581236958",
            "email": "MarekFrankowski@gmail.com",
            "street": "Kwiatowa",
            "postcode": "16-420",
            "houseNumber": "22",
            "city": "Suwałki",
            "phoneNumber": "123326790"
      }
	
- Updating patients:
	Method PUT on url:
  
      localhost:80/api/patients/{id}
	
  Patient update example in JSON format:
  
      {
          "name": "NotMarekButFranek",
          "houseNumber": "22B"
      }
  
- Deleting patients:
	Method DELETE on url: 
  
      localhost:80/api/patients/{id}
  
	<b>Important!</b> - To delete patient or project you have to delete first every consent which contains them.
	<br>
  
	<h1>Research Project</h1>
	
- Viewing all projects:
	Method GET on url:
  
      localhost:80/api/projects
	
- Viewing single projects:
	Method GET on url:
  
      localhost:80/api/projects/{id}
	
- Adding projects:
	Method POST on url: 
  
      localhost:80/api/projects
	
	Project example in JSON format:
  
      {
        "disease": "Zapalenie płuc."
      }
	
- Updating projects:
	Method PUT on url:
  
      localhost:80/api/projects/{id}
	
  Project update example in JSON format:
  
      {
        "disease": "Zaawansowane zapalenie płuc."
      }
  
  
- Deleting projects:
	Method DELETE on url:
  
      localhost:80/api/projects/{id}
  
	<b>Important!</b> - To delete patient or project you have to delete first every consent which contains them.
	<br>
  

	<h1>Consent</h1>
  
  Once record in consent table is created means the consent of the patient to participate in the research project, if the client wishes to quote the decision, record in that table should be removed.

  Column "is_connected" and its positive value means that patient has been included in research project and research orders with that consent record can be created.

  If value of column "is_connected" is "false", we cannot create research order linked with it.

  If you want to create such an research order, after create consent assign connection between patient and research order as in "Connection between patient and research" paragraph is shown.

- Viewing all consents:
	Method GET on url:
  
      localhost:80/api/consents
	
- Viewing single consents:
	Method GET on url:
  
      localhost:80/api/consents/{id}
	
- Adding consents:
	Method POST on url:
  
      localhost:80/api/consents
	
	<b>Important!</b> - To add consent you must firstly have patient and research project in DB and give their Id as below.
  <br>
	Research project example in JSON format: <br>
  
      {
            "patient":{
                "patientId": 5
            },
            "researchProject":{
                "projectId": 3
            }
      }
	
- Deleting consents:
	Method DELETE on url:
  
      localhost:80/api/consents/{id}
	
  <b>Important!</b> - Removing single consent will remove every order which is linked to it (that is, linked to that patient from consent and that research project from consent simultaneously), and that causes removing all research results linked to any research order of that pacient and that project simultaneously.
  <br>
  
	<h1>Connection between patient and research</h1>
	
- To assign or remove connection between patient and research project send boolean value in JSON format.
	Method PUT on url: 
  
      localhost:80/api/consents/{id}
  
	Assign example in JSON format: 
  
      true
	
	<h1>Research order</h1>
  
- Viewing all orders:
	Method GET on url:
  
      localhost:80/api/orders
	
- Viewing single orders:
	Method GET on url:
  
      localhost:80/api/orders/{id}
  
  
- Adding orders:
	Method POST on url:
  
      localhost:80/api/orders/{id}
  
  Where "Id" is Id of consent to which order will be added.
	
	Research order example in JSON format:
  
      {
        "researchDate": "2021-12-18"
      }
	
	
  <h1>Research result</h1>
  
- Viewing all results:
	Method GET on url:
  
      localhost:80/api/results
	
- Viewing single results:
	Method GET on url:
  
      localhost:80/api/results/{id}
  
- Adding results:
	Method POST on url:
  
      localhost:80/api/results/{id}
  
  Where "Id" is Id of order to which result will be added.
  
	Research result example in JSON format:
  
      {
        "result": "This is result based on research order."
      }

- Updating results:
	Method PUT on url:
  
      localhost:80/api/results/{id}
  
	Research result update example in JSON format:
  
      {
        "result": "This is result based on research order, but updated."
      }
      
- Deleting results:
	Method DELETE on url:
  
      localhost:80/api/results/{id}
