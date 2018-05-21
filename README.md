# libmsy
library management system

You build the application with `maven` and run or simply run the jar file present in libmsy/target/libmsy-0.0.1-SNAPSHOT.jar
<pre>java -jar libmsy-0.0.1-SNAPSHOT.jar</pre>
and access the application at http://localhost:8080

Endpoints - 
    - `/books` : gets list of all books
    - `/books/add` : adds book
    - `/books/lend/{isbn}` with POST data user rollNo as request param
    - `/books/return/{isbn}` with POST data user rollNo as request param
    - `/users` : gets list of all users
    - `/users/add` : add user
    - `/users/setlimit/{rollNo}` : set limit for user
