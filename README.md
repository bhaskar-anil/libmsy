# libmsy
library management system

You build the application with `maven` and run or simply run the jar file present in libmsy/target/libmsy-0.0.1-SNAPSHOT.jar
<pre>java -jar libmsy-0.0.1-SNAPSHOT.jar</pre>
and access the application at http://localhost:8080

Endpoints - <br>
    - `/books` : gets list of all books<br>
    - `/books/add` : adds book<br>
    - `/books/lend/{isbn}` with POST data user rollNo as request param<br>
    - `/books/return/{isbn}` with POST data user rollNo as request param<br>
    - `/users` : gets list of all users<br>
    - `/users/add` : add user<br>
    - `/users/setlimit/{rollNo}` : set limit for user<br>
