import psycopg2
from psycopg2 import sql

# PostgreSQL connection parameters
host = 'localhost'
user = 'myuser'
password = 'mypassword'
new_db_name = 'hostel_management'

# Connect to default postgres database to create a new one
def create_database():
    try:
        conn = psycopg2.connect(dbname='postgres', user=user, password=password, host=host)
        conn.autocommit = True
        cur = conn.cursor()

        cur.execute(sql.SQL("CREATE DATABASE {}").format(sql.Identifier(new_db_name)))
        print(f"Database '{new_db_name}' created successfully!")

        cur.close()
        conn.close()
    except Exception as e:
        print(f"Error creating database: {e}")

# Create hostel management schema
def create_schema():
    try:
        conn = psycopg2.connect(dbname=new_db_name, user=user, password=password, host=host)
        cur = conn.cursor()

        # SQL schema: Hostel Management System (6 tables)
        create_table_queries = [
            """
            CREATE TABLE Student (
                student_id SERIAL PRIMARY KEY,
                name VARCHAR(100) NOT NULL,
                email VARCHAR(100) UNIQUE NOT NULL,
                phone VARCHAR(15),
                room_id INT,
                checkin_date DATE NOT NULL
            )
            """,
            """
            CREATE TABLE Room (
                room_id SERIAL PRIMARY KEY,
                room_number VARCHAR(10) UNIQUE NOT NULL,
                capacity INT NOT NULL,
                occupied INT DEFAULT 0
            )
            """,
            """
            CREATE TABLE Hostel (
                hostel_id SERIAL PRIMARY KEY,
                name VARCHAR(100) NOT NULL,
                location VARCHAR(150) NOT NULL
            )
            """,
            """
            CREATE TABLE Warden (
                warden_id SERIAL PRIMARY KEY,
                name VARCHAR(100) NOT NULL,
                phone VARCHAR(15),
                hostel_id INT REFERENCES Hostel(hostel_id)
            )
            """,
            """
            CREATE TABLE MaintenanceRequest (
                request_id SERIAL PRIMARY KEY,
                student_id INT REFERENCES Student(student_id),
                description TEXT NOT NULL,
                status VARCHAR(20) DEFAULT 'Pending',
                request_date DATE NOT NULL DEFAULT CURRENT_DATE
            )
            """,
            """
            CREATE TABLE Fees (
                fees_id SERIAL PRIMARY KEY,
                student_id INT REFERENCES Student(student_id),
                amount DECIMAL(10, 2) NOT NULL,
                due_date DATE NOT NULL,
                is_paid BOOLEAN DEFAULT FALSE
            )
            """
        ]

        for query in create_table_queries:
            cur.execute(query)

        conn.commit()
        print("Hostel management schema created successfully!")

        cur.close()
        conn.close()
    except Exception as e:
        print(f"Error creating schema: {e}")

if __name__ == "__main__":
    create_database()
    create_schema()
