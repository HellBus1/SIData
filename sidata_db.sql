create table operator (
    operator_id int not null primary key auto_increment,
    operator_name varchar(255) not null,
    operator_position varchar(255),
    operator_mobilenumber varchar(255),
    operator_email varchar(255),
    operator_institution varchar(255),
    operator_status varchar(20)
);