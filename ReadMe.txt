Maven REST backend microservice run on localhost:8080, the view part is handled in separate angular app.
The http requests are handled in the controllers, bussiess login in the services, database functions with repositories and orm with entites. 
Considered this arhitectural style because of the separation of concerns, every part composition does his own job.
Database used is in-memory h2 which is populated on startup. 
Java version 8 is used.

- nothing specific for setup, download it from git and run it