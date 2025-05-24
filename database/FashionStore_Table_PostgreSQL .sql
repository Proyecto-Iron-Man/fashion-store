create table categories 
(
	id serial,
	name varchar(200) not null,
	description varchar(1000),
	url_key varchar(250),
	status char(1) not null default 'A',
	created_at timestamp not null default CURRENT_TIMESTAMP,
	updated_at timestamp,
	
	constraint categories_pk primary key (id),
	constraint categories_name_uq unique (name)
);

create table products 
(
	id serial,
	name varchar(300) not null,
	description varchar(4000),
	price decimal (18,2) not null default 0,
	stock integer not null default 0,
	category_id integer,
	status char(1) not null default 'A',
	created_at timestamp not null default CURRENT_TIMESTAMP,
	updated_at timestamp,
	
	constraint products_pk primary key (id),
	constraint products_category_id_fk foreign key (category_id) references categories(id),
	constraint products_name_category_id_uq unique (name,category_id)
);

create table profiles 
(
	id serial,
	name varchar(200) not null,
	description varchar(1000),
	status char(1) not null default 'A',
	created_at timestamp not null default CURRENT_TIMESTAMP,
	updated_at timestamp,
	
	constraint profiles_pk primary key (id),
	constraint profiles_name_uq unique (name)
);


create table users 
(
	id serial,
	name varchar(200) not null,
	email varchar(100) not null,
	password varchar(200) not null,
	profile_id integer,
	status char(1) not null default 'A',
	created_at timestamp not null default CURRENT_TIMESTAMP,
	updated_at timestamp,
	
	constraint users_pk primary key (id),
	constraint users_profile_id_fk foreign key (profile_id) references profiles (id),
	constraint users_email_uq unique (email)
);


create table customers 
(
	id serial,
	name varchar(200) not null,
	document_number varchar(20) not null,
	email varchar(100),
	phone_number varchar(25),
	address varchar(2000),
	status char(1) not null default 'A',
	created_at timestamp not null default CURRENT_TIMESTAMP,
	updated_at timestamp,
	
	constraint customers_pk primary key (id),
	constraint customers_document_number_uq unique (document_number)
);


create table invoices 
(
	id serial,
	invoice_date timestamp,
	customer_id integer,
	user_id integer,
	status char(1) not null default 'A',
	created_at timestamp not null default CURRENT_TIMESTAMP,
	updated_at timestamp,
	
	constraint invoices_pk primary key (id),
	constraint invoices_customer_id foreign key (customer_id) references customers (id),
	constraint invoices_user_id foreign key (user_id) references users (id)
);


create table invoice_details 
(
	id serial, 
	invoice_id integer,
	product_id integer,
	quantity integer,
	price decimal (18,2) not null,
	status char(1) not null default 'A',
	created_at timestamp not null default CURRENT_TIMESTAMP,
	updated_at timestamp,
	
	constraint invoice_details_pk primary key (id),
	constraint invoice_details_invoice_id foreign key (invoice_id) references invoices (id),
	constraint invoice_details_product_id foreign key (product_id) references products (id),
	constraint invoice_details_invoice_id_product_id_uq unique (invoice_id,product_id)
);

