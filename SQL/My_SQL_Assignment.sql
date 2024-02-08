/* Task 1: Database Design:
1. Create the database named "TicketBookingSystem" */

create database TBS;
use TBS;

/* 2. Write SQL scripts to create the mentioned tables with appropriate data types, constraints, and
relationships. 
1. Venu Table 
• venue_id (Primary Key) • venue_name, • address
2. Event Table 
• event_id (Primary Key) • event_name, • event_date DATE, • event_time TIME, 
• venue_id (Foreign Key), • total_seats, • available_seats, • ticket_price DECIMAL, 
• event_type ('Movie', 'Sports', 'Concert')
3. Customer Table
• customer_id (Primary key) • customer_name, • email, • phone_number, • booking_id (Foreign Key)
4. Booking Table
• booking_id (Primary Key), • customer_id (Foreign Key), • event_id (Foreign Key), • num_tickets,
• total_cost, • booking_date,  */

CREATE TABLE Venue (
venue_id INT AUTO_INCREMENT PRIMARY KEY,
venue_name VARCHAR(255) NOT NULL,
address TEXT NOT NULL
);

CREATE TABLE Event (
event_id INT AUTO_INCREMENT PRIMARY KEY,
event_name VARCHAR(255) NOT NULL,
event_date DATE NOT NULL,
event_time TIME NOT NULL,
venue_id INT,
total_seats INT NOT NULL,
available_seats INT NOT NULL,
ticket_price DECIMAL(10, 2) NOT NULL,
event_type ENUM('Movie', 'Sports', 'Concert') NOT NULL,
FOREIGN KEY (venue_id) REFERENCES Venue(venue_id)
);

CREATE TABLE Customer (
customer_id INT AUTO_INCREMENT PRIMARY KEY,
customer_name VARCHAR(255) NOT NULL,
email VARCHAR(255) NOT NULL,
phone_number VARCHAR(20) NOT NULL
);

CREATE TABLE Booking (
booking_id INT AUTO_INCREMENT PRIMARY KEY,
customer_id INT,
event_id INT,
num_tickets INT NOT NULL,
total_cost DECIMAL(10, 2) NOT NULL,
booking_date DATE NOT NULL,
FOREIGN KEY (customer_id) REFERENCES Customer(customer_id),
FOREIGN KEY (event_id) REFERENCES Event(event_id)
);


/* Task_2 */
/* Write a SQL query to insert at least 10 sample records into each table*/

insert into venue(venue_name, address) values('Movie Palace','123 MG Road'),
('Alka Talkies','234 JM Road'),('Shaniwar Wada','345 Chhatrapati Shivaji Maharaj Rd'),
('Aga Khan Palace','123 Nagar Road'),('Kelkar Museum', '789 Bajirao Road'),('Adlabs Imagica', '567 Lohgaon Road'),
('Lal Mahal', '231 Chhatrapati Shivaji Maharaj Rd'),('Okayama Friendship Garden', '321 MG Road'),
('Cafe Paashh', '897 FC Road'),('Cafe GoodLuck', '453 FC Road');

select * from venue;

insert into event(event_name, event_date, event_time, venue_id, total_seats, available_seats, 
ticket_price, event_type) values('Event1', '2024-01-15', '12:00:00', 1, 1000, 800, 1500.00, 'Concert'),
('Event2', '2023-11-15', '11:00:00', 2, 100, 80, 150.00, 'Sports'),
('Event3', '2024-01-10', '09:00:00', 3, 180, 100, 200.00, 'Concert'),
('Event4', '2024-01-01', '12:00:00', 4, 960, 600, 2000.00, 'Sports'),
('Event5', '2023-11-19', '18:00:00', 5, 590, 400, 800.00, 'Concert'),
('Event6', '2024-01-01', '08:00:00', 6, 750, 500, 750.00, 'Movie'),
('Event7', '2023-12-15', '20:00:00', 7, 350, 170, 500.00, 'Movie'),
('Event8', '2024-01-08', '05:00:00', 8, 890, 650, 550.00, 'Sports'),
('Event9', '2023-09-20', '07:00:00', 9, 1000, 900, 1200.00, 'Movie'),
('Event10', '2023-11-19', '19:00:00', 10, 900, 760, 650.00, 'Concert');

select * from event;

insert into customer(customer_name, email, phone_number) 
values('Vikrant', 'vikrant@gmail.com', 5352325556),('Prashant', 'prashnat@gmail.com', 6352425655),
('Nandini', 'nandini@gmail.com', 5358764556), ('Mrunal', 'mrunal@gmail.com', 3452325556),
('Prasad', 'Prasad@gmail.com', 5352328796),('Sahil', 'sahil@gmail.com', 5356574796),
('Sarthak', 'sarthak@gmail.com', 5657128796),('Mridul', 'mridul@gmail.com', 5352320000),
('Omkar', 'omkar@gmail.com', 4321328796),('Dipak', 'dipak@gmail.com', 5352000066);

select * from customer;

insert into booking(customer_id, event_id, num_tickets, total_cost, booking_date)
values(1, 1, 5, 7500.0, '2024-01-10'), (2, 2, 4, 600.0, '2023-10-10'),(3, 3, 10, 2000.0, '2023-12-12'),
(4, 4, 8, 16000.0, '2024-1-12'),(5, 5, 6, 4800.0, '2024-01-01'),(6, 6, 2, 1500.0, '2023-11-10'),
(7, 7, 3, 1500.0, '2023-11-01'),(8, 8, 4, 2200.0, '2024-01-15'),(9, 9, 6, 7200.0, '2024-01-08'),
(10, 10, 1, 650.0, '2024-01-09');

select * from booking;

/* 2. Write a SQL query to list all Events. */

select * 
from event;

/* 3. Write a SQL query to select events with available tickets. */

select event_name 
from event 
where available_seats>0;

/* 4. Write a SQL query to select events name partial match with ‘cup’. */

select event_name 
from event 
where event_name like '%cup%';

/* 5. Write a SQL query to select events with ticket price range is between 1000 to 2500. */

select event_name 
from event 
where ticket_price between 1000 and 2500;

/* 6. Write a SQL query to retrieve events with dates falling within a specific range. */

select event_name 
from event 
where event_date between '2023-12-01' and '2024-02-01';

/* 7. Write a SQL query to retrieve events with available tickets that also have "Concert" in their
name. */

select event_name 
from event 
where available_seats>0 and event_type like '%Concert%';

/* 8. Write a SQL query to retrieve users in batches of 5, starting from the 6th user */

select customer_name 
from customer 
limit 5 
offset 5;

/* 9. Write a SQL query to retrieve bookings details contains booked no of ticket more than 4. */

select * 
from booking 
where num_tickets>4;

/* 10. Write a SQL query to retrieve customer information whose phone number end with ‘000’ */

select * 
from customer 
where phone_number like '%000';

/* 11. Write a SQL query to retrieve the events in order whose seat capacity more than 15000. */

select event_name 
from event 
where total_seats>15000 
order by total_seats;

/* 12. Write a SQL query to select events name not start with ‘x’, ‘y’, ‘z’ */

select event_name 
from event 
where event_name not like 'x%' and event_name not like 'y%' and event_name not like 'z%';
 
 
/* Tasks 3: Aggregate functions, Having, Order By, GroupBy and Joins: */

/* 1. Write a SQL query to List Events and Their Average Ticket Prices */

select event_id, event_name, avg(ticket_price) as avg_ticket_prices
from event
group by event_id, event_name;

-- 2. Write a SQL query to Calculate the Total Revenue Generated by Events

select e.event_id, e.event_name, sum(total_cost) as total_revenue
from booking b inner join event e
on b.event_id = e.event_id
group by e.event_id, e.event_name;

-- 3. Write a SQL query to find the event with the highest ticket sales.

select e.event_name, sum(num_tickets) as highest_ticket_sales
from booking b join event e
on b.event_id = e.event_id
group by e.event_id,e.event_name
order by highest_ticket_sales desc
limit 1;

-- 4. Write a SQL query to Calculate the Total Number of Tickets Sold for Each Event.

select e.event_name, sum(num_tickets) as total_ticket_sales
from booking b join event e
on b.event_id = e.event_id
group by e.event_id,e.event_name;

-- 5. Write a SQL query to Find Events with No Ticket Sales.

select e.event_id, e.event_name
from event e left join booking b 
on e.event_id = b.event_id
where b.booking_id is null;

-- 6. Write a SQL query to Find the User Who Has Booked the Most Tickets.

select c.customer_name, max(num_tickets) as Most_tickets
from customer c join booking b
on c.customer_id=b.customer_id
group by c.customer_name
order by Most_tickets desc
limit 1;

-- 7. Write a SQL query to List Events and the total number of tickets sold for each month.

select month(booking_date) as month, sum(num_tickets) as 'tickets sold for each month'
from event e join booking b
on e.event_id = b.event_id
group by month
order by month;

-- 8. Write a SQL query to calculate the average Ticket Price for Events in Each Venue.

select v.venue_id, v.venue_name, avg(e.ticket_price) as avg_ticket_price
from venue v join event e
on v.venue_id = e.venue_id
group by v.venue_id, v.venue_name;

-- 9. Write a SQL query to calculate the total Number of Tickets Sold for Each Event Type.

select e.event_type, sum(b.num_tickets) as Ticket_for_each_event_type
from event e join booking b
on e.event_id=b.event_id
group by e.event_type;

-- 10. Write a SQL query to calculate the total Revenue Generated by Events in Each Year

select year(booking_date) as year, sum(total_cost) as Revenue_for_each_year
from booking 
group by year
order by year;

-- 11. Write a SQL query to list users who have booked tickets for multiple events.

select c.customer_id, c.customer_name
from customer c join booking b
on c.customer_id = b.customer_id
group by c.customer_id, c.customer_name
having count(distinct b.event_id)>1;

-- 12. Write a SQL query to calculate the Total Revenue Generated by Events for Each User.

select c.customer_id, c.customer_name, sum(b.total_cost) as total_revenue
from customer c join booking b
on c.customer_id = b.customer_id
group by c.customer_id, c.customer_name;

-- 13. Write a SQL query to calculate the Average Ticket Price for Events in Each Category and Venue.

select e.event_type, v.venue_name, avg(e.ticket_price) as avg_ticket_price
from event e join venue v
on e.venue_id=v.venue_id
group by e.event_type, v.venue_name;

-- 14. Write a SQL query to list Users and the Total Number of Tickets They've Purchased in the Last 30 Days

select c.customer_id, c.customer_name, sum(b.num_tickets) as total_tickets
from customer c join booking b
on c.customer_id = b.customer_id
where b.booking_date >= current_date() - interval 30 day
group by c.customer_id, c.customer_name;

-- Tasks 4: Subquery and its types

-- 1. Calculate the Average Ticket Price for Events in Each Venue Using a Subquery.

-- without SubQuery
select v.venue_name, avg(e.ticket_price) as avg_ticket_price
from venue v join event e
on v.venue_id = e.venue_id
group by v.venue_name;

-- With SubQuery
select v.venue_name, avg(e.ticket_price) as avg_ticket_price
from event e join venue v
on e.venue_id = v.venue_id
where v.venue_name in (select venue_name
				       from venue)
group by v.venue_name;	    

-- 2. Find Events with More Than 50% of Tickets Sold using subquery.

select event_name
from event 
where event_id in (select b.event_id
				   from booking b join event e
				   on b.event_id=e.event_id 
				   where b.num_tickets > 0.5*e.total_seats);
                			
-- 3. Calculate the Total Number of Tickets Sold for Each Event.

select e.event_name, sum(num_tickets) as Ticket_sold
from booking b join event e
on b.event_id=e.event_id
where e.event_name in (select event_name
					   from event)
group by e.event_name;

-- 4. Find Users Who Have Not Booked Any Tickets Using a NOT EXISTS Subquery.

select c.customer_id, c.customer_name
from customer c 
where not exists (select *
				  from booking b
				  where b.customer_id=c.customer_id);
                                
-- 5. List Events with No Ticket Sales Using a NOT IN Subquery.

select event_id, event_name
from event 
where event_id not in (select distinct event_id
					   from booking);
                       
-- 6. Calculate the Total Number of Tickets Sold for Each Event Type Using a Subquery in the FROM Clause.

select subquery.event_type, subquery.total_tickets_sold
from (select e.event_type, sum(b.num_tickets) as total_tickets_sold
	  from event e join booking b
      on e.event_id=b.event_id
      group by e.event_type)  as subquery
group by subquery.event_type;

-- 7. Find Events with Ticket Prices Higher Than the Average Ticket Price Using a Subquery in the WHERE Clause.

select event_name, ticket_price as higher_than_avg_ticket_price
from event
where ticket_price >(select avg(ticket_price)
			         from event);

-- 8. Calculate the Total Revenue Generated by Events for Each User Using a Correlated Subquery.

select c.customer_name, sum(b.total_cost) as total_revenue
from booking b join customer c
on b.customer_id=c.customer_id
where c.customer_name in (select customer_name
						  from customer
                          where customer_id=b.customer_id)
group by c.customer_name;

-- 9. List Users Who Have Booked Tickets for Events in a Given Venue Using a Subquery in the WHERE Clause.

select customer_id, customer_name
from customer	
where customer_id in(select distinct b.customer_id
					 from booking b join event e
                     on b.event_id = e.event_id
                     where e.venue_id=1);
                     
-- 10. Calculate the Total Number of Tickets Sold for Each Event Category Using a Subquery with GROUP BY.

select e.event_type, sum(b.num_tickets) as total_tickets_sold
from event e join booking b
on e.event_id=b.event_id
where e.event_type in (select event_type
				       from event)
group by e.event_type;

-- 11. Find Users Who Have Booked Tickets for Events in each Month Using a Subquery with DATE_FORMAT.

select c.customer_id, c.customer_name, date_format(b.booking_date, '%Y-%m') as month
from customer c inner join booking b
on c.customer_id=b.customer_id
where c.customer_id in (select distinct b.customer_id
						from booking b )
group by c.customer_id, c.customer_name, month;

-- 12. Calculate the Average Ticket Price for Events in Each Venue Using a Subquery.

select v.venue_name, avg(e.ticket_price) as avg_ticket_price
from event e join venue v
on e.venue_id = v.venue_id
where v.venue_name in (select venue_name
				       from venue)
group by v.venue_name;



select * from booking;
select * from customer;
select * from event;
select * from venue;