# spring-todo-assignment
This is an assignment for Hasqvarna Group coding test

# Get All TODOs
GET /todos HTTP/1.1
Host: localhost:8080
Cache-Control: no-cache

# ADD TODO
POST /todo HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Cache-Control: no-cache

{ "text": "run" }

# Edit TODO -- mark done or update text
PUT /todo/{id} HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Cache-Control: no-cache

{ "text": "Eat Fruits", "done": true }

# Delete TODO
DELETE /todo/{id} HTTP/1.1
Host: localhost:8080
Cache-Control: no-cache

# Delete All TODOs
DELETE /todos HTTP/1.1
Host: localhost:8080
Cache-Control: no-cache

	
