students-java
===
### A1 - Servlets in Java

Java servlet app to register students in modules

#### Backend:
- This project uses `students-dao-service` which also uses `students-inmemory-dao` through `@EJB` injection

Notes:
---
- The backend must be installed (`maven install`) before run this project on server

REMEMBER THIS!!
---
**We must uncheck Maven dependency resolution from workspace projects**
- Right-click on Project: Properties -> Maven -> [] Resolve dependencies from Workspace projects (uncheck)

![Resolve dependencies from Workspace](assets/images/resolve_dependencies.png)