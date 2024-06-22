drop database bank_exalt;
create database bank_exalt;
use bank_exalt;

create table accounts (
    id int primary key not null auto_increment,
    balance integer,
    overdraft integer,
    overdraft_auth decimal
    );

CREATE TABLE transfers (
    id int primary key not null auto_increment,
    amount FLOAT,
    date DATE,
    account_id int,
    FOREIGN KEY (account_id) REFERENCES accounts(id)
);

create table saving_accounts (
    id int primary key not null auto_increment,
    balance double,
    saving_limit double
);

