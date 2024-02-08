/* • Designing the schema for a Virtual Art Gallery involves creating a structured representation of the
database that will store information about artworks, artists, users, galleries, and various
relationships between them. Below is a schema design for a Virtual Art Gallery database:

• Entities and Attributes:

• Artwork
ArtworkID (Primary Key), Title, Description, CreationDate, Medium, ImageURL (or any reference to the digital representation)

• Artist
ArtistID (Primary Key), Name, Biography, BirthDate, Nationality, Website, Contact Information

• User
UserID (Primary Key), Username, Password, Email, First Name, Last Name, Date of Birth,Profile Picture
FavoriteArtworks (a list of references to ArtworkIDs)

• Gallery
GalleryID (Primary Key), Name, Description, Location, Curator (Reference to ArtistID),OpeningHours
*/

create database Virtual_Art_Gallery;
use virtual_art_gallery;

-- artwork table
create table artwork(artwork_id int primary key auto_increment, 
title varchar(50),
description varchar(100), 
creation_date date, 
medium varchar(50), 
image_url varchar(100));

alter table artwork add column artist_id int ;
alter table artwork add foreign key (artist_id) references artist(artist_id);

select * from artwork;
desc artwork;

-- artist table
create table artist(artist_id int primary key auto_increment,
Name varchar(50), 
Biography varchar(50), 
BirthDate date , 
Nationality varchar(50), 
Website varchar(50), 
Contact_Info varchar(50));

select * from artist;
desc artist;

-- user table
create table user(UserID int Primary Key auto_increment,
Username varchar(50), 
Password varchar(50), 
Email varchar(50), 
First_Name varchar(50), 
Last_Name varchar(50), 
DOB date,
Profile_Picture varchar(50),
Favorite_Artworks int,
foreign key (Favorite_Artworks) references artwork(artwork_id));

select * from user;
desc user;

-- Gallery table
create table gallery(GalleryID int Primary Key auto_increment, 
Name varchar(50), 
Description varchar(50), 
Location varchar(50), 
Curator int,
OpeningHours varchar(50),
foreign key (Curator) references artist(artist_id));

select * from gallery;
desc gallery;

-- user_favourite_artwork table
create table user_favourite_artwork(userid int,
artwork_id int,
primary key (userid, artwork_id),
foreign key (userid) references user(userid),
foreign key (artwork_id) references artwork(artwork_id));

select * from user_favourite_artwork;
desc user_favourite_artwork;

-- Artwork_Gallery table
create table artwork_gallery(artwork_id int,
galleryid int,
primary key (artwork_id, galleryid),
foreign key (artwork_id) references artwork(artwork_id),
foreign key (galleryid) references gallery(galleryid));

select * from artwork_gallery;
desc artwork_gallery;

-- Inserting Records into Artwork Table
INSERT INTO Artwork (Artwork_ID, Title, Description, Creation_Date, Medium, Image_URL)
VALUES
(1, 'The Starry Night', 'A famous painting by Vincent van Gogh', '1889-06-01', 'Oil on Canvas', 'starry_night.jpg'),
(2, 'Mona Lisa', 'Portrait painting by Leonardo da Vinci', '1503-01-01', 'Oil on Poplar Panel', 'mona_lisa.jpg'),
(3, 'Guernica', 'A powerful anti-war painting by Pablo Picasso', '1937-09-01', 'Oil on Canvas', 'guernica.jpg'),
(4, 'The Persistence of Memory', 'Surrealistic painting by Salvador Dali', '1931-01-01', 'Oil on Canvas', 'persistence_of_memory.jpg'),
(5, 'The Birth of Venus', 'Famous painting by Sandro Botticelli', '1484-05-01', 'Tempera on Canvas', 'birth_of_venus.jpg');

UPDATE artwork
SET artist_id = CASE
    WHEN Artwork_ID = 1 THEN 1
    WHEN Artwork_ID = 2 THEN 2
    WHEN Artwork_ID = 3 THEN 3
    WHEN Artwork_ID = 4 THEN 4
    WHEN Artwork_ID = 5 THEN 5
    ELSE artist_id
END
WHERE Artwork_ID IN (1, 2, 3, 4, 5);

-- Inserting Records into Artist Table
INSERT INTO Artist (Artist_ID, Name, Biography, BirthDate, Nationality, Website, Contact_Info)
VALUES
(1, 'Vincent van Gogh', 'Dutch post-impressionist painter', '1853-03-30', 'Dutch', 'www.vangoghgallery.com', 'Contact Van Gogh Foundation'),
(2, 'Leonardo da Vinci', 'Italian polymath of the Renaissance', '1452-04-15', 'Italian', 'www.leonardodavinci.net', 'Contact Vinci Studios'),
(3, 'Pablo Picasso', 'Spanish painter and sculptor', '1881-10-25', 'Spanish', 'www.picasso.fr', 'Contact Picasso Museum'),
(4, 'Salvador Dali', 'Spanish surrealist artist', '1904-05-11', 'Spanish', 'www.salvadordali.org', 'Contact Dali Museum'),
(5, 'Sandro Botticelli', 'Italian painter of the Early Renaissance', '1445-03-01', 'Italian', 'www.sandrobotticelli.net', 'Contact Uffizi Gallery');

-- Inserting Records into User Table
INSERT INTO User (UserID, Username, Password, Email, First_Name, Last_Name, DOB, Profile_Picture, Favorite_Artworks)
VALUES
(1, 'artlover123', 'password123', 'artlover@example.com', 'John', 'Doe', '1985-07-15', 'john_doe.jpg', 3),
(2, 'creativemind', 'letmein', 'creative@example.com', 'Jane', 'Smith', '1990-02-28', 'jane_smith.jpg', 4),
(3, 'galleryowner', 'securepass', 'owner@example.com', 'Gallery', 'Owner', '1970-12-10', 'gallery_owner.jpg', 5),
(4, 'curator1', 'curatorpass', 'curator1@example.com', 'Curator', 'One', '1988-04-20', 'curator_one.jpg', 1),
(5, 'artcollector', 'collectart', 'collector@example.com', 'Art', 'Collector', '1975-09-05', 'art_collector.jpg', 2);

-- Inserting Records into Gallery Table
INSERT INTO Gallery (GalleryID, Name, Description, Location, Curator, OpeningHours)
VALUES
(1, 'Modern Art Gallery', 'Showcasing contemporary artworks', 'City Center', 1, '10:00 AM - 6:00 PM, Mon-Sat'),
(2, 'Renaissance Treasures', 'Exhibiting classic masterpieces', 'Historic District', 5, '9:00 AM - 5:00 PM, Tue-Sun'),
(3, 'Surreal Dreams Gallery', 'Explore the world of surrealism', 'Art District', 4, '11:00 AM - 7:00 PM, Wed-Mon'),
(4, 'Impressionist Impressions', 'Impressionist art at its finest', 'Waterfront', 1, '10:00 AM - 8:00 PM, Thu-Sun'),
(5, 'Abstract Wonders', 'Discover the beauty of abstract art', 'Downtown', 3, '12:00 PM - 6:00 PM, Fri-Sat');

-- Inserting Records into User_Favorite_Artwork Table
INSERT INTO User_Favourite_Artwork (UserID, Artwork_ID)
VALUES (1, 3), (1, 4), (2, 4), (3, 5), (3, 2), (4, 1), (5, 2), (5, 4);

-- Inserting Records into Artwork_gallery Table
INSERT INTO Artwork_Gallery (Artwork_ID, GalleryID)
VALUES (2, 4), (3, 3), (1, 2), (4, 4), (5, 5), (1, 1), (4, 1), (2, 2);

select * from Artwork;
select * from Artist;
select * from user;
select * from gallery;
select * from user_favourite_artwork;
select * from Artwork_gallery;
