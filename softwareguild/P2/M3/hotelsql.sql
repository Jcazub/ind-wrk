DROP DATABASE IF EXISTS HotelReservations;

CREATE DATABASE HotelReservations;

USE HotelReservations;

CREATE TABLE Customer (
	CustomerID int(20) not null auto_increment,
    FirstName varchar(45) not null,
    LastName varchar(45) not null,
    primary key (CustomerID)
);

CREATE TABLE PhoneType (
	PhoneTypeID int(20) not null auto_increment,
    PhoneType varchar(45) not null,
    primary key (PhoneTypeID)
);

CREATE TABLE EmailType (
	EmailTypeID int(20) not null auto_increment,
    EmailType varchar(45) not null,
    primary key (EmailTypeID)
);
	
CREATE TABLE CustomerPhone (
	PhoneID int(20) not null auto_increment,
	PhoneNumber int(20) not null,
	Customer int(20) not null,
	PhoneType int(20) not null,
	primary key (PhoneID),
	foreign key (Customer) references customer(customerID),
	foreign key (PhoneType) references PhoneType(PhoneTypeID)
);

CREATE TABLE CustomerEmail (
	EmailID int(20) not null auto_increment,
	Address varchar(45) not null,
	Customer int(20) not null,
	EmailType int(20) not null,
	primary key (EmailID),
	foreign key (Customer) references customer(customerID),
	foreign key (EmailType) references EmailType(EmailTypeID)
);

CREATE TABLE PromotionType (
	PromotionTypeID int(20) not null auto_increment,
	PromotionType varchar(45) not null,
	PromotionValue double not null,
	primary key (PromotionTypeID)
);

CREATE TABLE Promotion (
	PromotionID int(20) not null auto_increment,
	StartDate date not null,
	EndDate date not null,
	PromotionType int(20) not null,
	primary key (PromotionID),
	foreign key (PromotionType) references PromotionType(PromotionTypeID)
);

CREATE TABLE Reservation (
	ReservationID int(20) not null auto_increment,
    StartDate date not null,
    EndDate date not null,
    Promotion int(20),
    Customer int(20) not null,
    primary key (ReservationID),
    foreign key (Promotion) references Promotion(PromotionID),
    foreign key (Customer) references Customer(CustomerID)
);

CREATE TABLE RoomType (
	RoomTypeID int(20) not null auto_increment,
    RoomType varchar(45) not null,
    NumberOfBeds int(1) not null,
    primary key (RoomTypeID)
);

CREATE TABLE RoomRates (
	RoomRatesID int(20) not null auto_increment,
    RoomValue double not null,
    primary key (RoomRatesID)
);

CREATE TABLE Room (
	RoomID int(20) not null auto_increment,
    RoomNumber int(3) not null,
    Floor int (3) not null,
    Occupancy int (3) not null,
    RoomType int(20) not null,
    RoomRate int(20) not null,
    primary key (RoomID),
    foreign key (RoomType) references RoomType(RoomTypeID),
    foreign key (RoomRate) references RoomRates(RoomRatesID)
);

CREATE TABLE RoomAmenities (
	RoomAmenityID int(20) not null auto_increment,
    AmenityName varchar(45) not null,
    Description varchar(500),
    Room int(20) not null,
    primary key (RoomAmenityID),
    foreign key (Room) references Room(RoomID)
);

CREATE TABLE RoomReservations (
	Room int(20) not null,
    Reservation int(20) not null,
    foreign key (Room) references Room(RoomID),
    foreign key (Reservation) references Reservation(ReservationID)
);

CREATE TABLE Guests (
	GuestID int(20) not null auto_increment,
    Age int(3) not null,
    Reservation int(20) not null,
    primary key (GuestID),
    foreign key (Reservation) references Reservation(ReservationID)
);

CREATE TABLE AddOnRates (
	AddOnRateID int(20) not null auto_increment,
    AddOnValue double,
    primary key (AddOnRateID)
);

CREATE TABLE AddOns (
	AddOnID int(20) not null auto_increment,
    AddOnName varchar(45) not null,
    Description varchar(500),
    AddOnRate int(20) not null,
    primary key (AddOnId),
    foreign key (AddOnRate) references AddOnRates(AddOnRateID)
);

CREATE TABLE GuestAddOns (
	Guest int(20) not null,
    AddOn int(20) not null,
    foreign key (Guest) references Guests(GuestID),
    foreign key (AddOn) references AddOns(AddOnID)
);

CREATE TABLE Bill (
	BillID int(20) not null auto_increment,
    Tax double not null,
    Total double not null,
    Customer int(20) not null,
    primary key (BillID),
    foreign key (Customer) references Customer(CustomerID)
);

CREATE TABLE BillDeatails (
	BillDetails int(20) not null auto_increment,
    Bill int(20) not null,
    Reservation int(20) not null,
    Room int(20) not null,
    Price double not null,
    primary key (BillDetails),
    foreign key (Reservation) references RoomReservations(Reservation),
    foreign key (Room) references RoomReservations(Room)
);


    

