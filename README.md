# LoadAPIProject
Download the release and extract the project and open it in the eclipse. Open application.properties and Set the username and userpassword according to the your system configuration After that run the project as SpringBootApp Install Postman and hit the below APIs This API has total

i)Get https:/localhost:8080/loads

Response: returns all the loads in the database

ii)Get https:/localhost:8080/loads/id

Response:
    return the load associated with the id
iii)Post https:/localhost:8080/loads => creates new load and adds to the database BODY: {

                    "loadingPoint":"Delhi",
                    "unloadingPoint":"Jaipur",
                    "productType":"Chemicals",
                    "truckType":"Canter",
                    "noOfTrucks":"6",
                    "weight":"890",
                    "comment":"Loading mode",
            }

       Response:
          load with id created
iv)Put https:/localhost:8080/loads/id BODY: {

                    "loadingPoint":"Delhi",
                    "unloadingPoint":"Jaipur",
                    "productType":"Chemicals",
                    "truckType":"Canter",
                    "noOfTrucks":"6",
                    "weight":"890",
                    "comment":"Loading mode",
            }

          Response:
              load with id found and upadted succesfully
              load with id not found ,update operation failed

V)Delete  https:localhost:8080/loads/id  => Deletes the load with given id 
       Response:
            Load with id deleted
            Load with id not found ,delete operation failed
