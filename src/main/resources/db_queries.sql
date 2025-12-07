show databases;

CREATE DATABASE keycloak DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE USER 'keycloak'@'%' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON keycloak.* TO 'keycloak'@'%';
FLUSH PRIVILEGES;

use keycloak;
show tables;

select * from REALM;

db=mysql
db-username=keycloak
db-password=password
db-url=jdbc:mysql://localhost:3306/keycloak?characterEncoding=UTF-8&useSSL=false&allowPublicKeyRetrieval=true