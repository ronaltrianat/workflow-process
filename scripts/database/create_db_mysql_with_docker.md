# Crear y arrancar servidor MySQL con Docker
```
docker run -d -p 3306:3306 --name='mysql-server' --env="MYSQL_ROOT_PASSWORD=password" mysql --default-authentication-plugin=mysql_native_password
```

# Ingresar al servidor MySQL Docker
```
docker exec -ti mysql-server bash
```

# Primera Configuracion DB
```
mysql -u root -p
create database workflow_process_db;
create user 'user_wp'@'%%' identified with mysql_native_password BY 'password';
grant all privileges on workflow_process_db.* TO 'user_wp'@'%%';
flush privileges;
quit;
```

# Primera Configuracion Activiti DB - password
mysql -u root -p
create database activiti_db;
create user 'user_activiti'@'%%' identified with mysql_native_password BY 'password';
grant all privileges on activiti_db.* TO 'user_activiti'@'%%';
flush privileges;
quit;
