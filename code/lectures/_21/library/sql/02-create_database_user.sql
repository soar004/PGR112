CREATE USER 'library' IDENTIFIED BY 'librarypassword';

GRANT ALL on Lecture21Library.* TO 'library';

FLUSH PRIVILEGES;