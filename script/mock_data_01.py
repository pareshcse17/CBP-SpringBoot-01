import psycopg2
from datetime import date, timedelta
import random

# PostgreSQL connection parameters
host = 'localhost'
user = 'myuser'
password = 'mypassword'
dbname = 'hostel_management'

# Constants for bulk insertion
HOSTEL_NAMES = [f"Hostel_{i}" for i in range(1, 11)]  # 10 Hostels
WARDEN_NAMES = [f"Warden_{i}" for i in range(1, 11)]  # 10 Wardens
ROOM_NUMBERS = [f"{floor}{room:02d}" for floor in range(1, 6) for room in range(1, 11)]  # 50 Rooms
STUDENT_FIRST_NAMES = ["Alex", "Sam", "Jordan", "Taylor", "Morgan", "Jamie", "Casey", "Avery", "Riley", "Hayden"]
STUDENT_LAST_NAMES = ["Smith", "Johnson", "Williams", "Brown", "Jones", "Miller", "Davis", "Wilson", "Clark", "Lewis"]
MAINTENANCE_REQUESTS = ["Fixing light", "Leaking pipe", "Broken bed", "Wi-Fi issue", "Window stuck"]

TOTAL_STUDENTS = 1000

def insert_mock_data():
    try:
        conn = psycopg2.connect(dbname=dbname, user=user, password=password, host=host)
        cur = conn.cursor()

        # Insert Hostels (10)
        cur.executemany("INSERT INTO Hostel (name, location) VALUES (%s, %s)", [(name, f"Location_{i+1}") for i, name in enumerate(HOSTEL_NAMES)])

        # Get hostel ids
        cur.execute("SELECT hostel_id FROM Hostel")
        hostel_ids = [row[0] for row in cur.fetchall()]

        # Insert Wardens (10)
        wardens = [(WARDEN_NAMES[i], f"90000000{i+1}", hostel_ids[i % len(hostel_ids)]) for i in range(10)]
        cur.executemany("INSERT INTO Warden (name, phone, hostel_id) VALUES (%s, %s, %s)", wardens)

        # Insert Rooms (50 rooms)
        room_data = [(ROOM_NUMBERS[i], random.randint(2, 4), 0) for i in range(len(ROOM_NUMBERS))]
        cur.executemany("INSERT INTO Room (room_number, capacity, occupied) VALUES (%s, %s, %s)", room_data)

        cur.execute("SELECT room_id, capacity FROM Room")
        rooms = cur.fetchall()

        # Insert Students (1000+)
        students = []
        room_pointer = 0
        for student_id in range(1, TOTAL_STUDENTS + 1):
            first_name = random.choice(STUDENT_FIRST_NAMES)
            last_name = random.choice(STUDENT_LAST_NAMES)
            full_name = f"{first_name} {last_name}"
            email = f"{first_name.lower()}.{last_name.lower()}{student_id}@mail.com"
            phone = f"9{str(student_id).zfill(9)}"
            room_id = rooms[room_pointer][0]
            checkin_date = date.today() - timedelta(days=random.randint(1, 365))
            students.append((full_name, email, phone, room_id, checkin_date))

            # Move to the next room if capacity is filled
            if student_id % rooms[room_pointer][1] == 0:
                room_pointer = (room_pointer + 1) % len(rooms)

        cur.executemany("INSERT INTO Student (name, email, phone, room_id, checkin_date) VALUES (%s, %s, %s, %s, %s)", students)

        # Update room occupancy
        for room_id, capacity in rooms:
            cur.execute("UPDATE Room SET occupied = (SELECT COUNT(*) FROM Student WHERE room_id = %s) WHERE room_id = %s", (room_id, room_id))

        # Insert Maintenance Requests (~2000 entries)
        cur.execute("SELECT student_id FROM Student")
        student_ids = [row[0] for row in cur.fetchall()]
        maintenance_data = []
        for student_id in random.sample(student_ids, 500):  # 500 students with 2-4 requests each
            num_requests = random.randint(2, 4)
            for _ in range(num_requests):
                maintenance_data.append((student_id, random.choice(MAINTENANCE_REQUESTS), random.choice(['Pending', 'Completed'])))

        cur.executemany("INSERT INTO MaintenanceRequest (student_id, description, status) VALUES (%s, %s, %s)", maintenance_data)

        # Insert Fees (~1000 entries)
        fees_data = []
        for student_id in student_ids:
            fees_data.append((student_id, random.randint(5000, 12000), date.today() + timedelta(days=random.randint(15, 90)), random.choice([True, False])))

        cur.executemany("INSERT INTO Fees (student_id, amount, due_date, is_paid) VALUES (%s, %s, %s, %s)", fees_data)

        conn.commit()
        print("✅ Bulk mock data inserted successfully!")

        cur.close()
        conn.close()

    except Exception as e:
        print(f"❌ Error inserting bulk mock data: {e}")

if __name__ == "__main__":
    insert_mock_data()
